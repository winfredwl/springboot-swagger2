package com.winfred.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户对象类
 *
 * @author Winfred.Wang
 * @since 05.19.2017
 */
@ApiModel(value = "User", description = "用户对象")
public class User {

    @ApiModelProperty(value = "ID")
    private Integer id;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "年龄",access = "hidden")
    private int age;
    @ApiModelProperty(value = "性别")
    private int sex;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
