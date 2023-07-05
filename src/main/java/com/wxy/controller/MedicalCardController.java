package com.wxy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxy.common.result.ResultUtils;
import com.wxy.common.util.EmptyUtils;
import com.wxy.entity.MedicalCard;
import com.wxy.entity.Schedule;
import com.wxy.entity.User;
import com.wxy.entity.dto.MedicalCardDto;
import com.wxy.entity.dto.UserDto;
import com.wxy.service.MedicalCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * (MedicalCard)表控制层
 *
 * @author makejava
 * @since 2023-06-30 18:57:47
 */
@RestController
@RequestMapping("medicalCard")
public class MedicalCardController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private MedicalCardService medicalCardService;


    @RequestMapping("/getAllMedicalCard")
    public Object getAllUser(MedicalCardDto medicalCardDto) {
        Page<MedicalCard> page = new Page<>(medicalCardDto.getPage(), medicalCardDto.getLimit());
        QueryWrapper<MedicalCard> queryWrapper = new QueryWrapper<>();
        // 条件查询
        if (EmptyUtils.isNotEmpty(medicalCardDto.getPatientName())) {
            queryWrapper.like("patient_name", medicalCardDto.getPatientName());//.like模糊查
        }
        if (EmptyUtils.isNotEmpty(medicalCardDto.getGender())) {
            queryWrapper.eq("gender", medicalCardDto.getGender());//.eq等值查
        }
        queryWrapper.orderByDesc("id");
        Page<MedicalCard> ipage = medicalCardService.page(page, queryWrapper);
        int total = (int) ipage.getTotal();
        List<MedicalCard> records = ipage.getRecords();
        return ResultUtils.returnSuccessLayui(records, total);
    }


    @PostMapping("/getMedicalCardByIdCard")
    public Object getMedicalCardByIdCard(@RequestParam("idCard") String idCard) {
        // 根据身份证号查询病人信息的逻辑
        MedicalCard patient = medicalCardService.getMedicalCardByIdCard(idCard);

//        List<Schedule> schedules = scheduleService.getAllSchedule(scheduleDto);
//        scheduleDto.setLimit(null);
//        scheduleDto.setPage(null);
//        List<Schedule> schedule = scheduleService.getAllSchedule(scheduleDto);
//        return ResultUtils.returnSuccessLayui(schedules, schedule.size());
        if (patient != null) {
            return ResultUtils.returnSuccessLayui(patient, 1);
        } else {
            return ResultUtils.returnFailLayui();
        }
    }


    //添加病人
    @RequestMapping("/addMedicalCard")
    public Object addSchedule(MedicalCard medicalCard) throws ParseException {
        // 通过身份证获取出生年月日
        medicalCard.setDateOfBirth(getBirthDayFromIdCard(medicalCard.getIdCardNumber()));
        // 通过身份证获取性别
        if (getSexFromIdCard(medicalCard.getIdCardNumber()) == 1) {
            medicalCard.setGender("男");
        } else if (getSexFromIdCard(medicalCard.getIdCardNumber()) == 2) {
            medicalCard.setGender("女");
        }

        if (medicalCardService.save(medicalCard)) {
            return ResultUtils.returnSuccess();
        }
        return ResultUtils.returnFail();
    }

    //通过ID进行修改
    @RequestMapping("/updateMedicalCardById")
    public Object updateMedicalCardById(MedicalCard medicalCard) throws ParseException {
        // 通过身份证获取出生年月日
        medicalCard.setDateOfBirth(getBirthDayFromIdCard(medicalCard.getIdCardNumber()));
        // 通过身份证获取性别
        if (getSexFromIdCard(medicalCard.getIdCardNumber()) == 1) {
            medicalCard.setGender("男");
        } else if (getSexFromIdCard(medicalCard.getIdCardNumber()) == 2) {
            medicalCard.setGender("女");
        }
        if (medicalCardService.updateById(medicalCard)) {
            return ResultUtils.returnSuccess();
        } else {
            return ResultUtils.returnFail();
        }
    }

    //通过ID进行删除
    @RequestMapping("/removeMedicalCardById")
    public Object removeMedicalCardById(@RequestParam("id") Integer id) {
        if (medicalCardService.removeById(id)) {
            return ResultUtils.returnSuccess();
        } else {
            return ResultUtils.returnFail();
        }
    }


    /**
     * 获取出生日期
     *
     * @return 返回日期格式
     */
    public Date getBirthDayFromIdCard(String idCard) throws ParseException {
        Date birth = null;
        if (idCard.length() == 18) {
            String year = idCard.substring(6).substring(0, 4);// 得到年份
            String month = idCard.substring(10).substring(0, 2);// 得到月份
            String day = idCard.substring(12).substring(0, 2);// 得到日
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            birth = format.parse(year + "-" + month + "-" + day);
        }
        return birth;
    }

    /**
     * 获取性别
     * 0=未知的性别,9=未说明的性别,2=女性,1=男性
     *
     * @return int
     */
    public int getSexFromIdCard(String idCard) {
        int sex = 9;
        // 身份证号码为空
        if (idCard == "" || idCard.length() <= 0) {
            return sex = 0;
        }
        if (idCard.length() == 18) {
            if (Integer.parseInt(idCard.substring(16).substring(0, 1)) % 2 == 0) {// 判断性别
                sex = 2; // 女
            } else {
                sex = 1; // 男
            }
        }
        return sex;
    }

    /**
     * 根据身份证的号码算出当前身份证持有者的年龄
     *
     * @param
     * @return -1(表示异常) 0 (身份证号码为空)
     * @throws Exception
     */
    public int getAgeForIdcard(String idcard) {
        try {
            int age = 0;
            if (StringUtils.isEmpty(idcard)) {
                return age;
            }

            String birth = "";
            if (idcard.length() == 18) {
                birth = idcard.substring(6, 14);
            } else if (idcard.length() == 15) {
                birth = "19" + idcard.substring(6, 12);
            }

            int year = Integer.valueOf(birth.substring(0, 4));
            int month = Integer.valueOf(birth.substring(4, 6));
            int day = Integer.valueOf(birth.substring(6));
            Calendar cal = Calendar.getInstance();
            age = cal.get(Calendar.YEAR) - year;
            //周岁计算
            if (cal.get(Calendar.MONTH) < (month - 1) || (cal.get(Calendar.MONTH) == (month - 1) && cal.get(Calendar.DATE) < day)) {
                age--;
            }
            return age;
        } catch (Exception e) {
            e.getMessage();
        }
        return -1;
    }


}

