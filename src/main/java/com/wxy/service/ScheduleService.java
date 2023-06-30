package com.wxy.service;

import com.wxy.entity.Schedule;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wxy.entity.dto.ScheduleDto;

import java.util.List;

/**
* @author KONRAD
* @description 针对表【schedule】的数据库操作Service
* @createDate 2023-06-30 18:22:35
*/
public interface ScheduleService extends IService<Schedule> {

    List<Schedule> getAllSchedule(ScheduleDto scheduleDto);

//    boolean saveBatchByInquiry(Schedule schedule, String inquiryTimeArr);


}
