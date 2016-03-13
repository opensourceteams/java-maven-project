package com.opensourceteams.modules.common.java.lang;

import org.junit.Test;

import java.util.Arrays;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/13  下午2:10
 * 功能描述:
 */

public class ByteTest2 {

    @Test
    public void test(){

        byte[] arr = new byte[5];
        arr[0] = 12;
        arr[1] = 34;
        arr[2] = 25;
        arr[3] = 67;
        arr[4] = 98;

        byte[] newArry2 = convertIntToByteArry(330);
        byte[] newReturnArry = byteArrayOverlay(arr,newArry2);

        int value2 = getNextIntByArray(newReturnArry,4);
        System.out.println(value2);


    }

    /**
     * 数组叠加
     * @param array
     * @param newArray
     * @return
     */
    public static byte[] byteArrayOverlay(byte[] array,byte[] newArray){

        byte[] returnArry = new byte[array.length + newArray.length];

        for(int i = 0 ;i < array.length ;i++){
            returnArry[i] = array[i];
        }

        for(int i = 0 ;i < newArray.length ;i++){
            returnArry[i + array.length] = newArray[i];
        }


        return returnArry;

    }

    /**
     * 转换int 为二进制数组
     * @param value
     * @return
     */
    public static byte[] convertIntToByteArry(int value){
        int newValue = value;

        byte[] returnArry = new byte[4];
        returnArry[0] =  (byte)(newValue << 24 >> 24) ;
        returnArry[1] =  (byte)(newValue << 16 >> 24) ;
        returnArry[2] =  (byte) (newValue << 8  >> 24) ;
        returnArry[3] =  (byte)(newValue  >> 24) ;

        return returnArry;
    }


    /**
     * 通过二进制数组返回下一个指定开始索引的整数值
     * @param arr
     * @param index
     * @return
     */
    public static int getNextIntByArray(byte[] arr, int index){

        byte[] newArry = new byte[4];

        return (arr[index +4] << 24) | ((arr[index +3] & 0xFF ) << 16)  | ((arr[index +2] & 0xFF) << 8) | (arr[index +1] & 0xFF );

    }
}
