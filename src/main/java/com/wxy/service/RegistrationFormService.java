package com.wxy.service;

import com.wxy.entity.RegistrationForm;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wxy.entity.Schedule;
import com.wxy.entity.dto.RegistrationFormDto;

import java.util.List;

/**
* @author KONRAD
* @description 针对表【registration_form】的数据库操作Service
* @createDate 2023-07-02 17:16:35
*/
public interface RegistrationFormService extends IService<RegistrationForm> {

    List<Schedule> getAllRegistrationForm(RegistrationFormDto registrationFormDto);
}
