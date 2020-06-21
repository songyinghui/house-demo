package com.syh.senior5.service;

import com.github.pagehelper.PageInfo;
import com.syh.senior5.entity.House;
import com.baomidou.mybatisplus.extension.service.IService;
import com.syh.senior5.entity.HouseVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宋英辉
 * @since 2020-06-21
 */
public interface IHouseService extends IService<House> {

    PageInfo<HouseVo> getlistPage(HouseVo houseVo, Integer pageNum, Integer pageSize);
}
