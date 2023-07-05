<%--
  Created by IntelliJ IDEA.
  User: KONRAD
  Date: 7月2日 0002
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>门诊挂号</title>
    <script src="js/layui/layui.js"></script>
    <link href="js/layui/css/layui.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.staticfile.org/layui/2.5.7/css/layui.css">
</head>

<body>
<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md6 layui-col-md-offset3">
            <form class="layui-form" action="" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">身份证号</label>
                    <div class="layui-input-block">
                        <input type="text" name="idCardNumber" placeholder="请输入身份证号" value="111111111111111111"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="register" type="button">查询</button>
                        <button class="layui-btn layui-btn-primary" id="withExport">刷新</button>
                    </div>
                </div>
                <div id="noPatientInfo" class="layui-hide">
                    <div class="layui-card">
                        <div class="layui-card-header">提示信息</div>
                        <div class="layui-card-body">
                            <p>没有该用户的信息，请创建就诊卡。</p>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%--渲染的表格--%>
<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md6 layui-col-md-offset3">
            <!-- 表格容器 -->
            <table id="MyTable" lay-filter="test"></table>
        </div>
    </div>
</div>

<%--添加方法--%>
<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md6 layui-col-md-offset3">

            <form class="layui-hide layui-form" action="" id="selectForm">
                <div class="layui-form-item">
                    <label class="layui-form-label">所属部门：</label>
                    <div class="layui-input-inline">
                        <select name="departmentId" class="departmentId" lay-filter="departmentId">
                            <option value="">请选择所属部门</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">问诊时间：</label>
                    <div class="layui-input-inline">
                        <input type="text" id="inquiryTime" name="inquiryTime"
                               autocomplete="off"
                               class="layui-input">
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
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="selectFormBtn">查询在班医生</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
            <%--            <form class="layui-hide layui-form" action="" id="addForm">--%>
            <%--                <div class="layui-form-item">--%>
            <%--                    <label class="layui-form-label">所属部门：</label>--%>
            <%--                    <div class="layui-input-inline">--%>
            <%--                        <select name="departmentId" class="departmentId" lay-filter="departmentId">--%>
            <%--                            <option value="">请选择所属部门</option>--%>
            <%--                        </select>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--                <div class="layui-form-item">--%>
            <%--                    <label class="layui-form-label">问诊时间：</label>--%>
            <%--                    <div class="layui-input-inline">--%>
            <%--                        <input type="text" id="inquiryTime" name="inquiryTime"--%>
            <%--                               autocomplete="off"--%>
            <%--                               class="layui-input">--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--                <div class="layui-form-item">--%>
            <%--                    <label class="layui-form-label">时间段：</label>--%>
            <%--                    <div class="layui-input-inline">--%>
            <%--                        上午<input type="radio" name="timeSlot" value="1">--%>
            <%--                        下午<input type="radio" name="timeSlot" value="2">--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--                <div class="layui-form-item">--%>
            <%--                    <label class="layui-form-label">医生姓名：</label>--%>
            <%--                    <div class="layui-input-inline">--%>
            <%--                        <select name="userId" class="layui-select" id="userId">--%>
            <%--                            <option value="" selected="selected">请选择一位医生</option>--%>
            <%--                        </select>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--                <div class="layui-form-item">--%>
            <%--                    <div class="layui-input-block">--%>
            <%--                        <button class="layui-btn" lay-submit lay-filter="addFormBtn">立即提交</button>--%>
            <%--                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </form>--%>

        </div>
    </div>
</div>


<script src="https://cdn.staticfile.org/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/layui/2.5.7/layui.js"></script>

<script>
    layui.use(['form', 'layer', 'table', 'laydate'], function () {
        const table = layui.table;
        const form = layui.form;
        const $ = layui.$;
        const laydate = layui.laydate;
        const layer = layui.layer;


        form.on('submit(selectFormBtn)', function (data) {
            var departmentId = data.field.departmentId;
            var inquiryTime = data.field.inquiryTime;
            var timeSlot = data.field.timeSlot;
            $.get('schedule/getSchedulersByDIT', {
                departmentId: departmentId,
                inquiryTime: inquiryTime,
                timeSlot: timeSlot
            }, function (response) {
                if (response.code == 0) {
                    const arr = res.data;
                    for (let i = 0; i < arr.length; i++) {
                        $(".departmentId").append(' <option value="' + arr[i].id + '">' + arr[i].userName + '</option> ');
                    }
                    form.render('select'); //刷新select选择框渲染
                }
            }, 'json');
            return false;
        });

        // 监听表单提交
        form.on('submit(register)', function (data) {
            var idCard = data.field.idCardNumber;
            $.post('medicalCard/getMedicalCardByIdCard', {idCard: idCard}, function (response) {
                if (response.code == 0) {
                    var patientData = [
                        {field: '就诊卡ID', value: response.data.id},
                        {field: '姓名', value: response.data.patientName},
                        {field: '性别', value: response.data.gender},
                        {field: '手机号', value: response.data.phoneNumber},
                        {field: '出生日期', value: response.data.dateOfBirth},
                        // 根据接口返回的数据格式，添加其他字段和值
                    ];
                    // 渲染病人信息到表格
                    table.render({
                        elem: '#MyTable',
                        cols: [
                            [
                                {field: 'field', title: '字段'},
                                {field: 'value', title: '值'},
                            ],
                        ],
                        data: patientData,
                    });
                    // 初始化日期选择器
                    laydate.render({
                        elem: '#inquiryTime',
                        min: 1, // 只能选择从明天开始的日期
                        max: 7, // 只能选择7天内的日期
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
                    // 显示病人信息
                    $('#patientInfo').removeClass('layui-hide');
                    $('#noPatientInfo').addClass('layui-hide');

                    // 显示查询方法
                    $('#selectForm').removeClass('layui-hide');
                } else if (response.code == 1) {
                    // 不存在病人信息的情况
                    $('#patientInfo').addClass('layui-hide');
                    $('#noPatientInfo').removeClass('layui-hide');

                    // 隐藏查询方法
                    $('#selectForm').addClass('layui-hide');
                }
            }, 'json');

            return false; // 阻止表单提交
        });


    });
</script>
</body>
</html>
