package com.opensourceteams.modules.common.gramar.多线程.案例分析.打印空心三角形;

/**
 * 日期: 2016-08-26  17:41
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class A {

    public static void main(String[] args) {

    }

    public static void hellow(){

        int high = 4;
        for(int i = 1;i <= high ;i++ ){

            for(int j = high -1;j>=i;j--){

                System.out.println(" ");
            }
        }
    }
}
