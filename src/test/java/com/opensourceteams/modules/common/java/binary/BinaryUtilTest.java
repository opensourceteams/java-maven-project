package com.opensourceteams.modules.common.java.binary;

import org.junit.Test;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/13  上午6:08
 * 功能描述:
 */

public class BinaryUtilTest {

    /**
     * int 转为二进制表现形式
     */
    @Test
    public void testByteToBits(){
        String s = BinaryUtil.byteToBits((byte)-127);
        System.out.println(s);

        s = BinaryUtil.byteToBits((byte)-1);
        System.out.println(s);

        s = BinaryUtil.byteToBits((byte)-2);
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
        String s = BinaryUtil.intToBitsByByteLength(16);
        System.out.println(s);
    }

    /**
     * int 转为二进制表现形式
     */
    @Test
    public void testConvertIntByBit(){
        int value = BinaryUtil.convertIntByBit("1");//15,31,63
        System.out.println(value);

        value = BinaryUtil.convertIntByBit("11");//15,31,63
        System.out.println(value);

    }

}
