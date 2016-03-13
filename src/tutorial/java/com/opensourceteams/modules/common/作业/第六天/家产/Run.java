package com.opensourceteams.modules.common.作业.第六天.家产;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/1  下午4:09
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {

        Son son = new Son();
        son.setAsset(200);

        Father father = son ;

        father.setAsset(100);
        System.out.println(father.getAsset());




        System.out.println(son.getAsset());
        System.out.println(father.getAsset());




    }
}
