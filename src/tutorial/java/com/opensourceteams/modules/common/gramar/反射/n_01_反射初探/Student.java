package com.opensourceteams.modules.common.gramar.反射.n_01_反射初探;

/**
 * 日期: 2016-03-28  16:34
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Student {

    private String name;

    private String getPrivateName() {
        return "a";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
