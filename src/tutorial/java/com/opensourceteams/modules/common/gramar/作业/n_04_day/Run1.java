package com.opensourceteams.modules.common.gramar.作业.n_04_day;

import java.util.Arrays;
import java.util.Random;

/**
 * 日期: 2016-09-03  19:11
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 * 1、	随机产生三个100（包括）到350（不包括）之间的随机整数，要求按照由大到小的顺序输出；
 */
public class Run1 {

    public static void main(String[] args) {
        Random random = new Random();


        int[] array = new int[3];
        for(int i = 0;i< 3;i++){
            array[i] = random.nextInt(250) +100 ;

        }

        for (int i = 0;i< array.length;i++){
            System.out.println(i + "  " + array[i]);
        }

        Arrays.sort(array);

        System.out.println("排序后");
        for (int i = 0;i< array.length;i++){
            System.out.println(i + "  " + array[i]);
        }

    }
}
