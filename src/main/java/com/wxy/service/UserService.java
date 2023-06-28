package com.wxy.service;

import com.wxy.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wxy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
* @author KONRAD
* @description 针对表【user】的数据库操作Service
* @createDate 2023-06-28 21:26:58
*/
public interface UserService extends IService<User> {

    User findByAccountAndPassword(String account, String password);
}
