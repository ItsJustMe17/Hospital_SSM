package com.wxy.entity.dto;

import com.wxy.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDto extends User {

    private Integer page;

    private Integer limit;

}
