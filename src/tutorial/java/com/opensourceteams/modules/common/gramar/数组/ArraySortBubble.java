package com.opensourceteams.modules.common.gramar.数组;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/25  下午9:18
 * 功能描述:数组冒泡排序
 * 数组升序排序
 * 数组降序排序
 */

public class ArraySortBubble {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {3,9,5,5,10,1};
        println(bubbleAsc(array));
        println("============");
        println(bubbleDesc(array));
    }

    /**
     * 数组升序排序
     * @param array
     * @return
     */
    public static int[] bubbleAsc(int[] array){

        if(array == null || array.length == 0){
            System.out.println("直接退出了");
            return array;
        }

        int temp = array[0];
        for(int i = 0 ; i < array.length ; i++){
            for(int j = 0 ; j < array.length -1 - i;j++){
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }

        }

        return array;
    }

    /**
     * 数组降序排序
     * @param array
     * @return
     */
    public static int[] bubbleDesc(int[] array){

        if(array == null || array.length == 0){
            System.out.println("直接退出了");
            return array;
        }

        int temp = array[0];
        for(int i = 0 ; i < array.length ; i++){
            for(int j = 0 ; j < array.length -1 - i;j++){
                if(array[j] < array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }

        }

        return array;
    }

    /**
     * 打印数组
     * @param array
     */
    public static void println(int[] array){
        for(int i = 0 ; i < array.length  ; i++){
            System.out.println(array[i]);
        }
    };

    /**
     * 打印对象
     * @param obj
     */
    public static void println(Object obj){
        System.out.println(obj.toString());
    };

}
