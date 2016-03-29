package com.opensourceteams.modules.common.gramar.jvm.n_01_jvm_初探;

/**
 * 日期: 2016-03-28  15:08
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Student{

    static {
        System.out.println("static load...");
    }
    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
