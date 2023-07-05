package com.wxy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxy.common.result.ResultUtils;
import com.wxy.common.util.EmptyUtils;
import com.wxy.common.util.PasswordUtil;
import com.wxy.entity.User;
import com.wxy.entity.dto.UserDto;
import com.wxy.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    //查询所有用户信息
    @RequestMapping("/getAllUser")
    public Object getAllUser(UserDto userDto) {
        Page<User> p = new Page<>(userDto.getPage(), userDto.getLimit());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (EmptyUtils.isNotEmpty(userDto.getUserName())) {
            queryWrapper.like("user_name", userDto.getUserName());
        }
        if (EmptyUtils.isNotEmpty(userDto.getDepartmentId())) {
            queryWrapper.eq("department_id", userDto.getDepartmentId());
        }
        queryWrapper.orderByDesc("id");
        Page<User> ipage = userService.page(p, queryWrapper);
        int total = (int) ipage.getTotal();
        List<User> records = ipage.getRecords();
        return ResultUtils.returnSuccessLayui(records, total);
    }

    //登录
    @RequestMapping("/login")
    public Object login(User request, HttpSession session) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("account", request.getAccount());
        User one = userService.getOne(userQueryWrapper);
        if (EmptyUtils.isNotEmpty(one)) {
            String salt = one.getSalt();
            String password = PasswordUtil.encode(request.getPassword(), salt);
            if (password.equals(one.getEncryptedPwd())) {
                //登录成功存入一个叫user的内容时该用户信息的session
                session.setAttribute("user", one);
                return ResultUtils.returnSuccess();
            } else {
                return ResultUtils.returnFail("密码不正确");
            }
        } else {
            return ResultUtils.returnFail("账号不存在");
        }
    }

    //获取用户名并，判断是否登录未登录直接跳转到登录页
    @GetMapping("/getCurrUserInfo")
    public Object getCurrUserInfo(HttpSession session) {
        if (EmptyUtils.isNotEmpty(session.getAttribute("user"))) {
            return ResultUtils.returnDataSuccess(session.getAttribute("user"));
        }
        return ResultUtils.returnFail();
    }

    //登出
    @GetMapping("/logout")
    public Object logout(HttpSession session) {
        //清除登陆时存入的session
        session.removeAttribute("user");
        return ResultUtils.returnSuccess();
    }


    @RequestMapping("/addUser")
    public Object addUser(User user) {
        //在PasswordUtil工具类中获取一个随机盐值
        String salt = PasswordUtil.salt();
        //通过这个方法把前端发送过来的密码进行加密处理
        String password = PasswordUtil.encode(user.getPassword(), salt);
        //替换掉刚才输入的密码，存入刚才我们加密后的密码和盐值
        user.setEncryptedPwd(password);
        user.setSalt(salt);
        boolean flag = userService.save(user);
        if (flag) {
            return ResultUtils.returnSuccess();
        } else {
            return ResultUtils.returnFail();
        }
    }
    @RequestMapping("/updateUserById")
    public Object updateUserById(User user) {
        //在PasswordUtil工具类中获取一个随机盐值
        String salt = PasswordUtil.salt();
        //通过这个方法把前端发送过来的密码进行加密处理
        String password = PasswordUtil.encode(user.getPassword(), salt);
        //替换掉刚才输入的密码，存入刚才我们加密后的密码和盐值
        user.setEncryptedPwd(password);
        user.setSalt(salt);
        boolean flag = userService.updateById(user);
        if (flag) {
            return ResultUtils.returnSuccess();
        } else {
            return ResultUtils.returnFail();
        }
    }

    //通过ID进行删除
    @RequestMapping("/removeUserById")
    public Object removeUserById(@RequestParam("id") Integer id) {
        boolean flag = userService.removeById(id);
        if (flag) {
            return ResultUtils.returnSuccess();
        } else {
            return ResultUtils.returnFail();
        }
    }

    @RequestMapping("/getUserByDepartmentId")
    public Object getUserByDepartmentId(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (EmptyUtils.isNotEmpty(user.getDepartmentId())) {
            queryWrapper.eq("department_id", user.getDepartmentId());
        }
        List<User> list = userService.list(queryWrapper);
        return ResultUtils.returnDataSuccess(list);
    }

}

