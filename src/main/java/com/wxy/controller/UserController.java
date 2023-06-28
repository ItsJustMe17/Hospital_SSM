package com.wxy.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxy.common.result.Result;
import com.wxy.common.result.ResultUtils;
import com.wxy.entity.User;
import com.wxy.entity.dto.UserDto;
import com.wxy.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @RequestMapping("/getAllUser")
    public Object getAllUser(UserDto userDto) {
        List<User> list = userService.list();
        return ResultUtils.returnSuccessLayui(list, list.size());
    }

    @RequestMapping("/login")
    public String login(@RequestBody User request) {
        User user = userService.findByAccountAndPassword(request.getAccount(), request.getPassword());
        if (user != null) {
            return "success"; // 登录成功，返回标识字符串
        } else {
            return "failure"; // 登录失败，返回标识字符串
        }
    }

}

