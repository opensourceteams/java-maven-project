package com.opensourceteams.modules.common.java.io.serialization.data.object;

import java.beans.Transient;
import java.io.Serializable;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/14  下午5:29
 * 功能描述:
 */

public class Cat  implements Serializable{

    private String name;
    private int age;

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
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
