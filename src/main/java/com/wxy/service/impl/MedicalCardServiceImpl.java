package com.wxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxy.entity.MedicalCard;
import com.wxy.service.MedicalCardService;
import com.wxy.mapper.MedicalCardMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author KONRAD
* @description 针对表【medical_card】的数据库操作Service实现
* @createDate 2023-07-02 16:20:16
*/
@Service
public class MedicalCardServiceImpl extends ServiceImpl<MedicalCardMapper, MedicalCard>
    implements MedicalCardService{

    @Resource
    MedicalCardMapper medicalCardMapper;
    @Override
    public MedicalCard getMedicalCardByIdCard(String idCard) {
        return medicalCardMapper.getMedicalCardByIdCard(idCard);
    }
}




