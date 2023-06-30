package com.wxy.entity.dto;

import com.wxy.entity.Schedule;
import lombok.Data;

@Data
public class ScheduleDto extends Schedule {

    private Integer page;

    private Integer limit;

    private String userName; //用户名

    private String roomName; //房间名

    private String deptName; //部门名

}
