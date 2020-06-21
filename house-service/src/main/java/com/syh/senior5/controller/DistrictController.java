package com.syh.senior5.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.xml.internal.bind.v2.model.core.ID;
import com.syh.senior5.entity.District;
import com.syh.senior5.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 宋英辉
 * @since 2020-06-21
 */
@RestController
@RequestMapping("/district")
public class DistrictController  {
 @Autowired
 private IDistrictService iDistrictService;
    @RequestMapping("list")
    public List<District> list(@RequestParam(name="id",defaultValue = "1")Integer id){
        QueryWrapper<District> districtQueryWrapper = new QueryWrapper<>();

        districtQueryWrapper.eq("pid",id);
        return iDistrictService.list(districtQueryWrapper);
    }
}
