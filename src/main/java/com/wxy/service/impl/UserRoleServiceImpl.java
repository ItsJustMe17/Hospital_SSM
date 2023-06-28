package com.wxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxy.entity.UserRole;
import com.wxy.service.UserRoleService;
import com.wxy.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author KONRAD
* @description 针对表【user_role】的数据库操作Service实现
* @createDate 2023-06-28 21:26:58
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




