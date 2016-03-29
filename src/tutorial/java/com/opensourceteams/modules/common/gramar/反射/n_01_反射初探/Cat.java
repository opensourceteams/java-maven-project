package com.opensourceteams.modules.common.gramar.反射.n_01_反射初探;

/**
 * 日期: 2016-03-28  16:48
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Cat {

    private String color;
    private String name;

    private Cat(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void catchMouse(){
        System.out.println("抓老...");
    }
}
