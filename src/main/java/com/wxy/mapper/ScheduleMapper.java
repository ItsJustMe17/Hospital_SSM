package com.wxy.mapper;

import com.wxy.entity.Schedule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxy.entity.dto.ScheduleDto;

import java.util.List;

/**
* @author KONRAD
* @description 针对表【schedule】的数据库操作Mapper
* @createDate 2023-06-30 18:22:35
* @Entity com.wxy.entity.Schedule
*/
public interface ScheduleMapper extends BaseMapper<Schedule> {

    List<Schedule> getAllSchedule(ScheduleDto scheduleDto);

}




