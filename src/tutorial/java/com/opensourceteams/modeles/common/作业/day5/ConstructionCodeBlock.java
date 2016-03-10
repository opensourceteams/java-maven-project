package com.opensourceteams.modeles.common.作业.day5;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/29  下午7:01
 * 功能描述: 构造代码块,和构造函数的执行顺序
 */

public class ConstructionCodeBlock {

    {
        System.out.println("构造代码块1");
    }

    public ConstructionCodeBlock(){
        System.out.println("构造函数");
    }

    {
        System.out.println("构造代码块2");
    }

    public static void main(String[] args) {
        new ConstructionCodeBlock();
    }
}
