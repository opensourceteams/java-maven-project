package com.opensourceteams.modules.common.gramar.反射.n_02_反射_案例分析.n_01_JavaBean属性值的复制;

import java.util.Date;

/**
 * 日期: 2016-03-29  04:34
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class WomanBean {

    private String birthTochild;//生孩子
    private String name;
    private int age;
    private Date birthday;
    private Date createDate;
    private Date updateDate;

    public WomanBean(String birthTochild, String name, int age, Date date, Date createDate, Date updateDate) {
        this.birthTochild = birthTochild;
        this.name = name;
        this.age = age;
        this.birthday = date;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getBirthTochild() {
        return birthTochild;
    }

    public void setBirthTochild(String birthTochild) {
        this.birthTochild = birthTochild;
    }
}
