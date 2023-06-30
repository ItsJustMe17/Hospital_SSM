package com.wxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxy.entity.User;
import com.wxy.service.UserService;
import com.wxy.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author KONRAD
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-06-29 23:39:49
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




