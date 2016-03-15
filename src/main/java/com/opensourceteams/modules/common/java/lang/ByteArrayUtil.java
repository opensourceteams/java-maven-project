package com.opensourceteams.modules.common.java.lang;

import java.util.Arrays;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/15  下午4:19
 * 功能描述:
 */

public class ByteArrayUtil {


    /**
     * 返回数组的子数组
     * @param byteArray
     * @param beginIndex
     * @param length
     * @return
     * @throws Exception
     */
    public static byte[] getSubByteArray(byte[] byteArray,int beginIndex,int length) throws Exception {

        if(byteArray == null){
            throw new Exception("byteArray 为空");
        }else  if(byteArray.length < length +beginIndex){
            throw new Exception("byteArray 长度不够");
        }

        byte[] newByteArray = new byte[length];
        int index=0 ;
        for (int i =beginIndex;i <length;i++){
            newByteArray[index++] = byteArray[i];
        }
        return newByteArray;

    }
}
