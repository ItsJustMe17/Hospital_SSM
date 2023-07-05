package com.wxy.service;

import com.wxy.entity.MedicalCard;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author KONRAD
* @description 针对表【medical_card】的数据库操作Service
* @createDate 2023-07-02 16:20:16
*/
public interface MedicalCardService extends IService<MedicalCard> {

    MedicalCard getMedicalCardByIdCard(String idCard);
}
