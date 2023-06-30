package com.wxy.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.wxy.common.result.ResultUtils;
import com.wxy.common.util.PasswordUtil;
import com.wxy.entity.Schedule;
import com.wxy.entity.User;
import com.wxy.entity.dto.ScheduleDto;
import com.wxy.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Schedule)表控制层
 *
 * @author makejava
 * @since 2023-06-30 11:23:37
 */
@RestController
@RequestMapping("schedule")
public class ScheduleController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ScheduleService scheduleService;

    //查询所有排版记录
    @GetMapping("/getScheduleList")
    public Object getList(ScheduleDto scheduleDto) {
        List<Schedule> schedules = scheduleService.getAllSchedule(scheduleDto);
        scheduleDto.setLimit(null);
        scheduleDto.setPage(null);
        List<Schedule> schedule = scheduleService.getAllSchedule(scheduleDto);
        return ResultUtils.returnSuccessLayui(schedules, schedule.size());
    }

    //添加排版记录
    @RequestMapping("/addSchedule")
    public Object addSchedule(Schedule schedule) {
        schedule.setRemainingPatientCount(schedule.getTotalPatientCount());
        if (scheduleService.save(schedule)) {
            return ResultUtils.returnSuccess();
        }
        return ResultUtils.returnFail();
    }

//    //添加排版记录(多个时间添加)
//    @RequestMapping("/addSchedule1")
//    public Object addSchedule1(Schedule schedule, @RequestParam("inquiryTimeArr") String inquiryTimeArr) {
//        schedule.setRemainingPatientCount(schedule.getTotalPatientCount());
//        if (scheduleService.saveBatchByInquiry(schedule, inquiryTimeArr)) {
//            return ResultUtils.returnSuccess();
//        }
//        return ResultUtils.returnFail();
//    }

    //通过ID进行修改
    @RequestMapping("/updateScheduleById")
    public Object updateScheduleById(Schedule schedule) {
        schedule.setRemainingPatientCount(schedule.getTotalPatientCount());
        if (scheduleService.updateById(schedule)) {
            return ResultUtils.returnSuccess();
        } else {
            return ResultUtils.returnFail();
        }
    }

    //通过ID进行删除
    @RequestMapping("/removeScheduleById")
    public Object removeScheduleById(@RequestParam("id") Integer id) {
        if (scheduleService.removeById(id)) {
            return ResultUtils.returnSuccess();
        } else {
            return ResultUtils.returnFail();
        }
    }

}

