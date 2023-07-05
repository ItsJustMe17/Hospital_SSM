package com.wxy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxy.common.result.ResultUtils;
import com.wxy.common.util.EmptyUtils;
import com.wxy.entity.Room;
import com.wxy.entity.User;
import com.wxy.service.RoomService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Room)表控制层
 *
 * @author makejava
 * @since 2023-06-30 16:31:16
 */
@RestController
@RequestMapping("room")
public class RoomController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private RoomService roomService;


    @RequestMapping("/getRoomByDepartmentId")
    public Object getUserByDepartmentId(Room room) {
        QueryWrapper<Room> queryWrapper = new QueryWrapper<>();
        if (EmptyUtils.isNotEmpty(room.getDepartmentId())) {
            queryWrapper.eq("department_id", room.getDepartmentId());
        }
        List<Room> list = roomService.list(queryWrapper);
        return ResultUtils.returnDataSuccess(list);
    }

}

