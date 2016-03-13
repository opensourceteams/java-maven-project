package com.opensourceteams.modules.common.gramar.数组;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/25  下午9:58
 * 功能描述:选择排序
 * 数组选择排序升序
 * 数组选择排序降序
 */

public class ArraySortSelect {


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {3,9,5,5,10,1};
        println(arraySortSelectAsc(array));
        println("============");
        println(arraySortSelectDesc(array));
    }

    /**
     * 数组选择排序升序
     * @param array
     * @return
     */
    public static int[] arraySortSelectDesc(int[] array){

        if(array == null || array.length == 0){
            System.out.println("直接退出了");
            return array;
        }

        int temp = array[0];
        int index = 0 ;
        for(int i = 0 ; i < array.length ; i++){
            temp = array[i];
            index = i;
            for(int j = i + 1 ; j < array.length;j++){
                    if(array[j] > temp){
                        temp = array[j];
                        index = j;
                    }
            }

            if(temp > array[i] ){
                array[index] = array[i];
                array[i] = temp;
            }

        }

        return array;
    }

    /**
     * 数组选择排序降序
     * @param array
     * @return
     */
    public static int[] arraySortSelectAsc(int[] array){

        if(array == null || array.length == 0){
            System.out.println("直接退出了");
            return array;
        }

        int temp = array[0];
        int index = 0 ;
        for(int i = 0 ; i < array.length ; i++){
            temp = array[i];
            index = i;
            for(int j = i + 1 ; j < array.length;j++){
                if(array[j] < temp){
                    temp = array[j];
                    index = j;
                }
            }

            if(temp < array[i] ){
                array[index] = array[i];
                array[i] = temp;
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
