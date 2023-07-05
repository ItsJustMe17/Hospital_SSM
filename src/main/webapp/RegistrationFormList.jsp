<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="js/layui/layui.js"></script>
    <link href="js/layui/css/layui.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<!-- 查询条件DIV-->
<form class="layui-form" action="">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">就诊科室：</label>
            <div class="layui-input-inline" style="width: 150px;">
                <select name="departmentId" class="departmentId">
                    <option value="">请选择就诊科室</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">病人名：</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="patientName" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">医生名：</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="userName" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">问诊状态：</label>
            <div class="layui-input-inline" style="width: 100px;">
                <select name="consultationStatus" class="layui-select">
                    <option value="" >请选择问诊状态</option>
                    <option value="1">已问诊</option>
                    <option value="2">未问诊</option>
                    <option value="3">正在问诊</option>
                </select>
            </div>
        </div>
        <%-- 按钮--%>
        <div class="layui-inline">
            <button class="layui-btn" lay-submit="" lay-filter="formDemo">
                <i class="layui-icon">&#xe615;</i>搜索
            </button>
            <button type="reset" class="layui-btn layui-btn-primary">
                <i class="layui-icon">&#xe666;</i>重置
            </button>
        </div>
    </div>
</form>

<%--添加的表单--%>
<form class="layui-form" action="" id="addForm" style="display: none">

    <div class="layui-form-item">
        <label class="layui-form-label">所属部门：</label>
        <div class="layui-input-inline">
            <select name="departmentId" class="departmentId" lay-filter="departmentId">
                <option value="">请选择所属部门</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名：</label>
        <div class="layui-input-inline">
            <select name="userId" class="layui-select" id="userId">
                <option value="" selected="selected">请选择工作人员</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">房间：</label>
        <div class="layui-input-inline">
            <select name="roomId" class="layui-select" id="roomId">
                <option value="">请选择房间</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">问诊时间：</label>
        <div class="layui-input-inline">
            <input type="text" id="inquiryTime" name="inquiryTime"
                   autocomplete="off"
                   class="layui-input">
            <%--            <div id="inquiryTime">--%>

            <%--            </div>--%>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">时间段：</label>
        <div class="layui-input-inline">
            上午<input type="radio" name="timeSlot" value="1">
            下午<input type="radio" name="timeSlot" value="2">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">就诊总人数：</label>
        <div class="layui-input-inline">
            <input type="text" name="totalPatientCount" class="layui-input" value="30">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="addFormBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>


<%--修改的表单--%>
<form class="layui-form" action="" id="updateForm" lay-filter="updateForm" style="display: none">
    <div class="layui-form-item">
        <label class="layui-form-label">排班ID：</label>
        <div class="layui-input-inline">
            <input type="text" name="id" class="layui-input" value="30">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">就诊总人数：</label>
        <div class="layui-input-inline">
            <input type="text" name="totalPatientCount" class="layui-input" value="30">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="updateFormBtn">确认修改</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<%-- 表格 --%>
<table id="demo" lay-filter="test"></table>


<%--头部工具条--%>
<script type="text/html" id="toolbarDemo1">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
    </div>
</script>

<%--行内工具条--%>
<script type="text/html" id="toolbarDemo2">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
        <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
    </div>
</script>


<%--脚本--%>
<script>
    layui.use(['table', 'form', 'laydate'], function () {
        const table = layui.table;
        const form = layui.form;
        const $ = layui.$;
        const laydate = layui.laydate;

        // var time = new Date();
        // var inquiryTimeArr = new Array();
        // var s = '';
        // for (var i = 1; i <= 7; i++) {
        //     time.setDate(time.getDate() + 1)
        //     s = DateUtil.formatDateTime(time, date_formate.normDatePattern);
        //     $("#inquiryTime").append(' <input type="checkbox" name="inquiryTimeArr" value="' + s + '" title="' + s + '">')
        //     inquiryTimeArr.push(s);
        // }
        // form.render(); //更新全部

        form.on('select(departmentId)', function (data) {
            getUserByDepartmentId(data.value);
            getRoomByDepartmentId(data.value);
        });
        window.getUserByDepartmentId = function (deptId) {
            $.get("user/getUserByDepartmentId", {'departmentId': deptId}, function (res) {
                if (res.code == 200) {
                    $("#userId").html('')//滞空数据
                    const arr = res.data;
                    for (let i = 0; i < arr.length; i++) {
                        $("#userId").append(' <option value="' + arr[i].id + '">' + arr[i].userName + '</option> ');
                    }
                    form.render('select'); //刷新select选择框渲染
                }
            }, "json")
        }
        window.getRoomByDepartmentId = function (deptId) {
            $.get("room/getRoomByDepartmentId", {'departmentId': deptId}, function (res) {
                if (res.code == 200) {
                    $("#roomId").html('')//滞空数据
                    const arr = res.data;
                    for (let i = 0; i < arr.length; i++) {
                        $("#roomId").append(' <option value="' + arr[i].id + '">' + arr[i].roomName + '</option> ');
                    }
                    form.render('select'); //刷新select选择框渲染
                }
            }, "json")
        }
        getUserByDepartmentId('');
        getRoomByDepartmentId('');


        // 时间下拉框
        laydate.render({
            elem: '#inquiryTime',
            min: 1,
            max: 7,
        });


        //发送ajax请求获取部门表的数据,渲染在部门的下拉列表中
        $.get("department/getAllDept", {}, function (res) {
            if (res.code == 200) {
                const arr = res.data;
                for (let i = 0; i < arr.length; i++) {
                    $(".departmentId").append(' <option value="' + arr[i].id + '">' + arr[i].departmentName + '</option> ');
                }
                form.render('select'); //刷新select选择框渲染
            }
        }, "json");

        //表单监听提交--添加
        form.on('submit(addFormBtn)', function (data) {
            //layer.msg(JSON.stringify(data.field));  //   {"sname":"","sex":"","score_min":"","score_max":""}
            $.post("registrationForm/addSchedule", data.field, function (res) {
                if (res.code == 200) {
                    layer.msg('添加成功', {
                        icon: 1,
                        time: 1000 //1秒关闭（如果不配置，默认是3秒）
                    }, function () {
                        layer.closeAll();  //关闭所有弹窗
                        table.reload("idTest")
                    });
                }
            }, "json")
            return false;
        });

        /*
            条件查询
        */
        form.on('submit(formDemo)', function (data) {
            var field = data.field;
            //执行重载
            table.reload('idTest', {
                page: {curr: 1},
                where: field //设定异步数据接口的额外参数
                // where: data.field
            });
            return false;
        });


        //表单监听提交--修改
        form.on('submit(updateFormBtn)', function (data) {
            //layer.msg(JSON.stringify(data.field));  //   {"sname":"","sex":"","score_min":"","score_max":""}
            $.post("registrationForm/updateScheduleById", data.field, function (res) {
                if (res.code == 200) {
                    layer.msg('修改成功', {
                        icon: 1,
                        time: 1000 //1秒关闭（如果不配置，默认是3秒）
                    }, function () {
                        layer.closeAll();  //关闭所有弹窗
                        table.reload("idTest")
                    });
                }
            }, "json")
            return false;
        });
        //触发事件---头部工具条监听
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'add':
                    //layer.msg('添加');
                    layer.open({
                        type: 1,
                        title: '添加',
                        area: ['600px', '500px'],
                        content: $('#addForm') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                    });
                    break;
            }
        });
        //触发事件---行内工具条监听
        table.on('tool(test)', function (obj) {
            switch (obj.event) {
                case 'delete':
                    layer.confirm('真的删除行么', function (index) {
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        //向服务端发送删除指令
                        $.post("registrationForm/removeScheduleById", obj.data, function (res) {
                            if (res.code == 200) {
                                layer.msg("删除成功")
                            }
                        }, "json")
                    });
                    break;
                case 'update':
                    form.val("updateForm", obj.data)
                    layer.open({
                        type: 1,
                        title: '修改',
                        area: ['600px', '500px'],
                        content: $('#updateForm') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                    });
                    break;
            }

        });


        //第一个实例
        table.render({
            id: 'idTest'
            , elem: '#demo'
            , toolbar: '#toolbarDemo1'
            , url: 'registrationForm/getAllRegistrationForm' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                  {field: 'id', title: '挂号单ID', width: 100, sort: true, fixed: 'left', align: 'center'}
                , {field: 'patientName', title: '病人名', width: 100, align: 'center'}
                , {field: 'sex', title: '性别', width: 100, align: 'center'}
                , {field: 'idCard', title: '身份证号', width: 120, align: 'center'}
                , {field: 'deptName', title: '科室', width: 120, align: 'center'}
                , {field: 'roomName', title: '房间', width: 120, align: 'center'}
                , {field: 'userName', title: '医生名', width: 120, align: 'center'}
                , {field: 'inquiryTime', title: '问诊时间', width: 120, align: 'center'}
                , {
                    field: 'timeSlot', title: '时间段（上午，下午）', width: 180, align: 'center',
                    templet: function (d) {
                        if (d.timeSlot === 1) {
                            return '<div style="color:#5FB878;" >上午</div>';
                        } else if (d.timeSlot === 2) {
                            return '<div style="color:#FF5722;" >下午</div>';
                        } else {
                            return '<div style="color:#555555;" >未定义</div>';
                        }
                    }
                }
                , {field: 'consultationStatus', title: '问诊状态', width: 120, align: 'center'}
                , {title: '操作', width: 130, toolbar: '#toolbarDemo2', align: 'center', fixed: 'right'}

            ]]
        });
    });

</script>
</body>
</html>
