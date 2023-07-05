package com.wxy.entity.vo;

import com.wxy.entity.RegistrationForm;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RegistrationFormVo extends RegistrationForm {

    private String userName; //用户名

    private String roomName; //房间名

    private String deptName; //部门名

    private String patientName; //病人名

    private String sex; //病人性别

    private String idCard; //病人身份证

    private String inquiryTime; //问诊时间

    private String timeSlot; //就诊时间段

}
