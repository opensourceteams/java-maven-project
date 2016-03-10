package com.opensourceteams.modeles.common.作业.day5.抽象类;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/29  下午8:32
 * 功能描述: 抽象类可以有构造函数
 * 抽象类的构造函数可以重载
 */

abstract class Person {

    public String name ;

    public int age;
    public Person(){}

    public Person(String name){
        this.name = name ;
    }

    public Person(String name,int age,String a){
        //this();
        this(name);
    }
    public static void main(String[] args) {

    }

}
