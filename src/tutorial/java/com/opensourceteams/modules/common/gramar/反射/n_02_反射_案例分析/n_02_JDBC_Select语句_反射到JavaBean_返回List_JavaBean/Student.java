package com.opensourceteams.modules.common.gramar.反射.n_02_反射_案例分析.n_02_JDBC_Select语句_反射到JavaBean_返回List_JavaBean;

/**
 * 日期: 2016-03-29  06:57
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Student {

    private String id;
    private String name;
    private  int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "id:" +id +"\t name:"+name +"\t age:"+age;
    }
}
