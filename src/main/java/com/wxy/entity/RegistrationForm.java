package com.wxy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName registration_form
 */
@TableName(value ="registration_form")
@Data
public class RegistrationForm implements Serializable {
    /**
     * 挂号单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 就诊卡ID
     */
    @TableField(value = "medical_card_id")
    private Integer medicalCardId;

    /**
     * 排班ID
     */
    @TableField(value = "schedule_id")
    private Integer scheduleId;

    /**
     * 用户表主键ID
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 就诊科室表主键ID
     */
    @TableField(value = "department_id")
    private Integer departmentId;

    /**
     * 就诊房间表主键ID
     */
    @TableField(value = "room_id")
    private Integer roomId;

    /**
     * 费用
     */
    @TableField(value = "fee")
    private BigDecimal fee;

    /**
     * 问诊状态（1表示已问诊，2表示未问诊，3表示正在问诊）
     */
    @TableField(value = "consultation_status")
    private Integer consultationStatus;

    /**
     * 问诊时间
     */
    @TableField(value = "consultation_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime consultationTime;

    /**
     * 挂号单创建时间
     */
    @TableField(value = "created_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createdTime;

    /**
     * 修改时间
     */
    @TableField(value = "updated_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updatedTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RegistrationForm other = (RegistrationForm) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMedicalCardId() == null ? other.getMedicalCardId() == null : this.getMedicalCardId().equals(other.getMedicalCardId()))
            && (this.getScheduleId() == null ? other.getScheduleId() == null : this.getScheduleId().equals(other.getScheduleId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getFee() == null ? other.getFee() == null : this.getFee().equals(other.getFee()))
            && (this.getConsultationStatus() == null ? other.getConsultationStatus() == null : this.getConsultationStatus().equals(other.getConsultationStatus()))
            && (this.getConsultationTime() == null ? other.getConsultationTime() == null : this.getConsultationTime().equals(other.getConsultationTime()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMedicalCardId() == null) ? 0 : getMedicalCardId().hashCode());
        result = prime * result + ((getScheduleId() == null) ? 0 : getScheduleId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getFee() == null) ? 0 : getFee().hashCode());
        result = prime * result + ((getConsultationStatus() == null) ? 0 : getConsultationStatus().hashCode());
        result = prime * result + ((getConsultationTime() == null) ? 0 : getConsultationTime().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", medicalCardId=").append(medicalCardId);
        sb.append(", scheduleId=").append(scheduleId);
        sb.append(", userId=").append(userId);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", roomId=").append(roomId);
        sb.append(", fee=").append(fee);
        sb.append(", consultationStatus=").append(consultationStatus);
        sb.append(", consultationTime=").append(consultationTime);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}