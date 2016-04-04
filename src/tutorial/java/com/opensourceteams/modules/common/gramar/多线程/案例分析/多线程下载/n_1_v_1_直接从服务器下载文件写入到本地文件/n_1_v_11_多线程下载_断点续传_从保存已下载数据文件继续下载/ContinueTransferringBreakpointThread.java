package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_11_多线程下载_断点续传_从保存已下载数据文件继续下载;

import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;
import com.opensourceteams.modules.common.java.io.file.FilePathUtil;
import com.opensourceteams.modules.common.java.util.properties.PropertiesUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Vector;

/**
 * 日期: 2016-03-24  07:13
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:断点续传线程类
 * ).每隔一段时间,将当前已下载量保存到文件中
 */
public class ContinueTransferringBreakpointThread extends Thread{

    Vector<DownloadBytesBean> downloadBytesBeanVector = new Vector<DownloadBytesBean>();




    @Override
    public void run() {
        FileOutputStream fos = null;
        int i =0;
        int breakpointCount = 0 ;
        //进来的线程都跑完了
        boolean isAllOver = false;
        while (true){

            while (Download_URLUtil.globalIsSuspend){
                System.out.println(Thread.currentThread().getName() + "暂停");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            while (Download_URLUtil.globalIsStop){
                System.out.println(Thread.currentThread().getName() +"停止");
                return ;
            }


            breakpointCount = 0 ;

            try {
                Properties p = new Properties();

                //p.load(new FileInputStream(filePath));
                char split = ',';
                String filePath = "";
                if(downloadBytesBeanVector != null && downloadBytesBeanVector.size() >0 ){
                    StringBuffer sb = null;
                    for (DownloadBytesBean d : downloadBytesBeanVector){
                        ++i;
                        filePath = d.getSaveFilePath() +".download";

                        if(d.isOver()){
                            PropertiesUtil.removeKey(filePath,"thread.index." + d.getIndex());

                        }else if(!d.isOver() && d.getAmount() > 0){
                            //该线程还在
                            // TODO: 16/3/27 不能每个线程单独写一次到属性文件,要改成批量一次性写完
                            breakpointCount++;

                            d.getBeginIndex() ;
                            d.getAmount();
                            d.getIndex();

                            sb = new StringBuffer();
                            sb.append(d.getBeginIndex());
                            sb.append(split);
                            sb.append(d.getAmount());
                            sb.append(split);
                            sb.append(d.getEndIndex());


                            p.setProperty("thread.index." + d.getIndex(),sb.toString());
                            p.setProperty("saveFilePath",d.getSaveFilePath());
                            p.setProperty("url",d.getUrlStr());
                            p.setProperty("thread.totalLength",d.getTotalLength()+"");


                            p.setProperty("i",i+"");
                            p.setProperty("thread.count", breakpointCount+"");


                            System.out.println(breakpointCount + "保存了"+(i)+"次:" +p);

                            File f = FilePathUtil.createNewFile(filePath);
                            fos = new FileOutputStream(f);
                            p.store(fos,"保存文件的下载信息,用作断点续传");
                        }







                    }

                }


                //FilePathUtil.deleteFile(filePath);

                //还没有线程开始启动
                if("".equals(filePath)){
                    Thread.sleep(1000 * 5);

                    continue;

                }else{

                    Thread.sleep(1000 * 5);
                }


                isAllOver = true;
                if(downloadBytesBeanVector != null && downloadBytesBeanVector.size() >0 ){
                    for (DownloadBytesBean d : downloadBytesBeanVector){
                        isAllOver = d.isOver() && isAllOver;
                    }
                }
                if(isAllOver){
                    System.out.println("删除下载元数据文件:" + filePath);
                    FilePathUtil.deleteFile(filePath);


                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(fos != null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public Vector<DownloadBytesBean> getDownloadBytesBeanVector() {
        return downloadBytesBeanVector;
    }

    public void setDownloadBytesBeanVector(Vector<DownloadBytesBean> downloadBytesBeanVector) {
        this.downloadBytesBeanVector = downloadBytesBeanVector;
    }
}
