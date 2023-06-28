package com.wxy.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.wxy.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author KONRAD
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-06-28 21:26:58
* @Entity com.wxy.entity.User
*/
public interface UserMapper extends BaseMapper<User> {

    User findByAccountAndPassword(@Param("account") String account, @Param("password") String password);
}




