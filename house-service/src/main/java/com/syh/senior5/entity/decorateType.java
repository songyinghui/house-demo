package com.syh.senior5.entity;

import java.util.ArrayList;
import java.util.List;

public enum decorateType {
    type1(0,"毛坯"),
    type2(1,"普通装修"),
    type3(2,"精装修");

    public Integer id;
    private String name;

    decorateType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    decorateType() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
