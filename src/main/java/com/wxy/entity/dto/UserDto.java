package com.wxy.entity.dto;

import com.wxy.entity.User;
import lombok.Data;

@Data
public class UserDto extends User {

    private Integer page;

    private Integer limit;

}
