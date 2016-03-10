package com.opensourceteams.modeles.common.gramar.数组;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/26  上午11:28
 * 功能描述:实现矩阵的转换
 */

public class ArrayMatrices {

    public static void main(String[] args) {
        int[][] array = new int[2][3];
        array[0] = new int[]{1,5,3,9,12,6};
        array[1] = new int[]{20,30,40,50};

        println(array);

    }



    public static void println(int[][] array){
        for(int i = 0 ;i < array.length ; i++){
            for(int j =0 ;j < array[i].length; j++){
                System.out.print(array[i][j] +"\t");
            }
            System.out.println("");

        }

    }


}
