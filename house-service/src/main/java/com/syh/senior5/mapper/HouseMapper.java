package com.syh.senior5.mapper;

import com.syh.senior5.entity.House;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.syh.senior5.entity.HouseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 宋英辉
 * @since 2020-06-21
 */
public interface HouseMapper extends BaseMapper<House> {

    List<HouseVo> getList(@Param("vo") HouseVo houseVo);
}
