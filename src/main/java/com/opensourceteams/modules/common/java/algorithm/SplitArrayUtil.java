package com.opensourceteams.modules.common.java.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  下午5:47
 * 功能描述:
 */

public class SplitArrayUtil {


    /**
     *
     ).报文设计
     ).第一个byte 的第一个bit 0:表示当前数据包   1:表示下一个数据包
     ).第一个byte 的第二个bit开始,的后7个bit,表示,当前有多少个数据包 范围是 0 到 127 个数  127 * 50 kb = 6350 KB = 6.2 MB
     ).第二个byte 表示一共有多少个数据包,范围是 0 到 255
     ).后面
     * @param bytes
     * @param max
     * @return
     */
    public static List<byte[]> splitArray(byte[] bytes,int max,byte type){


        List<byte[]> list = new ArrayList<byte[]>();
        if(bytes == null){
            return null;
        }
        if(bytes.length <= max){
            /**
             * 此情况,总数据量小于一次包的最大量,所以一次能发完
             */
            byte[] nextBytes = new byte[max];
            nextBytes[0] = type;


            byte currentCount = 1;
            byte totalCount = 1;
            byte b =  (byte) (currentCount | totalCount << 1 );

            nextBytes[1] = b;
            System.arraycopy(bytes,0,nextBytes,2,bytes.length);
            list.add(nextBytes);

        }else{

            int count = bytes.length / (max - 2 ) ;
            int lastByteLength = bytes.length % (max - 2 );
            if( lastByteLength > 0){
                count = count + 1;
            }

            for (int i = 1 ;i <= count ;i++){
                if(i< count){
                    //第一个数据包
                    byte[] nextBytes = new byte[max];

                    int currentCount = i;
                    int totalCount = count;
                    byte b =  (byte) totalCount;

                    nextBytes[0] = (byte) (type | currentCount << 1);
                    nextBytes[1] = b;
                    System.arraycopy(bytes,(i - 1) * (max - 2),nextBytes,2,max - 2);

                    list.add(nextBytes);

                }else if(i == count){
                    //最后一个数据包
                    if(lastByteLength == 0){
                        byte[] nextBytes = new byte[max];
                        int currentCount = i;
                        int totalCount = count;
                        byte b =  (byte) totalCount;

                        nextBytes[0] = (byte) (type | currentCount << 1);
                        nextBytes[1] = b;
                        System.arraycopy(bytes,(i - 1) * (max - 2),nextBytes,2,max - 2);

                        list.add(nextBytes);

                    }else{
                        byte[] nextBytes = new byte[lastByteLength + 2];
                        int currentCount = i;
                        int totalCount = count;
                        byte b =  (byte) totalCount;

                        nextBytes[0] = (byte) (type | currentCount << 1);
                        nextBytes[1] = b;
                        System.arraycopy(bytes,(i - 1) * (max - 2),nextBytes,2 ,lastByteLength);

                        list.add(nextBytes);

                    }


                }

            }

        }


        return list;
    }


    /**
     * 得到分隔的实际值
     * @param b
     * @return
     */
    public static  byte[] getSplitValue(byte b){
        byte[] bytes = new byte[2];
        bytes[0] = (byte) (b & 0x01);
        bytes[1] = (byte)(b >>> 1);
        return bytes;
    }
}
