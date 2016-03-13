package com.opensourceteams.modules.common.gramar.数组.数组的复制;

import java.util.Arrays;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/10  下午2:32
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {
        //testCopyIntArry();
        testCopyIntArry2();
        int[] arr = {1,5,9};
        //Arrays.binarySearch();



    }

    static void  testCopyIntArry2(){
        int[] arr = {1,5,9};
        int[] newArry = Arrays.copyOf(arr,arr.length);
        for(int v : newArry){
            System.out.println(v);
        }

    }

    static void  testCopyIntArry(){
        int[] arr = {1,5,9};
        int[] newArry = copyIntArry(arr);
        for(int v : newArry){
            System.out.println(v);
        }

    }

    static int[] copyIntArry(int[] arry){

        int[] newArry = new int[arry.length];
        if(arry == null){
            return  null;
        }
        for(int i = 0 ;i < arry.length; i++){
            newArry[i] = arry[i];
        }

        return newArry;
    }
}
