package com.opensourceteams.modules.common.gramar.作业.n_04_day;

/**
 * 日期: 2016-09-04  08:32
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class A {

    public static void main(String[] args) {
        int i = 2;
        int j = 5;
        System.out.println(i * ++j);
        /**
         * ++j 先 j+1 再进行运算
         * j++ 先进行运算,j 再+1
         */


        int[] array = new int[]{1,3,8,9,};
        System.out.println("长度:"+array.length);
        for (int v : array){
            System.out.println(v);
        }
    }
}
