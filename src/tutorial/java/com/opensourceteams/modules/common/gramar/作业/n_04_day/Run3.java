package com.opensourceteams.modules.common.gramar.作业.n_04_day;

import java.util.Random;


/**
 * 日期: 2016-09-03  19:32
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class Run3 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] stores = new int[60];

        for (int i = 0;i< stores.length;i++){
            stores[i] = random.nextInt(100);
        }

        for (int i = 0;i< stores.length;i++){
            System.out.println("i:" + i +"  " +stores[i]);
        }


        int[] haveV = new int[13];
        int indexHaveV = 0; //已经放
        while (true){
            if(indexHaveV ==13){
                break;
            }
            int index = random.nextInt(60);
            if(exist(haveV,index)){
                continue;
            }

            haveV[indexHaveV] = index;
            indexHaveV++;
        }

        for (int i = 0;i< haveV.length;i++){
            System.out.println("挑出的元素 索引:" + i +"  " +haveV[i]  +  "  值:" +stores[haveV[i]]);
        }

    }

    public static boolean exist(int[] array,int value){

        for (int i = 0;i< array.length;i++){
            if(array[i] == value){
                return true;
            }
        }
        return false;
    }
}
