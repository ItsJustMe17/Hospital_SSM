package com.wxy.entity.vo;

import com.wxy.entity.Schedule;
import lombok.Data;

@Data
public class ScheduleVo extends Schedule {

    String userName; //用户名

    String roomName; //房间名

    String deptName; //部门名

}
