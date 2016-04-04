package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_12_多线程下载_断点续传_解决保存数据的问题2;

import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;


/**
 * 日期: 2016-03-27  18:36
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Test1 {

    /**
     * ).需求说明:
     * ).服务器有一个20 个byte 长度的文件,范围索引{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19},需要断点续传下载到本地
     * ).本地已经下载了该文件的一部分,下载的范围为{0,2},{7,3},{14,1}
     *  )0:0 -> 6   {0,1,2,3,4,5,6}
     *  )1:7 -> 13  {7,8,9,10,11,12,13}
     *  )2:14 -> 19 {14,15,16,17,18,19}
     *    即 文件一共20个byte可以分为 0 到19这20个byte,已下载索引{0,1},{7,8,9},{14}
     * ).现要求分n个线程去下载,都能返回每个线程的,下载区间范围,结果用List返回,
     * ).每个线程中有y个下载区间 ,每段区间用Map<Integer,Integer>,表示开始索引和长度
     * ).List<Map<Integer,Integer>> 存储同一个线程的所有区间
     * )List 是结果返回值,要求返回所有线程的下载范围
     * 举例:
     * ).n = 1 时,返回的数据是    [{2,3,4,5,6},{7,8,9},{13},{14,15,16},{18,19}]
     * ).n = 2 时,返回的数据是  [[{2,3,4,5,6},{10,11}],[{12,13},{15,16,17,18,19}]]
     * @param args
     */


    public static void main(String[] args) {

        Vector<DownloadBytesBean> vector = new Vector<DownloadBytesBean>();
        DownloadBytesBean d0 = new DownloadBytesBean();
        d0.setBeginIndex(0);
        d0.setAmount(2);
        d0.setEndIndex(7);
        vector.add(d0);

        DownloadBytesBean d1 = new DownloadBytesBean();
        d1.setBeginIndex(7);
        d1.setAmount(3);
        d1.setEndIndex(14);
        vector.add(d1);

        DownloadBytesBean d2 = new DownloadBytesBean();
        d2.setBeginIndex(14);
        d2.setAmount(1);
        d2.setEndIndex(20);
        vector.add(d2);



        /*int[] arry0 = {0,2};
        int[] arry1 = {7,3};//
        int[] arry2 = {14,1};
        int[][] list = {arry0,arry1,arry2};*/



        int total = 20;
        int n = 3 ;
        Vector<DownloadBytesBean> resultVector = breakpoint(n,total,vector);
        for (DownloadBytesBean d : resultVector){
            System.out.println("beginIndex:" +d.getBeginIndex() +" -> "  +" endIndex :" +d.getEndIndex());
            List<Integer[]> list = d.getRangList();
            for (Integer[] v: list){
                System.out.println(v[0] +" -> " +v[1]);
            }
            System.out.println("\n");
        }







    }


    public static Vector<DownloadBytesBean>  breakpoint(int n,int total,Vector<DownloadBytesBean> oldVector){

        Vector<DownloadBytesBean> result = new Vector<DownloadBytesBean>();
        int totalAmount = 0 ;
        Collections.sort(oldVector);
        for (DownloadBytesBean d: oldVector){
            System.out.println(d.getBeginIndex());
            totalAmount = totalAmount +d.getAmount();
        }

        System.out.println("已下载总量:" + totalAmount);

        int totalDown = total - totalAmount;//新的需要下载的总量
        int capacity = totalDown / n ;
        int remain = totalDown % n ;
        int len = 0 ; //每次下载的长度
        int previousEndIndex = -1 ;//已分配总长度
        DownloadBytesBean downloadBytesBean = null;
        for (int i = 0 ;i< n; i++){
            downloadBytesBean = new DownloadBytesBean();
            if(i ==0){
                len = capacity + remain;
            }else{
                len = capacity;
            }
            if(remain > 0){
                len = capacity ;
            }
            downloadBytesBean.setLength(len);

            processDownloadBytesBean(previousEndIndex,downloadBytesBean,oldVector);
            result.add(downloadBytesBean);
            previousEndIndex = downloadBytesBean.getEndIndex();
        }
        return result;

    }


    public static void processDownloadBytesBean(int previousEndIndex, DownloadBytesBean downloadBytesBean, Vector<DownloadBytesBean> oldVector){

        int beginIndex = 0;
        int endIndex = 0;
        int oldNextBeginIndex = 0; //按以前的区间,开始索引
        int oldRemain = 0 ;//以前的单次区间,还剩多少个数可以下载
        int oldEndIndex = 0 ;//按以前的区间,结束的索引



        int len = downloadBytesBean.getLength(); //每次下载的长度
        int allocation = 0 ;//当前分配了多少量

        DownloadBytesBean lastDownloadBytesBean = oldVector.get(oldVector.size()-1);

        List<Integer[]> rangList = new ArrayList<Integer[]>(); //断点续传使用
        Integer[]  rang = new Integer[2];


        if(previousEndIndex > lastDownloadBytesBean.getEndIndex()){
            //说明旧的已分配完成
            beginIndex = previousEndIndex;
            endIndex = previousEndIndex + len;
            rang = new Integer[2];
            rang[0] = beginIndex;
            rang[1] = endIndex;
            rangList.add(rang);

            downloadBytesBean.setBeginIndex(beginIndex);
            downloadBytesBean.setEndIndex(endIndex);
            downloadBytesBean.setRangList(rangList);

            return;

        }else{
            //说明旧的还没取完,从旧的开始取

            for (int i = 0 ;i < oldVector.size();i++){
                DownloadBytesBean downloadBytesBeanOld =  oldVector.get(i);
                oldNextBeginIndex = downloadBytesBeanOld.getBeginIndex() + downloadBytesBeanOld.getAmount();
                oldEndIndex = downloadBytesBeanOld.getEndIndex();
                oldRemain = downloadBytesBeanOld.getEndIndex()   - oldNextBeginIndex;

                if(oldEndIndex > previousEndIndex && oldRemain > 0){


                    //说明该次还可以继续下载

                    if(beginIndex == 0){
                        if(previousEndIndex >oldNextBeginIndex){
                            beginIndex = previousEndIndex;
                            oldRemain = oldRemain - (previousEndIndex - oldNextBeginIndex);
                            oldNextBeginIndex = oldNextBeginIndex + (previousEndIndex - oldNextBeginIndex);
                        }else{
                            beginIndex = oldNextBeginIndex;
                        }

                    }


                    if(oldRemain >= (len - allocation)){
                        //可以放满
                        endIndex = oldNextBeginIndex + (len - allocation);
                        rang = new Integer[2];
                        rang[0] = oldNextBeginIndex;
                        rang[1] = endIndex;
                        rangList.add(rang);
                        previousEndIndex = endIndex;
                        oldEndIndex = endIndex;
                    }else{
                        //填不满

                        if(i == oldVector.size() - 1){
                            endIndex = oldNextBeginIndex + (len - allocation);
                            rang = new Integer[2];
                            rang[0] = oldNextBeginIndex;
                            rang[1] = endIndex;
                            rangList.add(rang);
                            allocation = allocation + (len - allocation);
                        }else{

                            rang = new Integer[2];
                            rang[0] = oldNextBeginIndex;
                            rang[1] = oldEndIndex;
                            rangList.add(rang);
                            previousEndIndex = oldEndIndex;


                            allocation = allocation +oldRemain;
                        }

                    }

                    if(beginIndex > 0 && endIndex >0){
                        downloadBytesBean.setBeginIndex(beginIndex);
                        downloadBytesBean.setEndIndex(oldEndIndex);
                        downloadBytesBean.setRangList(rangList);
                        return;

                    }
                }


















            }
        }

    }


}
