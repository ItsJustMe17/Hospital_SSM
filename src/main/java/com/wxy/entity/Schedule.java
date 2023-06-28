package com.wxy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName schedule
 */
@TableName(value ="schedule")
@Data
public class Schedule implements Serializable {
    /**
     * 排班ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 房间ID
     */
    @TableField(value = "room_id")
    private Integer roomId;

    /**
     * 时间段
     */
    @TableField(value = "time_slot")
    private String timeSlot;

    /**
     * 就诊总人数
     */
    @TableField(value = "total_patient_count")
    private Integer totalPatientCount;

    /**
     * 剩余就诊人数
     */
    @TableField(value = "remaining_patient_count")
    private Integer remainingPatientCount;

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
        Schedule other = (Schedule) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getTimeSlot() == null ? other.getTimeSlot() == null : this.getTimeSlot().equals(other.getTimeSlot()))
            && (this.getTotalPatientCount() == null ? other.getTotalPatientCount() == null : this.getTotalPatientCount().equals(other.getTotalPatientCount()))
            && (this.getRemainingPatientCount() == null ? other.getRemainingPatientCount() == null : this.getRemainingPatientCount().equals(other.getRemainingPatientCount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getTimeSlot() == null) ? 0 : getTimeSlot().hashCode());
        result = prime * result + ((getTotalPatientCount() == null) ? 0 : getTotalPatientCount().hashCode());
        result = prime * result + ((getRemainingPatientCount() == null) ? 0 : getRemainingPatientCount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", roomId=").append(roomId);
        sb.append(", timeSlot=").append(timeSlot);
        sb.append(", totalPatientCount=").append(totalPatientCount);
        sb.append(", remainingPatientCount=").append(remainingPatientCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}