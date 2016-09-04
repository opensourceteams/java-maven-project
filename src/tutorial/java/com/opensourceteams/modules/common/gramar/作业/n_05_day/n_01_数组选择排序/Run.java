package com.opensourceteams.modules.common.gramar.作业.n_05_day.n_01_数组选择排序;

/**
 * 日期: 2016-09-04  09:39
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述: 选择排序
 * ).每次找一个最值
 * ).循环所有元素的长度,就找到了所有的最值,而冒泡排序需要交换位置,数据频烦交换位置,性能就差
 * */
public class Run {

    public static void main(String[] args) {

        int[] array = new int[]{5,4,2,8};
        int temp = array[0];
        for(int i = 0;i < array.length ;i++){

            int min = i;
            for(int j = i +1;j < array.length ;j++){
                if(array[min] > array[j]){
                    min = j;
                }
            }
            if(min !=i){
                temp = array[i];
                array[i] = array[min] ;
                array[min] = temp;

            }
        }

        for (int v : array){
            System.out.println(v);
        }

    }
}
