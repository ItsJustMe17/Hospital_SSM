package com.wxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxy.entity.Role;
import com.wxy.service.RoleService;
import com.wxy.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author KONRAD
* @description 针对表【role】的数据库操作Service实现
* @createDate 2023-06-28 21:26:58
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




