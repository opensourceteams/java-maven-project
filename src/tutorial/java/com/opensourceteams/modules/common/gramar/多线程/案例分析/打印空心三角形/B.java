package com.opensourceteams.modules.common.gramar.多线程.案例分析.打印空心三角形;

/**
 * 日期: 2016-08-26  17:50
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class B {

    public static void main(String[] args) {

        byte b = 4;
        String str = "" ;
        for(int i =1;i<=8;i++){

            str = str +(b >>> (8 - i));
        }
        System.out.println(str);

    }
}
