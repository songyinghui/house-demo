package com.syh.senior5.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syh.senior5.entity.District;
import com.syh.senior5.entity.House;
import com.syh.senior5.entity.HouseVo;
import com.syh.senior5.entity.decorateType;
import com.syh.senior5.mapper.HouseMapper;
import com.syh.senior5.service.IDistrictService;
import com.syh.senior5.service.IHouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 宋英辉
 * @since 2020-06-21
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements IHouseService {
    @Autowired
    IDistrictService iDistrictService;

    @Override
    public PageInfo<HouseVo> getlistPage(HouseVo houseVo, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HouseVo> list = this.getBaseMapper().getList(houseVo);
        for (HouseVo v : list) {
            //获取装修名称
            v.setDecorateName(getDecorate(v.getDecorate()));
            //获取省市县
            v.setProvinceName(getCityName(v.getProvince()));
            v.setCityName(getCityName(v.getCity()));
            v.setCountyName(getCityName(v.getCounty()));

        }
        return new PageInfo<>(list);
    }

    private String getCityName(Integer id) {
        QueryWrapper<District> districtQueryWrapper = new QueryWrapper<>();
        districtQueryWrapper.eq("id", id);
        District one = iDistrictService.getOne(districtQueryWrapper);
        return one.getName();
    }

    private String getDecorate(Integer decorate) {
        if (decorateType.type1.ordinal() == decorate) {
            return decorateType.type1.getName();
        } else if (decorateType.type2.ordinal() == decorate) {
            return decorateType.type2.getName();
        } else {
            return decorateType.type3.getName();
        }
    }
}
