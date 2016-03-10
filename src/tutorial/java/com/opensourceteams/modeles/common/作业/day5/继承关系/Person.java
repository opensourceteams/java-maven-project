package com.opensourceteams.modeles.common.作业.day5.继承关系;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/29  下午8:20
 * 功能描述:定义类Person,Man,Woman形成继承关系。
 */

class Person {

    private String name;

    public Person(String name){
        this.name = name ;
    }

    public void say() {
        System.out.println(name  + "Person say");
    }
}

class Man extends  Person{

    public Man(String name){
        super(name);
    }

}

class Woman extends  Person{
    public Woman(String name){
        super(name);
    }
}

class Run{

    public static void main(String[] args){
        new Man("刘德华").say();

        new Woman("张曼珏").say();
    }
}


