package com.opensourceteams.modules.common.java.binary;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/14  上午6:44
 * 功能描述:
 */

public class IntConvertEachBinary {

    /**
     * 转换int 为二进制数组
     * @param value
     * @return
     */
    public static byte[] convertIntToByteArry(int value){
        int newValue = value;

        byte[] returnArry = new byte[4];

        returnArry[0] =  (byte)(newValue << 24 >>> 24) ;
        returnArry[1] =  (byte)(newValue << 16 >>> 24) ;
        returnArry[2] =  (byte) (newValue << 8  >>> 24) ;
        returnArry[3] =  (byte)(newValue  >> 24) ;

        return returnArry;
    }

    /**
     * 通过二进制数组返回下一个指定开始索引的整数值
     * @param arr
     * @return
     */
    public static int getIntByArray(byte[] arr){


        return (arr[3] << 24) | ((arr[2] & 0xFF  ) << 16)  | ((arr[1]  & 0xFF ) << 8) | (arr[0] & 0xFF );

    }
}
