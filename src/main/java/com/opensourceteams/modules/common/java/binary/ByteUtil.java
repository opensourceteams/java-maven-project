package com.opensourceteams.modules.common.java.binary;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/22  下午12:06
 * 功能描述:
 */

public class ByteUtil {


    /**
     * byte 数组转 int
     * @param value
     * @return
     */
    public static byte[]  toBytesByInt(int value){

        byte[] bytes = new byte[4];

        bytes[0] = (byte) value ;
        bytes[1] = (byte) (value >> 8 ) ;
        bytes[2] = (byte) (value >> (8 * 2) ) ;
        bytes[3] = (byte) (value >> (8 * 3) ) ;



        return bytes;
    }

    /**
     * byte 数组转 long
     * @param value
     * @return
     */
    public static byte[]  toBytesByLong(long value){

        byte[] bytes = new byte[8];

        bytes[0] = (byte) value ;
        bytes[1] = (byte) (value >> 8 ) ;
        bytes[2] = (byte) (value >> (8 * 2) ) ;
        bytes[3] = (byte) (value >> (8 * 3) ) ;
        bytes[4] = (byte) (value >> (8 * 4) ) ;
        bytes[5] = (byte) (value >> (8 * 5) ) ;
        bytes[6] = (byte) (value >> (8 * 6) ) ;
        bytes[7] = (byte) (value >> (8 * 7) ) ;



        return bytes;
    }

    /**
     * int 转 byte数组
     * @param array
     * @return
     */
    public static int  toIntByBytes(byte[] array){
        int result = 0 ;

        int l0 = array[0] & 0xff ;
        int l1 = (array[1] & 0xff) << 8 ;
        int l2 = (array[2] & 0xff) << (8 * 2) ;
        int l3 = (array[3] & 0xff) << (8 * 3) ;


        return l0 | l1 | l2 | l3;
    }

    /**
     * int 转 byte数组
     * @param array
     * @return
     */
    public static long  toLongByBytes(byte[] array){
        long result = 0 ;

        long l0 = array[0] & 0xffL ;
        long l1 = (array[1] & 0xffL) << 8 ;
        long l2 = (array[2] & 0xffL) << (8 * 2) ;
        long l3 = (array[3] & 0xffL) << (8 * 3) ;
        long l4 = (array[4] & 0xffL) << (8 * 4) ;
        long l5 = (array[5] & 0xffL) << (8 * 5) ;
        long l6 = (array[6] & 0xffL) << (8 * 6) ;
        long l7 = (array[7] & 0xffL) << (8 * 7) ;


        return l0 | l1 | l2 | l3 | l4 | l5 | l6 | l7;
    }
}
