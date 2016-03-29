package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_11_多线程下载_断点续传_从保存已下载数据文件继续下载;

import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;

import java.util.List;
import java.util.Map;

/**
 * 日期: 2016-03-27  18:36
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Test {

    /**
     * ).需求说明:
     * ).服务器有一个20 个byte 长度的文件,范围索引{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19},需要断点续传下载到本地
     * ).本地已经下载了该文件的一部分,下载的范围为{0,2},{10,5}
     *    即 文件一共20个byte可以分为 0 到19这20个byte,已下载索引{0,1},{10,11,12,13,14}
     * ).现要求分n个线程去下载,都能返回每个线程的,下载区间范围,结果用List返回,
     * ).每个线程中有y个下载区间 ,每段区间用Map<Integer,Integer>,表示开始索引和长度
     * ).List<Map<Integer,Integer>> 存储同一个线程的所有区间
     * )List 是结果返回值,要求返回所有线程的下载范围
     * 举例:
     * ).n = 1 时,返回的数据是 [{2,3,4,5,6,7,8,9},{15,16,17,18,19}]
     * ).n = 2 时,返回的数据是  [[{2,3,4,5,6,7,8}],[{9,15,16,17,18,19}]]
     * @param args
     */


    public static void main(String[] args) {
        //1
        /** 20
         * 0 -->19
         * 1:0-->9
         * 2:10->19
         */
        int[] arry0 = {0,2};
        int[] arry1 = {11,5};//2
        int[][] list = {arry0,arry1};

        /**
         * 期望结果
         *  一个线程:
         *  {2,9},{16,19}
         *
         *
         */
        int total = 20;




    }


    public void a(int n){

    }
}
