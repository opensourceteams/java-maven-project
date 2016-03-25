package com.opensourceteams.modules.common.java.algorithm;

import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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


    /**
     * 根据byte数组的长度,分配线程数量,有指定的最大线程数限制
     * )当总容量按每个容量单位分,总个数 size 小于等于总线程数时,线程数按size来分
     * )当总容量按每个容量单位分,总个数 size 大于总线程数时,线程数按总线程数来分
     * @param bytes
     * @param maxThread
     * @return
     */
    public static Vector<byte[]> splitBytes(byte[] bytes,int maxThread){


        Vector<byte[]> vector = new Vector<byte[]>();

        if(bytes == null){
            return null;
        }

        int size = bytes.length /1024 /1024 ;//一共有多少M,默认1M分配一个线程处理

        if(size <= maxThread){
            //就按实际多少M就跑多少个线程

            for (int i = 0 ;i < size;i++){
                byte[] subBytes = new byte[1024 * 1024];
                vector.add(subBytes);
            }


            int module = bytes.length % (1024 * 1024);
            if(module > 0){
                size = size + 1;
                byte[] subBytes = new byte[module];
                vector.add(subBytes);

            }
        }else {
            //按最大线程数来跑
            for (int i = 0 ;i < maxThread;i++){
                if(bytes.length % maxThread > 0){
                    size = size + 1;
                    if( i == 0){
                        byte[] subBytes = new byte[bytes.length / maxThread + (bytes.length % maxThread)];
                        vector.add(subBytes);
                        continue;
                    }

                }
                byte[] subBytes = new byte[bytes.length / maxThread];
                vector.add(subBytes);


            }

        }

        return vector;
    }



    /**
     * 默认为每个线程分配1024 * 1024 byte 容量,即为1M
     * 根据byte数组的长度,分配线程数量,有指定的最大线程数限制
     * )当总容量按每个容量单位分,总个数 size 小于等于总线程数时,线程数按size来分
     * )当总容量按每个容量单位分,总个数 size 大于总线程数时,线程数按总线程数来分
     * @param bytesLength
     * @param maxThread
     * @return
     */
    public static Vector<DownloadBytesBean> splitBytesToVector(int bytesLength,int maxThread,String url,String saveFilePath){

        Vector<DownloadBytesBean> vector = new Vector<DownloadBytesBean>();
        int capacity = bytesLength / maxThread ;
        int remain = bytesLength % maxThread;

        for (int i = 0 ;i < maxThread;i++){

            if(i == maxThread - 1 && remain > 0){
                DownloadBytesBean downloadBytesBean = new DownloadBytesBean(i * capacity,bytesLength,i,bytesLength,url,saveFilePath);
                vector.add(downloadBytesBean);
            }else{
                DownloadBytesBean downloadBytesBean = new DownloadBytesBean(i * capacity,(i + 1 ) * capacity,i,bytesLength,url,saveFilePath);
                vector.add(downloadBytesBean);
            }

        }

        return vector;
    }
    public static Vector<DownloadBytesBean> splitBytesToVector(int bytesLength,int maxThread,List<DownloadBytesBean> downloadBytesBeanList){


        int totalAmount = 0; //已下载的总量信息
        for (DownloadBytesBean d : downloadBytesBeanList){
            totalAmount += d.getAmount();
        }

        int downloadLength = bytesLength - totalAmount; //需要下载的总量信息
        Vector<DownloadBytesBean> vector = new Vector<DownloadBytesBean>();
        int capacity = downloadLength / maxThread ; //每个线程下载的容量信息
        int remain = downloadLength % maxThread;   //每个线程下载的容量信息,是否还有剩的

        int len = 0 ;//每个线程分配的长度
        for (int i = 0 ;i < maxThread;i++){

            if(i == maxThread - 1 && remain > 0){
                len = capacity + remain;

            }else{
                len = capacity;
            }

        }

        return vector;
    }








}
