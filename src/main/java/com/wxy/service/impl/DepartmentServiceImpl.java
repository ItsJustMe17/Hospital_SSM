package com.wxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxy.entity.Department;
import com.wxy.service.DepartmentService;
import com.wxy.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

/**
* @author KONRAD
* @description 针对表【department】的数据库操作Service实现
* @createDate 2023-06-29 23:04:40
*/
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department>
    implements DepartmentService{

}




