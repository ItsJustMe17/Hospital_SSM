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
                <input type="text" name="patientName" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">性别：</label>
            <div class="layui-input-inline" style="width: 150px;">
                <select name="gender" class="gender">
                    <option value="">请选择性别</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
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

<%--添加的表单--%>
<form class="layui-form" action="" id="addForm" style="display: none">

    <div class="layui-form-item">
        <label class="layui-form-label">病人姓名：</label>
        <div class="layui-input-inline">
            <input type="text" name="patientName" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">身份证号：</label>
        <div class="layui-input-inline">
            <input type="text" name="idCardNumber" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号：</label>
        <div class="layui-input-inline">
            <input type="text" name="phoneNumber" class="layui-input">
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
        <label class="layui-form-label">病人ID：</label>
        <div class="layui-input-inline">
            <input type="text" name="id" class="layui-input" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">病人姓名：</label>
        <div class="layui-input-inline">
            <input type="text" name="patientName" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">身份证号：</label>
        <div class="layui-input-inline">
            <input type="text" name="idCardNumber" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号：</label>
        <div class="layui-input-inline">
            <input type="text" name="phoneNumber" class="layui-input">
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

        // 时间下拉框
        laydate.render({
            elem: '#updateBirth',
        });// 时间下拉框
        laydate.render({
            elem: '#addBirth',
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


        //表单监听提交--添加
        form.on('submit(addFormBtn)', function (data) {
            //layer.msg(JSON.stringify(data.field));  //   {"sname":"","sex":"","score_min":"","score_max":""}
            $.post("medicalCard/addMedicalCard", data.field, function (res) {
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


        //表单监听提交--修改
        form.on('submit(updateFormBtn)', function (data) {
            //layer.msg(JSON.stringify(data.field));  //   {"sname":"","sex":"","score_min":"","score_max":""}
            $.post("medicalCard/updateMedicalCardById", data.field, function (res) {
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
                        $.post("medicalCard/removeMedicalCardById", obj.data, function (res) {
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
            , url: 'medicalCard/getAllMedicalCard' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'id', title: '病人ID', width: 100, sort: true, fixed: 'left', align: 'center'}
                , {field: 'patientName', title: '病人姓名', width: 100, align: 'center'}
                , {field: 'idCardNumber', title: '身份证号', width: 180, align: 'center'}
                , {field: 'phoneNumber', title: '手机号', width: 120, align: 'center'}
                , {field: 'gender', title: '性别', width: 120, align: 'center'}
                , {field: 'dateOfBirth', title: '出生日期', width: 120, align: 'center'}
                , {title: '操作', width: 130, toolbar: '#toolbarDemo2', fixed: 'right', align: 'center'}

            ]]
        });
    });

</script>
</body>
</html>
