package com.opensourceteams.modules.common.gramar.逻辑控制.n_03_随机整数;

import java.util.Random;

/**
 * 日期: 2016-09-03  17:49
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class Run {

    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt();
        System.out.println(i);

         i = random.nextInt(10);
        System.out.println(i);

        for(int j = 1;j<100;j++){
            System.out.println(random.nextInt(10));
        }
    }
}
