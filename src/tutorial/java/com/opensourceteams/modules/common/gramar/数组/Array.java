package com.opensourceteams.modules.common.gramar.数组;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/25  下午9:03
 * 功能描述:
 * 数组求最大值,
 * 数组求最小值
 * 数组求某个值的索引
 */

public class Array {

    public static void main(String[] args) {
        int[] array = {1,3,5,3,9};
        println(getArrayMax(array));
        println(getArrayMin(array));
        println(getArrayValueIndex(array,3));
    }



    /**
     * 求数组中的最大值
     * @param array
     * @return
     */
    public static int getArrayMax(int[] array){
        if(array == null || array.length == 0){
            System.out.println("直接退出了");
            return -1;
        }
        int max = array[0];
        for(int v : array){
            if(v > max){
                max = v ;
            }
        }
        return max;
    }


    /**
     * 求数组中的最小值
     * @param array
     * @return
     */
    public static int getArrayMin(int[] array){
        if(array == null || array.length == 0){
            System.out.println("直接退出了");
            return -1;
        }
        int min = array[0];
        for(int v : array){
            if(v < min){
                min = v ;
            }
        }
        return min;
    }


    /**
     * 得到数组元素首次出现的索引
     * @param array
     * @param value
     * @return -1:表示,数组为空,或长度为0, -2:表示,没有查到该值
     */
    public static int getArrayValueIndex(int[] array,int value){
        if(array == null || array.length == 0){
            System.out.println("直接退出了");
            return -1;
        }
        int min = array[0];
        for(int i = 0 ; i < array.length ; i ++){
            if(array[i] == value){
                return i;
            }
        }
        return -2;
    }

    /**
     * 打印输出方法
     * @param obj
     */
    public static void println(Object obj){
        System.out.println(obj.toString());
    };
}
