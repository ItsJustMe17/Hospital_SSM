package com.wxy.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxy.entity.User;
import com.wxy.mapper.UserMapper;
import com.wxy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author KONRAD
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-06-28 21:26:58
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User findByAccountAndPassword(String account, String password) {
        return userMapper.findByAccountAndPassword(account,password);
    }
}




