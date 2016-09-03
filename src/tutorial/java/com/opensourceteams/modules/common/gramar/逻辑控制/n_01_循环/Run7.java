package com.opensourceteams.modules.common.gramar.逻辑控制.n_01_循环;

/**
 * 日期: 2016-09-03  13:00
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class Run7 {

    public static void main(String[] args) {
        int j = 0;
        int sum = 0;

        for (int i = 2 ; i<= 100;i++){
            j = 2;
            while ( i % j !=0){
                j++;
            }
            if(i == j){
                System.out.println( i +" 是质数");
                sum += i;
            }
        }
        System.out.println("1到 100的质数的和为:" + sum);
    }
}
