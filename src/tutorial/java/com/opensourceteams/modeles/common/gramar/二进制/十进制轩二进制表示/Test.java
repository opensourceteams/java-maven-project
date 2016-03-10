package com.opensourceteams.modeles.common.gramar.二进制.十进制轩二进制表示;


import java.util.Arrays;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/8  下午6:08
 * 功能描述:
 */

public class Test {

    public static void main(String[] args) {

        /**
         * 得到100个元素的数组
         */
        int[] arr = new int[100];
        for (int i =0 ;i< 100;i++){
            arr[i] =(int)(Math.random()*100);
        }

        for (int i : arr){
            System.out.println(i);
        }

        /**
         * 得到100个元素中的8个元素
         */
        int[] arrSub = new int[8];

        for (int i =0;i< arrSub.length;i++){
            arrSub[i] = arr[(int)(Math.random()*100)];
        }
        System.out.println("得到数组的8个元素");
        for (int i : arrSub){
            System.out.println(i);
        }

        Arrays.sort(arrSub);

        System.out.println("排序后得到数组的8个元素");
        for (int i : arrSub){
            System.out.println(i);
        }




    }



}
