package com.opensourceteams.modules.common.gramar.作业.n_05_day.n_02_数组冒泡排序;

/**
 * 日期: 2016-09-04  09:57
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class Run {

    public static void main(String[] args) {
        int[] array = new int[]{5,4,2,8};

        int temp = array[0];

        for (int i = 0;i< array.length -1 ;i++){
            for (int j = 0;j < array.length -1 -i ;j++) {
                if(array[j] > array[j+1]){
                    temp =  array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }


        }

        for (int v : array){
            System.out.println(v);
        }

    }

}
