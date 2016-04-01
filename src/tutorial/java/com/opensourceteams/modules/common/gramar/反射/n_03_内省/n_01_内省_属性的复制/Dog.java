package com.opensourceteams.modules.common.gramar.反射.n_03_内省.n_01_内省_属性的复制;

/**
 * 日期: 2016-03-29  14:22
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Dog extends  Animal{
    private String name;
    private String owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}