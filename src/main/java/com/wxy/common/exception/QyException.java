package com.wxy.common.exception;

import com.wxy.common.result.ResultEnum;

/**
 * 自定义异常
 *
 */
public class QyException extends RuntimeException {
    public String code;
    public String msg;

    public QyException(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public QyException(ResultEnum resultEnum){
        this.code=resultEnum.getCode();
        this.msg=resultEnum.getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
