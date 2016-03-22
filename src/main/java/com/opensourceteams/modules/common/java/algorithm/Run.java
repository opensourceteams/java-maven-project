package com.opensourceteams.modules.common.java.algorithm;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  下午7:22
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {
        System.out.println(1 << 1);

        System.out.println(1 | 1 << 1);


        int currentCount = 1;
        int totalCount = 1;
        byte b =  (byte)(currentCount | totalCount << 1);
        System.out.println(b);
        System.out.println(1 | (1 << 1));
    }
}
