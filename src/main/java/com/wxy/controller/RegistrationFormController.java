package com.wxy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxy.common.result.ResultUtils;
import com.wxy.entity.RegistrationForm;
import com.wxy.entity.Schedule;
import com.wxy.entity.dto.RegistrationFormDto;
import com.wxy.entity.dto.ScheduleDto;
import com.wxy.service.RegistrationFormService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (RegistrationForm)表控制层
 *
 * @author makejava
 * @since 2023-07-02 17:15:09
 */
@RestController
@RequestMapping("registrationForm")
public class RegistrationFormController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private RegistrationFormService registrationFormService;
    @GetMapping("/getAllRegistrationForm")
    public Object getList(RegistrationFormDto registrationFormDto) {
        List<Schedule> registrationForms = registrationFormService.getAllRegistrationForm(registrationFormDto);
        registrationFormDto.setLimit(null);
        registrationFormDto.setPage(null);
        List<Schedule> registrationForm = registrationFormService.getAllRegistrationForm(registrationFormDto);
        return ResultUtils.returnSuccessLayui(registrationForms, registrationForm.size());
    }

}

