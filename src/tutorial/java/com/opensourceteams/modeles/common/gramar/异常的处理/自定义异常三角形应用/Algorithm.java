package com.opensourceteams.modeles.common.gramar.异常的处理.自定义异常三角形应用;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/2  下午2:36
 * 功能描述:算法,让数组中的所有元素两两相匹配
 */

public class Algorithm {

    public static void main(String[] args) {

        int[] arr = {3,5,8,9};
        printlnMatchElement2Plus(arr);

    }

    /**
     * 数组中的元素两两匹配
     * @param arr
     */
    public static void printlnMatchElement2(int[] arr){

        for(int i = 1; i < arr.length;i++){

            for(int j = i ;j < arr.length ; j++){

                System.out.println(arr[i -1] + "  --> " +  arr[j]);
            }

        }
    }

    /**
     * 数组中的元素两两匹配(做加运算)
     * @param arr
     */
    public static void printlnMatchElement2Plus(int[] arr){

        for(int i = 1; i < arr.length;i++){

            for(int j = i ;j < arr.length ; j++){

                System.out.println(arr[i -1]  +  arr[j]);
            }

        }
    }
}
