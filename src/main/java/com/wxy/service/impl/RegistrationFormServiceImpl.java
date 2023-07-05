package com.wxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxy.entity.RegistrationForm;
import com.wxy.entity.Schedule;
import com.wxy.entity.dto.RegistrationFormDto;
import com.wxy.service.RegistrationFormService;
import com.wxy.mapper.RegistrationFormMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author KONRAD
* @description 针对表【registration_form】的数据库操作Service实现
* @createDate 2023-07-02 17:16:35
*/
@Service
public class RegistrationFormServiceImpl extends ServiceImpl<RegistrationFormMapper, RegistrationForm>
    implements RegistrationFormService{

    @Resource
    RegistrationFormMapper registrationFormMapper;
    @Override
    public List<Schedule> getAllRegistrationForm(RegistrationFormDto registrationFormDto) {
        return registrationFormMapper.getAllRegistrationForm(registrationFormDto);
    }
}




