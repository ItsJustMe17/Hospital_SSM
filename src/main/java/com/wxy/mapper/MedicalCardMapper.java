package com.wxy.mapper;

import com.wxy.entity.MedicalCard;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author KONRAD
* @description 针对表【medical_card】的数据库操作Mapper
* @createDate 2023-07-02 16:20:16
* @Entity com.wxy.entity.MedicalCard
*/
public interface MedicalCardMapper extends BaseMapper<MedicalCard> {

    MedicalCard getMedicalCardByIdCard(String idCard);
}




