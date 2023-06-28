package com.wxy.common.result;

/**
 * 结果枚举
 *
 */
public enum ResultEnum {
	// 成功
	SUCCESS("200", "成功"), FAIL("0", "失败"), COMMON_EXCEPTION("500", "系统异常"),

	// 用户相关
	FAIL_USER_ACCOUNT_EMPTY("10001", "账号为空"), FAIL_USER_ACCOUNT_EXIST("10002", "账号已存在，请重新输入"),
	FAIL_USER_GET("10003", "查询用户信息失败"), FAIL_USER_ADD_ERROR("10004", "添加用户失败"),
	FAIL_USER_HANDLE_ERROR("10005", "系统管理员禁止禁用"), FAIL_USER_ACCOUNT_ERROR("10022", "用户名错误，用户名仅支持英文、数字、字符"),

	// 文件相关
	FAIL_FILE_EMPTY("40001", "文件为空"), FAIL_FILE_SIZE_ERROR("40002", "文件大小超过50k"),
	FAIL_FILE_SUFFIX_ERROR("40003", "文件格式不符合要求"),

	// 就诊卡相关(挂号)
	PATIENT_ID_CARD_EMPTY("20001", "身份证号为空"), PATIENT_NULL("20002", "就诊卡信息为空"),
	PATIENT_ID_MEDICARE_EMPTY("200014", "就诊卡号为空"), PATIENT_PHONE_ERROR("20015", "请输入正确的手机号"),
	PATIENT_ID_CARD_ERROR("20016", "请输入正确的身份证号"), PATIENT_ID_MEDICARE_ERROR("20017", "请输入正确的医保卡号"),
	// 排期相关(挂号)
	SCHEDULE_PARAM_EMPTY("20003", "查询医生排期参数为空"), SCHEDULE_DOCTOR_EMPTY("20004", "无可用就诊医生，请重新选择时间段"),
	SCHEDULE_SIGN_EMPTY("20008", "请至少选择一个出诊时间段"), SCHEDULE_ADD_ERROR("20009", "号源输入有误(请输入0-100范围)"),
	SCHEDULE_INQUIRY_TIME_ERROR("20010", "出诊时间选择有误"),
	SCHEDULE_CHECK_ROOM_TIME_ERROR("20011", "同一个诊室同一时间段只能有一个出诊信息,请重新选择"),
	SCHEDULE_CHECK_DOCTOR_TIME_ERROR("20012", "同一个医生同一时间段只能有一个出诊,请重新选择"),
	SCHEDULE_CHECK_SIGN_AM_ERROR("20018", "该医生上午已排期,请重新选择"), SCHEDULE_CHECK_SIGN_PM_ERROR("20019", "该医生下午已排期,请重新选择"),
	SCHEDULE_DELETE_ERROR("20021", "删除失败，该出诊记录已有挂号信息！"),
	// 挂号信息管理相关(挂号)
	REGISTER_DEPARTMENT_ID_EMPTY("20005", "就诊科室ID为空"), REGISTER_ID_CARD_ERROR("20013", "请输入正确的身份证号"),
	REGISTER_FAIL("20014", "挂号失败"), REGISTER_CHECK_ERROR("20020", "该患者该时间段已挂过号，请重新选择"),
	// 就诊相关
	REGISTRY_ID_EMPTY("20006", "挂号单ID为空"), FAIL_ADD_MEDICAL_ADVICE("20007", "添加医嘱失败");

	String code;
	String msg;

	ResultEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public static ResultEnum getByCode(String code) {
		if (code == null) {
			return COMMON_EXCEPTION;
		}
		for (ResultEnum outputEnum : ResultEnum.values()) {
			if (code.equals(outputEnum.code)) {
				return outputEnum;
			}
		}
		return COMMON_EXCEPTION;
	}
}
