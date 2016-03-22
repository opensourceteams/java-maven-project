package com.opensourceteams.modules.common.java.binary;

import org.junit.Test;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/13  上午6:08
 * 功能描述:
 */

public class BinaryUtilTest {

    @Test
    public void testByte256(){
        for (int  i = -128;i <128;i++){
            System.out.println((i << 24 >>> 24));
        }
    }

    /**
     * int 转为二进制表现形式
     */
    @Test
    public void testByteToBits(){
        String s = BinaryStringUtil.byteToBits((byte)-127);
        System.out.println(s);

        s = BinaryStringUtil.byteToBits((byte)-128);
        System.out.println(s);

        s = BinaryStringUtil.byteToBits((byte)-1);
        System.out.println(s);

        s = BinaryStringUtil.byteToBits((byte)-2);
        System.out.println(s);
    }

    /**
     * int 转为二进制表现形式
     */
    @Test
    public void testToBinaryString(){
        String s = Integer.toBinaryString(16);
        System.out.println(s);
    }


    /**
     * int 转为二进制表现形式
     */
    @Test
    public void testIntToBitsByByteLength(){
        String s = BinaryStringUtil.intToBitsByByteLength(16);
        System.out.println(s);
    }

    /**
     * int 转为二进制表现形式
     */
    @Test
    public void testConvertIntByBit(){
        int value = BinaryStringUtil.convertIntByBit("1");//15,31,63
        System.out.println("1 --> 1 -->"+ value);

        value = BinaryStringUtil.convertIntByBit("11");//15,31,63
        System.out.println("2 --> 11 -->"+ value);
        value = BinaryStringUtil.convertIntByBit("111");//15,31,63
        System.out.println("3 --> 111 -->"+ value);
        value = BinaryStringUtil.convertIntByBit("1111");//15,31,63
        System.out.println("4 --> 1111 -->"+ value);
        value = BinaryStringUtil.convertIntByBit("11111");//15,31,63
        System.out.println("5 --> 11111 -->"+ value);
        value = BinaryStringUtil.convertIntByBit("111111");//15,31,63
        System.out.println("6 --> 111111 -->"+ value);
        value = BinaryStringUtil.convertIntByBit("1111111");//15,31,63
        System.out.println("7 --> 1111111 -->"+ value);
        value = BinaryStringUtil.convertIntByBit("11111111");//15,31,63
        System.out.println("8 --> 11111111 -->"+ value);
        value = BinaryStringUtil.convertIntByBit("10000000");//15,31,63
        System.out.println(value);



    }

}
