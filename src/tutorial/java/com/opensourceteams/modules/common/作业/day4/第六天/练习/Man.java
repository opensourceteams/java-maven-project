package com.opensourceteams.modules.common.作业.day4.第六天.练习;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/1  下午1:20
 * 功能描述:
 */

public class Man implements  Person{



    public static void main(String[] args) {
        Man man = new Man();
        man.show();
    }

    private String huzi = "胡子" ;

    public void show(){
        System.out.println("人:" + huzi);
    }
    public void eat() {
        System.out.println("男人吃饭");
    }
}
