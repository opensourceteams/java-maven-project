package com.opensourceteams.modules.common.gramar.作业.n_04_day;

import java.util.Random;

/**
 * 日期: 2016-09-03  19:26
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class Run0 {

    public static void main(String[] args) {
        Random random = new Random();


        for (int i = 0; i < 1000; i++) {
            System.out.println( random.nextInt(2));

        }
    }
}
