package com.wxy.entity.dto;

import com.wxy.entity.MedicalCard;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MedicalCardDto extends MedicalCard {

    private Integer page;

    private Integer limit;

}
