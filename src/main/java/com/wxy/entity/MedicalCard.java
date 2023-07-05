package com.wxy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @TableName medical_card
 */
@TableName(value = "medical_card")
@Data
public class MedicalCard implements Serializable {
    /**
     * 就诊卡ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 病人姓名
     */
    @TableField(value = "patient_name")
    private String patientName;

    /**
     * 身份证号
     */
    @TableField(value = "id_card_number")
    private String idCardNumber;

    /**
     * 手机号
     */
    @TableField(value = "phone_number")
    private String phoneNumber;

    /**
     * 性别
     */
    @TableField(value = "gender")
    private String gender;

    /**
     * 出生日期
     */
    @TableField(value = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date dateOfBirth;

    /**
     * 创建时间
     */
    @TableField(value = "created_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;

    /**
     * 修改时间
     */
    @TableField(value = "updated_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedTime;

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
        MedicalCard other = (MedicalCard) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPatientName() == null ? other.getPatientName() == null : this.getPatientName().equals(other.getPatientName()))
                && (this.getIdCardNumber() == null ? other.getIdCardNumber() == null : this.getIdCardNumber().equals(other.getIdCardNumber()))
                && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
                && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
                && (this.getDateOfBirth() == null ? other.getDateOfBirth() == null : this.getDateOfBirth().equals(other.getDateOfBirth()))
                && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
                && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPatientName() == null) ? 0 : getPatientName().hashCode());
        result = prime * result + ((getIdCardNumber() == null) ? 0 : getIdCardNumber().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getDateOfBirth() == null) ? 0 : getDateOfBirth().hashCode());
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
        sb.append(", patientName=").append(patientName);
        sb.append(", idCardNumber=").append(idCardNumber);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", gender=").append(gender);
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}