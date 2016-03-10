package com.opensourceteams.modeles.common.gramar.二进制.十进制轩二进制表示;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/10  上午5:16
 * 功能描述:
 */

public class Test2 {

    public static void main(String[] args) {
       // System.out.println(BinaryUtil.intToBitsByBitLength(5,2));


        for(int i =0;i<8;i++){
            System.out.println("通过bit位数:" +(i + 1)+ ",得到的最大整数值" + BinaryUtil.getMaxValueByBitLength(i +1));
        }


    }



}
