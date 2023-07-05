<%--<html>--%>
<%--<body>--%>
<%--<h2>Hello World!</h2>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>html</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="js/layui/layui.js"></script>
    <link href="js/layui/css/layui.css" rel="stylesheet">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">XY医院管理系统</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!-- 移动端显示 -->
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                <i class="layui-icon layui-icon-spread-left"></i>
            </li>
            <li class="layui-nav-item layui-hide-xs"><a href="javascript:;">nav 1</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="javascript:;">nav 2</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="javascript:;">nav 3</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">nav groups</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">menu 11</a></dd>
                    <dd><a href="javascript:;">menu 22</a></dd>
                    <dd><a href="javascript:;">menu 33</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-sm-inline-block">
                <a href="javascript:;">
                    <img src="https://unpkg.com/outeres@0.0.10/img/layui/icon-v2.png" class="layui-nav-img">
                    <span id="userName"></span>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">Your Profile</a></dd>
                    <dd><a href="javascript:;">修改密码</a></dd>
                    <dd><a href="javascript:" id="logoutBtn">退出登录</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-more-vertical"></i>
                </a>
            </li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">医院管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="UserList.jsp" target="iframeRight">员工列表</a></dd>
                        <dd><a href="ScheduleList.jsp" target="iframeRight">排班管理</a></dd>
                        <dd><a href="javascript:;" target="iframeRight">xxx</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">病人管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="MedicaCardList.jsp" target="iframeRight">病人管理</a></dd>
                        <dd><a href="RegistrationFormList.jsp" target="iframeRight">挂号单管理</a></dd>
                        <dd><a href="VerifyIdCard.jsp" target="iframeRight">门诊挂号</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">

            <blockquote class="layui-elem-quote layui-text">
                欢迎使用XY管理系统
            </blockquote>
            <div class="layui-card layui-panel">
                <div class="layui-card-header">
                    医生信息列表：
                </div>
                <div class="layui-card-body">
                    <iframe src="welcome.jsp" frameborder="0" width="100%" height="800px" name="iframeRight"></iframe>
                </div>
            </div>
            <br><br>
        </div>
    </div>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        底部固定区域
    </div>
</div>

<script>
    //JS
    layui.use(['element', 'layer', 'util'], function () {
        var element = layui.element;
        var layer = layui.layer;
        var util = layui.util;
        var $ = layui.$;

        // 点击退出登录按钮跳转到登陆界面
        $('#logoutBtn').click(function () {
            $.get('user/logout', function () {
                window.location.href = "login.jsp"
            })
        })

        $.get('user/getCurrUserInfo', function (res) {
            if (res.code == 200) {
                // 获取并传入用户名
                $('#userName').html(res.data.userName)
            } else {
                window.location.href = "login.jsp";
            }
        }, 'json')


        //头部事件
        util.event('lay-header-event', {
            menuLeft: function (othis) { // 左侧菜单事件
                layer.msg('展开左侧菜单的操作', {icon: 0});
            },
            menuRight: function () {  // 右侧菜单事件
                layer.open({
                    type: 1
                    , title: '更多'
                    , content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    , area: ['260px', '100%']
                    , offset: 'rt' //右上角
                    , anim: 'slideLeft'
                    , shadeClose: true
                    , scrollbar: false
                });
            }
        });
    });
</script>
</body>
</html>