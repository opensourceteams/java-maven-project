package com.opensourceteams.modules.common.gramar.二进制.十进制轩二进制表示;

import com.opensourceteams.modules.common.java.binary.BinaryStringUtil;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/9  上午9:56
 * 功能描述: byte -128 到 127 的bit 表现形式
 */

public class BinaryTest {

    public static void main(String[] args) throws RuntimeException {

        showByte256();

     /*   int value = 16;


        System.out.println(getMaxBitLengthByInt(value));

        getMaxValueByBitLength();
*/


       // getMaxValueByByteLength(1);
        //getMaxValueByByteLength(2);
      // printIntToBits();
       // printByteToBits();
       // getMaxValueByByteLength2();

    }

    /**
     通过bit位数:1,得到的最大整数值1
     通过bit位数:2,得到的最大整数值3
     通过bit位数:3,得到的最大整数值7
     通过bit位数:4,得到的最大整数值15
     通过bit位数:5,得到的最大整数值31
     通过bit位数:6,得到的最大整数值63
     通过bit位数:7,得到的最大整数值127
     通过bit位数:8,得到的最大整数值255
     通过bit位数:9,得到的最大整数值511
     通过bit位数:10,得到的最大整数值1023
     通过bit位数:11,得到的最大整数值2047
     通过bit位数:12,得到的最大整数值4095
     通过bit位数:13,得到的最大整数值8191
     通过bit位数:14,得到的最大整数值16383
     通过bit位数:15,得到的最大整数值32767
     通过bit位数:16,得到的最大整数值65535
     通过bit位数:17,得到的最大整数值131071
     通过bit位数:18,得到的最大整数值262143
     通过bit位数:19,得到的最大整数值524287
     通过bit位数:20,得到的最大整数值1048575
     通过bit位数:21,得到的最大整数值2097151
     通过bit位数:22,得到的最大整数值4194303
     通过bit位数:23,得到的最大整数值8388607
     通过bit位数:24,得到的最大整数值16777215
     通过bit位数:25,得到的最大整数值33554431
     通过bit位数:26,得到的最大整数值67108863
     通过bit位数:27,得到的最大整数值134217727
     通过bit位数:28,得到的最大整数值268435455
     通过bit位数:29,得到的最大整数值536870911
     通过bit位数:30,得到的最大整数值1073741823
     通过bit位数:31,得到的最大整数值2147483647
     通过bit位数:32,得到的最大整数值2147483647

     */
    public static void getMaxValueByBitLength(){
        for(int i =0;i<32;i++){
            System.out.println("通过bit位数:" +(i + 1)+ ",得到的最大整数值" + BinaryStringUtil.getMaxValueByBitLength(i +1));
        }
    }

    /**
     * 根据值得到,最大bit的长度
     * @param value
     * @return
     */
    public static int getMaxBitLengthByInt(int value ){
        StringBuffer sb = new StringBuffer();
        int calValue = 0;
        for(int i =0;i< 31;i++){
            sb.append("1");
            calValue = BinaryStringUtil.convertIntByBit(sb.toString());
            if(calValue >= value ){
                return sb.length();
            }
        }
        return 0;
    }

    public  static void getMaxValueByByteLength2(){
        System.out.println( "byte 为固定位数1位,最大整数值:" + BinaryStringUtil.getMaxValueByByteLength(1));
        System.out.println( "byte 为固定位数2位,最大整数值:" + BinaryStringUtil.getMaxValueByByteLength(2));
        System.out.println( "byte 为固定位数3位,最大整数值:" + BinaryStringUtil.getMaxValueByByteLength(3));
        System.out.println( "byte 为固定位数4位,最大整数值:" + BinaryStringUtil.getMaxValueByByteLength(4));


    }

    public static void showByte256(){

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

    public  static void printByteToBits(){
        byte i = - 128;
        for (; i< 127;i++ ){

            System.out.println(  "byte类型的数:" + i+ " 转换为bit的表现形式:" + BinaryStringUtil.byteToBits(i)  +" 长度:" + BinaryStringUtil.byteToBits(i).length());

        }
        System.out.println(  "byte类型的数:" + i+ " 转换为bit的表现形式:" + BinaryStringUtil.byteToBits(i)  +" 长度:" + BinaryStringUtil.byteToBits(i).length());

    }

    public static int getMaxValueByByteLength(int byteLength){
        StringBuffer sb = new StringBuffer();
        sb.append("1");
        for(int i =0;i< byteLength * 8 -1;i++){
            sb.append("1");
            System.out.println(sb.toString() +" : " + BinaryStringUtil.convertIntByBit(sb.toString()) + " 长度:" + sb.toString().length());
        }

        return 0;
    }

    public  static void printIntToBits(){

        StringBuffer sb = new StringBuffer();
        sb.append("1");
        for(int i =0;i<30;i++){
            sb.append("0");
            System.out.println(sb.toString() +" : " + BinaryStringUtil.convertIntByBit(sb.toString()) + " 长度:" + sb.toString().length());
        }

        System.out.println(Integer.MAX_VALUE);

  /*      System.out.println("=======计算完成");
        int i = 0;
        for (; i< 200;i++ ){

            System.out.println(  "byte类型的数:" + i+ " 转换为bit的表现形式:" + BinaryUtil.intToBitsByByteLength(i)  +" 长度:" + BinaryUtil.intToBitsByByteLength(i).length());

        }
        System.out.println(  "byte类型的数:" + i+ " 转换为bit的表现形式:" + BinaryUtil.intToBitsByByteLength(i)  +" 长度:" + BinaryUtil.intToBitsByByteLength(i).length());
*/
    }


    public static void printConvertBinary(){
        for (int i = 0;i < 128 ;i++){
            System.out.println("int 数字:" +i +" 转为二进制的表现形式为:" + BinaryStringUtil.convertBinary(i));
        }

    }

    public static void printConvertIntByBinary(){
        int value = BinaryStringUtil.convertIntByBit("1");
        System.out.println(value);

        value = BinaryStringUtil.convertIntByBit("1");
        System.out.println(value);

        value = BinaryStringUtil.convertIntByBit("10");
        System.out.println(value);

        value = BinaryStringUtil.convertIntByBit("11");
        System.out.println(value);

        value = BinaryStringUtil.convertIntByBit("100");
        System.out.println(value);

        value = BinaryStringUtil.convertIntByBit("101");
        System.out.println(value);
        value = BinaryStringUtil.convertIntByBit("110");
        System.out.println(value);
        value = BinaryStringUtil.convertIntByBit("111");
        System.out.println(value);

        value = BinaryStringUtil.convertIntByBit("1000");
        System.out.println(value);
        value = BinaryStringUtil.convertIntByBit("1001");
        System.out.println(value);
        value = BinaryStringUtil.convertIntByBit("1010");
        System.out.println(value);
        value = BinaryStringUtil.convertIntByBit("1011");
        System.out.println(value);


    }
}
