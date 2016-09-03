package com.opensourceteams.modules.common.gramar.二进制.十进制轩二进制表示;

import com.opensourceteams.modules.common.java.binary.BinaryStringUtil;

/**
 * 日期: 2016-08-30  20:22
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class A {

    public static void main(String[] args) {


        for(int i = -128;i< 128 ;i++){
            System.out.println("十进制:" + i +"  二进制: " + byteToBits((byte)i));
        }


    }

    /**
     *  将byte 表现为bit 的字符串形式
     * @param value 传入 btye 数组
     * @return 返回bit字符串
     */
    public static String byteToBits(byte value){

        /**
         * 十进制数:256 转成二进制后:100000000 长度:9
         * 或运算定理:只要有一个为1,就是1,没有一个1,就是0
         * 即:位运算 | 0 或任何数,都得原数
         */
        String str = Integer.toBinaryString(value | 256);
        return str.substring(str.length() -8);
    }
}
