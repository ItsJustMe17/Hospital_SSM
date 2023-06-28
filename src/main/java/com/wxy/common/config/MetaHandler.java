package com.wxy.common.config;

import java.time.LocalDateTime;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;


@Component

public class MetaHandler implements MetaObjectHandler {


    /**
     * 新增数据执行
     */

    @Override

    public void insertFill(MetaObject metaObject) {
        System.out.println("--------------切入时间----------" + metaObject);
        boolean hasSetter = metaObject.hasSetter("createdTime");
        if (hasSetter) {
            this.setFieldValByName("createdTime", LocalDateTime.now(), metaObject);
            this.setFieldValByName("updatedTime", LocalDateTime.now(), metaObject);

        }

    }


    /**
     * 更新数据执行
     */

    @Override

    public void updateFill(MetaObject metaObject) {
        Object val = getFieldValByName("updatedTime", metaObject);
        if (val == null) {
            this.setFieldValByName("updatedTime", LocalDateTime.now(), metaObject);
        }
    }

}

