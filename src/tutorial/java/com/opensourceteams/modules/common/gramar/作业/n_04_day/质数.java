package com.opensourceteams.modules.common.gramar.作业.n_04_day;

/**
 * 日期: 2016-09-03  22:02
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:求出1到100所有质数的和
 */
public class 质数 {

    public static void main(String[] args) {

        int sum =0;
        for(int i = 2;i <= 100;i ++){
            int n = i;
            int j = 2;
            while(n % j !=0){
                j++;
            }
            if(n == j){
                sum +=i;
                System.out.println("质数:" + i);
            }else{
              //  System.out.println("不是质数");
            }

        }
        System.out.println("结果:" + sum);


    }
}
