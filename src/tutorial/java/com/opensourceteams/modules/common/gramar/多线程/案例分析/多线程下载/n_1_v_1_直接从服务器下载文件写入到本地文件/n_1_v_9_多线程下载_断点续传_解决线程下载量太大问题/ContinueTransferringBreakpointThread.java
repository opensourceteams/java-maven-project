package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_9_多线程下载_断点续传_解决线程下载量太大问题;

import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;
import com.opensourceteams.modules.common.java.io.file.FilePathUtil;

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
        while (true){
            ++i;
            try {
                Properties p = new Properties();

                //p.load(new FileInputStream(filePath));
                char split = ',';
                String filePath = "";
                if(downloadBytesBeanVector != null && downloadBytesBeanVector.size() >0 ){
                    StringBuffer sb = null;
                    for (DownloadBytesBean d : downloadBytesBeanVector){
                        //该线程还在
                        if(!d.isOver()){
                            //System.out.println("断点续传保存的东西:" +d);
                            filePath = d.getSaveFilePath() +".tmp";
                            d.getBeginIndex() ;
                            d.getAmount();
                            d.getIndex();

                            sb = new StringBuffer();
                            sb.append(d.getBeginIndex());
                            sb.append(split);
                            sb.append(d.getAmount());


                            p.setProperty("thread." + d.getIndex(),sb.toString());

                            File f = FilePathUtil.createNewFile(filePath);
                            p.setProperty("i",i+"");
                            p.setProperty("thread.count", downloadBytesBeanVector.size()+"");
                            fos = new FileOutputStream(f);
                            p.store(fos,"保存文件的下载信息,用作断点续传");

                            System.out.println(downloadBytesBeanVector.size() + "保存了"+(i)+"次:" +p);
                        }



                    }

                }


                //FilePathUtil.deleteFile(filePath);

                //还没有线程开始启动
                if("".equals(filePath)){
                    Thread.sleep(100);
                    continue;

                }

                //进来的线程都跑完了
                boolean isAllOver = true;
                if(downloadBytesBeanVector != null && downloadBytesBeanVector.size() >0 ){
                    for (DownloadBytesBean d : downloadBytesBeanVector){
                        isAllOver = d.isOver() && isAllOver;
                    }
                }
                if(isAllOver){
                    File f = FilePathUtil.createNewFile(filePath);
                    p = new Properties();
                    p.setProperty("i",i+"");
                    p.setProperty("thread.count",0+"");
                    fos = new FileOutputStream(f);
                    p.store(fos,"保存文件的下载信息,用作断点续传0");

                    System.out.println(downloadBytesBeanVector.size() + "保存了"+(i)+"次:" +p);

                    //当前线程都执行完了
                    System.out.println("当前线程都执行完了");
                    Thread.currentThread().stop();
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
