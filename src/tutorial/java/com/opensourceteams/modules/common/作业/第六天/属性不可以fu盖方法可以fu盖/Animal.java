package com.opensourceteams.modules.common.作业.第六天.属性不可以fu盖方法可以fu盖;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/1  下午3:11
 * 功能描述:
 */

abstract class Animal {

    public String name;

}


class Dog extends  Animal{
    public String name;

    public void cry(){
        System.out.println("Dog 在叫");
    }

}

class  JingB extends  Dog{

    public String name;
    @Override
    public void cry() {
        System.out.println("金巴叫");
    }
}


class Run {

    /**
     * 方法能fu概,说明方法取的是实际存放的方法
     * 属性不能fu概,说明属性取的是当前调的对象
     * @param args
     */
    public static void main(String[] args) {
        JingB a = new JingB();
        a.name = "金巴的名字";
        System.out.println(a.name);



        Dog dog = a;
        dog.name ="狗的名字";
        System.out.println(dog.name);
        System.out.println(a.name);

        System.out.println("===========方法");
        a.cry();
        dog.cry();




    }
}