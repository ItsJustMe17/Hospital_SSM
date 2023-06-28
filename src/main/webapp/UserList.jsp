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
            <label class="layui-form-label">用户名：</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="username" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-mid">创建时间:</label>
            <div class="layui-input-inline" style="width: 120px;">
                <input type="date" name="beginTime" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-mid">--</label>
            <div class="layui-input-inline" style="width: 120px;">
                <input type="date" name="endTime" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">所属科室：</label>
            <div class="layui-input-inline" style="width: 150px;">
                <select name="departmentId" lay-verify="" class="layui-select">
                    <option selected hidden disabled value="" selected>请选择所属科室</option>
                    <option value="1">内科</option>
                    <option value="2">外科</option>
                    <option value="3">儿科</option>
                    <option value="4">眼科</option>
                </select>
            </div>
        </div>
        <%--    按钮--%>
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

<%--添加的表单--%>
<form class="layui-form" action="" id="addForm" style="display: none">
    <div class="layui-form-item">
        <label class="layui-form-label">所属科室：</label>
        <div class="layui-input-inline">
            <input type="text" name="departmentId" required lay-verify="required" placeholder="请输入所属科室"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">医生名：</label>
        <div class="layui-input-inline">
            <input type="text" name="username" required lay-verify="required" placeholder="请输入医生名"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码：</label>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">创建时间：</label>
        <div class="layui-input-inline">
            <input type="text" name="createdTime" id="createdTime" readonly lay-verify="required"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">创建人：</label>
        <div class="layui-input-inline">
            <input type="text" name="creator" required lay-verify="required" placeholder="请输入创建人"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">状态：</label>
        <div class="layui-input-inline">
            <select name="status" lay-verify="" class="layui-select">
                <option selected hidden disabled value="" selected>请选择目前的状态</option>
                <option value="0">启用</option>
                <option value="1">禁用</option>
            </select>
        </div>

    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户类型：</label>
        <div class="layui-input-inline">
            <select name="userType" lay-verify="" class="layui-select">
                <option selected hidden disabled value="" selected>请选择用户类型</option>
                <option value="1">系统管理员</option>
                <option value="2">挂号员</option>
                <option value="3">门诊医师</option>
                <option value="4">收银员</option>
                <option value="4">药方医师</option>
            </select>
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
        <label class="layui-form-label">医生ID</label>
        <div class="layui-input-inline">
            <input type="text" name="id" readonly autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">所属科室ID：</label>
        <div class="layui-input-inline">
            <input type="text" name="departmentId" required lay-verify="required" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">医生名：</label>
        <div class="layui-input-inline">
            <input type="text" name="username" required lay-verify="required" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码：</label>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="请输入标题"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">修改时间：</label>
        <div class="layui-input-inline">
            <input type="text" name="modifiedTime" id="modifiedTime"  readonly lay-verify="required"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">状态：</label>
        <div class="layui-input-inline">
            <select name="status" lay-verify="" class="layui-select-inline">
                <option selected hidden disabled value="" selected>请选择目前的状态</option>
                <option value="0">启用</option>
                <option value="1">禁用</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户类型：</label>
        <div class="layui-input-inline">
            <select name="userType" lay-verify="" class="layui-select-inline">
                <option selected hidden disabled>请选择用户类型</option>
                <option value="1">系统管理员</option>
                <option value="2">挂号员</option>
                <option value="3">门诊医师</option>
                <option value="4">收银员</option>
                <option value="4">药方医师</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="updateFormBtn">确认修改</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<%--脚本--%>
<script>
    layui.use(['table', 'form', 'laydate'], function () {
        var table = layui.table;
        var form = layui.form;
        var $ = layui.$;
        var laydate = layui.laydate;

        // 获取当前时间
        laydate.render({
            elem: '#createdTime',// input里时间的Id
            value: new Date(),
            done: function (value, date) {
            }
        });

        // 获取当前时间
        laydate.render({
            elem: '#modifiedTime',// input里时间的Id
            value: new Date(),
            done: function (value, date) {
            }
        });

        //表单监听提交--添加
        form.on('submit(addFormBtn)', function (data) {
            //layer.msg(JSON.stringify(data.field));  //   {"sname":"","sex":"","score_min":"","score_max":""}
            $.post("doctors/addDoctorLayui", data.field, function (res) {
                if (res.code == 0) {
                    layer.msg('添加成功', {
                        icon: 1,
                        time: 1000 //2秒关闭（如果不配置，默认是3秒）
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
            $.post("doctors/updateDoctorLayui", data.field, function (res) {
                if (res.code == 0) {
                    layer.msg('修改成功', {
                        icon: 1,
                        time: 1000 //2秒关闭（如果不配置，默认是3秒）
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
                        $.post("doctors/delete", obj.data, function (res) {
                            if (res.code == 0) {
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
            , url: 'user/getAllUser' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'departmentId', title: '科室ID', width: 80}
                , {field: 'username', title: '用户名', width: 120,}
                , {field: 'password', title: '密码', width: 120}
                , {field: 'createdTime', title: '创建时间', width: 180}
                , {field: 'modifiedTime', title: '修改时间', width: 180,}
                , {field: 'creator', title: '创建人', width: 120,}
                , {
                    field: 'status', title: '状态', width: 80, templet: function (d) {
                        if (d.status === 0) {
                            return '<div style="color:#5FB878;" >启用</div>';
                        } else if (d.status === 1) {
                            return '<div style="color:#FF5722;" >禁用</div>';
                        } else {
                            return '<div style="color:#555555;" >未定义</div>';
                        }
                    }
                }
                , {
                    field: 'userType', title: '用户类型', width: 100,
                    templet: function (d) {
                        if (d.userType === 1) {
                            return '<div style="color:#5FB878;" >系统管理员</div>';
                        } else if (d.userType === 2) {
                            return '<div style="color:#FF5722;" >挂号员</div>';
                        } else if (d.userType === 3) {
                            return '<div style="color:#FFB800;" >门诊医师</div>';
                        } else if (d.userType === 4) {
                            return '<div style="color:#1E9FFF;" >收银员</div>';
                        } else if (d.userType === 5) {
                            return '<div style="color:#a552d2;" >药方医师</div>';
                        } else {
                            return '<div style="color:#555555;" >未定义</div>';
                        }
                    }
                }
                , {title: '操作', width: 200, toolbar: '#toolbarDemo2'}

            ]]
        });
    });

</script>
</body>
</html>
