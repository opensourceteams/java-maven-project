package com.opensourceteams.modules.common.java.binary;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/9  上午11:56
 * 功能描述:
 */

public class BinaryUtil {

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

    /**
     *  将byte 表现为bit 的字符串形式
     * @param value 传入 btye 数组
     * @return 返回bit字符串
     */
    public static String intToBitsByByteLength(int value){

        int INT_MAX_VALUE = 1073741824;
        if(value > INT_MAX_VALUE){
            throw new RuntimeException("最大比较整数值为:" + INT_MAX_VALUE) ;
        }
        /**
         * 十进制数:1073741824 转成二进制后:1000000000000000000000000000000 长度:31
         * 或运算定理:只要有一个为1,就是1,没有一个1,就是0
         * 即:位运算 | 0 或任何数,都得原数
         */
        String str = Integer.toBinaryString(value | INT_MAX_VALUE);
        //return str;
        return str.substring(1);
    }

    public static String intToBitsByByteLength(int value, int byteLength){

        int INT_MAX_VALUE = 1073741824;
        int MAX_VALUE = getMaxValueByByteLength(byteLength);
        if(value > MAX_VALUE){
            throw new RuntimeException("byte长度为:" + byteLength+ "  最大比较整数值为:" + MAX_VALUE) ;
        }
        /**
         * 十进制数:1073741824 转成二进制后:1000000000000000000000000000000 长度:31
         * 或运算定理:只要有一个为1,就是1,没有一个1,就是0
         * 即:位运算 | 0 或任何数,都得原数
         */
        String str = Integer.toBinaryString(value | INT_MAX_VALUE);
        return str.substring(str.length() - 8*byteLength);
    }

    /**
     *  指定 bit位数的长度,把Int 转换为对应的 bit字符串
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
    public static String intToBitsByBitLength(int value, int bitLength){

        int INT_MAX_VALUE = 1073741824;
        int MAX_VALUE = getMaxValueByBitLength(bitLength);
        if(value > MAX_VALUE){
            throw new RuntimeException("bit 长度为:" + bitLength+ "  最大比较整数值为:" + MAX_VALUE) ;
        }
        /**
         * 十进制数:1073741824 转成二进制后:1000000000000000000000000000000 长度:31
         * 或运算定理:只要有一个为1,就是1,没有一个1,就是0
         * 即:位运算 | 0 或任何数,都得原数
         */
        String str = Integer.toBinaryString(value | INT_MAX_VALUE);
        return str.substring(str.length() - bitLength);
    }

    /**
     byte 为固定位数1位,最大整数值:255
     byte 为固定位数2位,最大整数值:65535
     byte 为固定位数3位,最大整数值:16777215
     byte 为固定位数4位,最大整数值:2147483647
     * @param byteLength
     * @return
     */
    public static int getMaxValueByByteLength(int byteLength){
        StringBuffer sb = new StringBuffer();
        sb.append("1");
        for(int i =0;i< byteLength * 8 -1;i++){
            sb.append("1");
        }

        if(sb.length() >=32){
            return BinaryUtil.convertIntByBit(sb.toString().substring(sb.length() - 31));
        }

        return BinaryUtil.convertIntByBit(sb.toString());
    }

    /**
     * 根据bit长度,得到最大的bit值
     * @param length
     * @return
        通过bit位数:1,得到的最大整数值1
        通过bit位数:2,得到的最大整数值3
        通过bit位数:3,得到的最大整数值7
        通过bit位数:4,得到的最大整数值15
        通过bit位数:5,得到的最大整数值31
        通过bit位数:6,得到的最大整数值63
        通过bit位数:7,得到的最大整数值127
        通过bit位数:8,得到的最大整数值255
     */
    public static int getMaxValueByBitLength(int length){
        StringBuffer sb = new StringBuffer();

        for(int i =0;i< length ;i++){
            sb.append("1");
        }

        if(sb.length() >=32){
            return BinaryUtil.convertIntByBit(sb.toString().substring(sb.length() - 31));
        }

        return BinaryUtil.convertIntByBit(sb.toString());
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
            calValue = BinaryUtil.convertIntByBit(sb.toString());
            if(calValue >= value ){
                return sb.length();
            }
        }
        return 0;
    }


    /**
     * (请调用 byteToBits 方法,性能更高)此方法,只适用于正数
     * @param value
     * @return
     */
    public static String convertBinary(int value){
        if(value < 0){
            throw new RuntimeException("值必须大于等于0");
        }
        if(value == 0 || value == 1){
            return  value +"";
        }
        StringBuffer sb = new StringBuffer();
        int calVal = value;
        while (calVal !=0 && calVal !=1){

            sb.insert(0,calVal % 2);
            calVal = calVal / 2;
            if(calVal == 0 || calVal == 1){
                sb.insert(0,calVal % 2);
            }
        }
        return sb.toString();
    }

    /**
     *  支持bit类型的字符串 数据转为整数,只支持 转换到正数 和0,不支持负数
     * @param str
     * @return
     */
    public static int convertIntByBit(String str){
        int result = 0;
        for(int i =0 ;i< str.length();i++){
            int charValue = Integer.parseInt(str.substring(str.length() -1 -i,str.length()-i));
            int returnCharValue = 1;
            if(charValue == 0){
                returnCharValue = 0;
            }else if(charValue == 1 && i ==0){
                returnCharValue = 1;
            }else{
                for(int j=1 ;j <=i;j++){
                    returnCharValue = returnCharValue * 2;

                }
            }
            result = result + returnCharValue;

        }
        return result;
    }


}
