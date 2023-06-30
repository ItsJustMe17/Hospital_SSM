package com.wxy.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxy.entity.MedicalCard;
import com.wxy.service.MedicalCardService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
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




    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param medicalCard 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<MedicalCard> page, MedicalCard medicalCard) {
        return success(this.medicalCardService.page(page, new QueryWrapper<>(medicalCard)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.medicalCardService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param medicalCard 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody MedicalCard medicalCard) {
        return success(this.medicalCardService.save(medicalCard));
    }

    /**
     * 修改数据
     *
     * @param medicalCard 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody MedicalCard medicalCard) {
        return success(this.medicalCardService.updateById(medicalCard));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.medicalCardService.removeByIds(idList));
    }
}

