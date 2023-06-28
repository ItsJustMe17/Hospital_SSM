package com.wxy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName medical_advice
 */
@TableName(value ="medical_advice")
@Data
public class MedicalAdvice implements Serializable {
    /**
     * 医嘱ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 挂号单ID
     */
    @TableField(value = "registration_form_id")
    private Integer registrationFormId;

    /**
     * 病人主诉
     */
    @TableField(value = "chief_complaint")
    private String chiefComplaint;

    /**
     * 诊断情况
     */
    @TableField(value = "diagnosis")
    private String diagnosis;

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
        MedicalAdvice other = (MedicalAdvice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRegistrationFormId() == null ? other.getRegistrationFormId() == null : this.getRegistrationFormId().equals(other.getRegistrationFormId()))
            && (this.getChiefComplaint() == null ? other.getChiefComplaint() == null : this.getChiefComplaint().equals(other.getChiefComplaint()))
            && (this.getDiagnosis() == null ? other.getDiagnosis() == null : this.getDiagnosis().equals(other.getDiagnosis()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRegistrationFormId() == null) ? 0 : getRegistrationFormId().hashCode());
        result = prime * result + ((getChiefComplaint() == null) ? 0 : getChiefComplaint().hashCode());
        result = prime * result + ((getDiagnosis() == null) ? 0 : getDiagnosis().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", registrationFormId=").append(registrationFormId);
        sb.append(", chiefComplaint=").append(chiefComplaint);
        sb.append(", diagnosis=").append(diagnosis);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}