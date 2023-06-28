package com.wxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxy.entity.Room;
import com.wxy.service.RoomService;
import com.wxy.mapper.RoomMapper;
import org.springframework.stereotype.Service;

/**
* @author KONRAD
* @description 针对表【room】的数据库操作Service实现
* @createDate 2023-06-28 21:26:58
*/
@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room>
    implements RoomService{

}




