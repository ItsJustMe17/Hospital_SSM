package com.wxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxy.entity.Menu;
import com.wxy.service.MenuService;
import com.wxy.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
* @author KONRAD
* @description 针对表【menu】的数据库操作Service实现
* @createDate 2023-06-28 21:26:58
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

}




