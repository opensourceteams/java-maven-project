package com.opensourceteams.modeles.common.作业.day4;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/27  下午4:29
 * 功能描述: 阶乘的算法
 */

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    /**
     * 求一个数的阶乘
     * @param num
     * @return
     */
    public static int factorial(int num){
        int result = 1;
        for(int i = 1 ;i <= num ; i++){
            result *= i ;
        }
        return result;
    }
}
