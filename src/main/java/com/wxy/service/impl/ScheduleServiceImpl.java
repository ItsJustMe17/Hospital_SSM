package com.wxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxy.entity.Schedule;
import com.wxy.entity.dto.ScheduleDto;
import com.wxy.service.ScheduleService;
import com.wxy.mapper.ScheduleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author KONRAD
 * @description 针对表【schedule】的数据库操作Service实现
 * @createDate 2023-06-30 18:22:35
 */
@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule>
        implements ScheduleService {

    @Resource
    ScheduleMapper scheduleMapper;

    @Override
    public List<Schedule> getAllSchedule(ScheduleDto scheduleDto) {
        return scheduleMapper.getAllSchedule(scheduleDto);
    }

    @Override
    public List<ScheduleDto> getSchedulersByDIT(String departmentId, String inquiryTime, String timeSlot) {
        return scheduleMapper.getSchedulersByDIT(departmentId,inquiryTime,timeSlot);
    }


//    @Override
//    public boolean saveBatchByInquiry(Schedule schedule, String inquiryTimeArr) {
//        System.out.println(inquiryTimeArr + "----------------------");
//        String[] arr = inquiryTimeArr.split(",");
//        List<String> list = new ArrayList<>();
//        //写逻辑： 同一个时间段，同一个医生不能出现
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("time_slot", schedule.getTimeSlot());
//        queryWrapper.eq("user_id", schedule.getUserId());
//        for (String time : arr) {
//            queryWrapper.eq("inquiry_time", time);
//            List<Schedule> scheduleList = scheduleMapper.selectList(queryWrapper);
//            if (EmptyUtils.isNotEmpty(scheduleList) && scheduleList.size() > 1) {
//                continue;
//            }
//            list.add(time);
//        }
//
//        //写逻辑：同一个时间段，同一个房间，不能重复
//        QueryWrapper queryWrapper2 = new QueryWrapper();
//        queryWrapper2.eq("time_slot", schedule.getTimeSlot());
//        queryWrapper2.eq("user_id", schedule.getUserId());
//        for (String time : list) {
//            queryWrapper2.eq("inquiry_time", time);
//            List<Schedule> scheduleList = scheduleMapper.selectList(queryWrapper2);
//            if (EmptyUtils.isNotEmpty(scheduleList) && scheduleList.size() > 1) {
//                list.remove(time);
//                continue;
//            }
//        }
//
//        int num = 0;
//        for (String time : list) {
//            Date date = DateUtils.parseDate(time, DateUtils.YYYY_MM_DD);
//            schedule.setInquiryTime((java.sql.Date) date);
//            if (scheduleMapper.insert(schedule) > 0) {
//                num++;
//            }
//        }
//        return num > 0;
//    }

}




