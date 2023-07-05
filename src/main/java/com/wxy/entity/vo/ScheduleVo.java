package com.wxy.entity.vo;

import com.wxy.entity.Schedule;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ScheduleVo extends Schedule {

    private String userName; //用户名

    private String roomName; //房间名

    private String deptName; //部门名

}
