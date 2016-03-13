package com.opensourceteams.modules.common.作业.第十四天.定义函数输出一个byte的二进制字符串;

import com.opensourceteams.modules.common.java.binary.BinaryUtil;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/14  上午7:28
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {

        String s = BinaryUtil.byteToBits((byte)129);
        System.out.println(s);

         s = BinaryUtil.byteToBits((byte)127);
        System.out.println(s);

        s = BinaryUtil.byteToBits((byte)-1);
        System.out.println(s);

        s = BinaryUtil.byteToBits((byte)-2);
        System.out.println(s);

    }
}
