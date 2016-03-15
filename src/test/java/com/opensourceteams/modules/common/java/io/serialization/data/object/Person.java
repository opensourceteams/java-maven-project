package com.opensourceteams.modules.common.java.io.serialization.data.object;

import java.beans.Transient;
import java.io.Serializable;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/14  下午5:36
 * 功能描述:
 */

public class Person implements Serializable{





    private String name;
    private int age;

    private transient Cat cat;

    public Person() {
    }

    public Person(String name, int age, Cat cat) {
        this.name = name;
        this.age = age;
        this.cat = cat;
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

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }
}
