package com.syh.senior5.entity;

import lombok.Data;

import java.util.List;

@Data
public class HouseVo extends House {
    //省
    private String provinceName;
    //市
    private String cityName;
    //县
    private String countyName;
   //装修类型
    private String decorateName;

    //id集合号
    private List<Integer> idList;

    private List<District> cityList;
    private List<District> countyList;

    private String price;
    private Integer minPrice;
    private Integer maxPrice;
    private String rooms;
}
