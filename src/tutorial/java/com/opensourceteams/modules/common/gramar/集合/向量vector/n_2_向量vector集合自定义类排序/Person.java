package com.opensourceteams.modules.common.gramar.集合.向量vector.n_2_向量vector集合自定义类排序;

/**
 * 日期: 2016-03-25  07:48
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Person implements Comparable<Person>{

    private String name;
    private int age;

    public Person(String name, int age) {
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

    @Override
    public String toString() {
        return "name:" + this.name + " age:" +age;
    }


    public int compareTo(Person o) {
        return age - o.getAge();
    }
}
