package com.opensourceteams.modules.common.gramar.作业.n_03_day;

/**
 * 日期: 2016-09-03  21:20
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class 判断润年 {

    public static void main(String[] args) {

        int year = 2014 ;
        if(year % 4 == 0 && year % 100 != 0 && year % 400 ==0){
            System.out.println("润年");
        }else{
            System.out.println("平年");
        }

    }
}
