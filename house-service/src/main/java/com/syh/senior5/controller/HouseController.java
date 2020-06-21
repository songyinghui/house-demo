package com.syh.senior5.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.syh.senior5.entity.*;
import com.syh.senior5.service.IDistrictService;
import com.syh.senior5.service.IHouseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 宋英辉
 * @since 2020-06-21
 */
@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private IHouseService iHouseService;
    @Autowired
    private IDistrictService iDistrictService;

    @RequestMapping("houses")
    public PageInfo<HouseVo> houses(HouseVo houseVo, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize) {

        if (houseVo.getRooms().equals("不限")) {
            houseVo.setRoom(null);
        } else if (houseVo.getRooms().equals("一室")) {
            houseVo.setRoom(1);
        } else if (houseVo.getRooms().equals("俩室")) {
            houseVo.setRoom(2);
        } else if (houseVo.getRooms().equals("三室")) {
            houseVo.setRoom(3);
        } else if (houseVo.getRooms().equals("四室")) {
            houseVo.setRoom(4);
        } else {
            houseVo.setRoom(5);
        }

        if (houseVo.getPrice().equals("不限")) {
            houseVo.setMinPrice(null);
            houseVo.setMaxPrice(null);
        } else if (houseVo.getPrice().equals("8000元以上")) {
            houseVo.setRent(new BigDecimal(9000));
        } else {
            String price = houseVo.getPrice().replace("元", "");
            String[] split = price.split("-");
            houseVo.setMinPrice(Integer.parseInt(split[0]));
            houseVo.setMaxPrice(Integer.parseInt(split[1]));
        }
        if (houseVo.getCountyName().equals("不限")) {
            houseVo.setCounty(null);
        } else {
            QueryWrapper<District> districtQueryWrapper = new QueryWrapper<>();
            districtQueryWrapper.eq("name", houseVo.getCountyName());
            District one = iDistrictService.getOne(districtQueryWrapper);
            houseVo.setCounty(one.getId());
        }
        return iHouseService.getlistPage(houseVo, pageNum, pageSize);
    }

    @RequestMapping("delBatch")
    public boolean delBatch(@RequestBody HouseVo houseVo) {
        return iHouseService.removeByIds(houseVo.getIdList());
    }

    @RequestMapping("decorates")
    public List<Decorate> decorates() {
        ArrayList<Decorate> decorateTypes = new ArrayList<>();
        decorateType[] values = decorateType.values();
        for (decorateType t : values) {
            Decorate decorate = new Decorate();
            decorate.setId(t.getId());
            decorate.setName(t.getName());
            decorateTypes.add(decorate);
        }
        return decorateTypes;

    }

    @RequestMapping("saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody House house) {
        return iHouseService.saveOrUpdate(house);
    }

    @RequestMapping("getOne")
    public HouseVo getOne(House house) {
        House byId = iHouseService.getById(house.getId());
        HouseVo houseVo = new HouseVo();
        BeanUtils.copyProperties(byId, houseVo);
        houseVo.setCityList(getList(byId.getProvince()));
        houseVo.setCountyList(getList(byId.getCity()));
        return houseVo;
    }

    private List<District> getList(Integer city) {
        QueryWrapper<District> districtQueryWrapper = new QueryWrapper<>();
        districtQueryWrapper.eq("pid", city);
        return iDistrictService.list(districtQueryWrapper);
    }
}
