package com.wxy.common.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxy.common.result.Result;
import com.wxy.common.result.ResultUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class SystemExceptionHandler {
	/***
	 * 处理自定义异常
	 * 
	 * @param cause
	 * @param request
	 * @param response
	 * @return
	 */
	@ExceptionHandler(QyException.class)
	@ResponseBody
	public Result processQySurveyException(Throwable cause, HttpServletRequest request, HttpServletResponse response) {
		QyException qyException = null;
		if (cause instanceof QyException) {
			qyException = (QyException) cause;
		}
		return ResultUtils.returnFail(qyException.msg, qyException.code);
	}

	/***
	 * 处理系统异常
	 * 
	 * @param cause
	 * @param request
	 * @param response
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result processException(Throwable cause, HttpServletRequest request, HttpServletResponse response) {
		cause.printStackTrace();
		return ResultUtils.returnFail();
	}
}
