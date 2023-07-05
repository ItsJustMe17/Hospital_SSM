package com.wxy.mapper;

import com.wxy.entity.RegistrationForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxy.entity.Schedule;
import com.wxy.entity.dto.RegistrationFormDto;

import java.util.List;

/**
* @author KONRAD
* @description 针对表【registration_form】的数据库操作Mapper
* @createDate 2023-07-02 17:16:35
* @Entity com.wxy.entity.RegistrationForm
*/
public interface RegistrationFormMapper extends BaseMapper<RegistrationForm> {

    List<Schedule> getAllRegistrationForm(RegistrationFormDto registrationFormDto);
}




