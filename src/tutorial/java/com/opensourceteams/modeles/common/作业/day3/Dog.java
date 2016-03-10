package com.opensourceteams.modeles.common.作业.day3;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/27  上午5:33
 * 功能描述:狗
 */

public class Dog {

    /**
     * 名称
     */
    private String name ;
    /**
     * 颜色
     */
    private String color;
    /**
     * 年龄
     */
    private int age;

    /**
     * 叫的方法,相当于是狗对象,叫功能的一个具体实现
     */
    public void cry(){
        System.out.println("name:" +name + "color:"+color+ "age:"+age + "   狗在叫");
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
