package com.opensourceteams.modeles.common.作业.day4;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/27  下午3:34
 * 功能描述:将字节型转换成十六进制字符串表现形式
 */

public class ByteToHex {

    public static void main(String[] args){


        byte b = 108 ; // 00110 1100
        System.out.println(convert(b));
    }

    //转换函数

    /**
     * 0x0F  十六进制F   相当于值 十进制 15,二进制表现形式为 0000 1111
     * 1是一个特殊的二进制,
     * 二进制 1 & 任何数是原数
     * 二进制 0 & 任何数是 0
     * @param b
     * @return
     */
    public static String convert(byte b){
        //1.取出字节b的低四位的数值
        int low = b & 0x0F ;			//低四位0-15

        //2.取出高四位的值,先将b向右移动4位
        int high = (b >> 4) & 0x0F ;	//高四位0-15
        //定义字符数组
        char[] arr = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'} ;
        //拼接串
        return "" + arr[high] + arr[low] ;
    }
}
