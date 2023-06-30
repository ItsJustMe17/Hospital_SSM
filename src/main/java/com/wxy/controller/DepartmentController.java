package com.wxy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxy.common.result.ResultUtils;
import com.wxy.entity.Department;
import com.wxy.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Department)表控制层
 *
 * @author makejava
 * @since 2023-06-29 22:19:58
 */
@RestController
@RequestMapping("department")
public class DepartmentController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentService departmentService;

    @RequestMapping("/getAllDept")
    public Object getAllDept(){
        return ResultUtils.returnDataSuccess(departmentService.list());
    }
}

