package com.opensourceteams.modeles.common.作业.day4;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/27  下午4:22
 * 功能描述: 数组求和
 */

public class ArraySum {

    public static void main(String[] args) {
        int result = sum(new int[]{1,3,5});
        System.out.println(result);

        int jiChen = jiChen(new int[]{1,3,5},3);
        System.out.println(jiChen);
    }

    public static int sum(int[] arr){
        int sum = 0 ;
        for(int i = 0 ;i < arr.length ; i++){
            sum = sum + arr[i];
        }
        return sum ;
    }



    public static int jiChen(int[] arr, int num){
        int sum = arr[0] ;
        for(int i = 0 ;i < num  ; i++){
            sum = sum * arr[i];
        }
        return sum ;
    }
}
