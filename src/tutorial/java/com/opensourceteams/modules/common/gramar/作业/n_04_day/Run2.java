package com.opensourceteams.modules.common.gramar.作业.n_04_day;

import java.util.Random;

/**
 * 日期: 2016-09-03  19:22
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 *
 * 2、	一个班级有31名学生，考试过后，成绩按照百分制，均在25以上，要求统计班级的总分及平均分；并求出最低和最高分；
 */
public class Run2 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] stores = new int[31];

        for (int i = 0;i< stores.length;i++){
            stores[i] = random.nextInt(75) + 26;
        }

        int avg = 0;
        int sum = 0;
        for (int i = 0;i< stores.length;i++){
            sum += stores[i];
        }
        System.out.println("总分:" +sum);
        System.out.println("平均分:" + sum / stores.length);

        int min = stores[0];
        for (int i = 0;i< stores.length -1;i++){
            if(stores[i+1] < stores[i]){
               min = stores[i+1];
            }
        }
        System.out.println("最小值:" +min);


        int max = stores[0];
        for (int i = 0;i< stores.length -1;i++){
            if(stores[i+1] > stores[i]){
                max = stores[i+1];
            }
        }
        System.out.println("最大值:" +max);



    }
}
