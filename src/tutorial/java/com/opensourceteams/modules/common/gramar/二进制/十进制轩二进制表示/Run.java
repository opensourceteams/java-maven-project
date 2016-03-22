package com.opensourceteams.modules.common.gramar.二进制.十进制轩二进制表示;

import com.opensourceteams.modules.common.java.binary.BinaryStringUtil;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/8  下午4:34
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {



        System.out.println("=========byte >=0 =================");
        byte j = 0;
        for(;j < 127;j++){
            System.out.println("byte 的数据为:" +j +" 可表示的数值为" + BinaryStringUtil.convertIntByBit(BinaryStringUtil.byteToBits(j))  );
        }

        System.out.println(BinaryStringUtil.convertIntByBit(BinaryStringUtil.byteToBits(j))  );

        System.out.println("=========byte为负数=================");
        for(byte i =-128; i< 0;i++){
            System.out.println("byte 的数据为:" +i +" 可表示的数值为" + BinaryStringUtil.convertIntByBit(BinaryStringUtil.byteToBits(i))  );
        }




    }

    public  static void printByteInfo(){
        System.out.println("-------------------正数,负数-------------------");
        System.out.println("-------------------正数,负数-------------------");
        System.out.println("-------------------正数,负数-------------------");
        for(int i =-128 ;i <= 127 ;i++){
            System.out.println("十进制:" + i +"  二进制:" + Integer.toBinaryString(i) + " 长度:" + (Integer.toBinaryString(i)+ "").length());
        }
    }



    public  static void printByteInfo1(){
        System.out.println("-------------------正数,负数,交替-------------------");
        System.out.println("-------------------正数,负数,交替-------------------");
        System.out.println("-------------------正数,负数,交替-------------------");
        for(int i = 0 ;i <= 256 ;i++){
            System.out.println("十进制:" + i +"  二进制:" + Integer.toBinaryString(i) + " 长度:" + Integer.toBinaryString(i).toString().length());
            System.out.println("二进制:" + (byte)i +"  二进制:" + Integer.toBinaryString((byte)i) + " 长度:" + Integer.toBinaryString((byte)i).toString().length());
            System.out.println("十进制:" + -i +"  二进制:" + Integer.toBinaryString(-i) + " 长度:" + Integer.toBinaryString(-i).toString().length());
        }
    }


    public int getValue(int n){
        return 0;
    }
}
