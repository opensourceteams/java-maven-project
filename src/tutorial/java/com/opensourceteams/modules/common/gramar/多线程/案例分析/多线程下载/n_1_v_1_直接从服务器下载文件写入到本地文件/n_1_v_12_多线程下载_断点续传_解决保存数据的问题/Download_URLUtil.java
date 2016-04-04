package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_12_多线程下载_断点续传_解决保存数据的问题;

import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;
import com.opensourceteams.modules.common.java.io.file.FilePathUtil;
import com.opensourceteams.modules.common.java.util.net.URLUtil;

import java.io.*;
import java.net.URLConnection;
import java.util.List;
import java.util.Vector;

/**
 * Created by hadoop on 16/3/24.
 */
public class Download_URLUtil extends URLUtil {


    public static boolean globalIsSuspend = false;//暂停

    public static boolean globalIsStop = false;//停止




    public static byte[] getBytesIsSuspend( DownloadBytesBean downloadBytesBean) throws Exception {

        URLConnection urlConnection = openConnection(downloadBytesBean.getUrlStr());
        if(urlConnection == null){
            return  null;
        }else{
            urlConnection.setRequestProperty("Range","bytes="+ downloadBytesBean.getBeginIndex()+"-" + (downloadBytesBean.getEndIndex() -1));
            if(urlConnection.getContentLength() <= 0){
                return  null;
            }
        }


        Vector<String> vector = new Vector<String>();
        vector.add("application/octet-stream");
        vector.add("application/zip");
        vector.add("binary/octet-stream");


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if(true){
            //支持直接读写的方式,其它压缩处理的文件,需要相应的解压处理,不然,下载后用不了

            byte[] buffer = new byte[1024];
            try {
                InputStream is = urlConnection.getInputStream();
                int len = 0 ;
                while ((len = is.read(buffer)) != -1){
                    while (globalIsSuspend){
                        System.out.println(Thread.currentThread().getName() + "暂停");
                        Thread.sleep(1000);

                    }

                    while (globalIsStop){
                        System.out.println(Thread.currentThread().getName() +"停止");
                        return null;
                    }

                    baos.write(buffer,0,len);
                    //记录当前累记的下载量
                    downloadBytesBean.setAmount(downloadBytesBean.getAmount() + len);


                }


            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(baos != null){
                    try {
                        baos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else{
            throw new Exception("该文件类型,不支持" + urlConnection.getContentType());
        }


        return baos.toByteArray();
    }

    public static boolean download( DownloadBytesBean downloadBytesBean, DownLoadUI ui) throws Exception {

        URLConnection urlConnection = openConnection(downloadBytesBean.getUrlStr());
        InputStream is = null;
        if(urlConnection == null){
            return  false;
        }else{
            urlConnection.setRequestProperty("Range","bytes="+ downloadBytesBean.getBeginIndex()+"-" + (downloadBytesBean.getEndIndex() -1));
            if(urlConnection.getContentLength() <= 0){
                return  false;
            }
        }

        File f = FilePathUtil.createNewFile(downloadBytesBean.getSaveFilePath());
        RandomAccessFile raf = new RandomAccessFile(f,"rw");
        raf.seek(downloadBytesBean.getBeginIndex() + downloadBytesBean.getAmount());

        Vector<String> vector = new Vector<String>();
        vector.add("application/octet-stream");
        vector.add("application/zip");
        vector.add("binary/octet-stream");



        if(true){
            //支持直接读写的方式,其它压缩处理的文件,需要相应的解压处理,不然,下载后用不了

            byte[] buffer = new byte[1024];
            try {
                is = urlConnection.getInputStream();
                int len = 0 ;
                while ((len = is.read(buffer)) != -1){
                    while (globalIsSuspend){
                        System.out.println(Thread.currentThread().getName() + "暂停");
                        Thread.sleep(1000);

                    }

                    while (globalIsStop){
                        System.out.println(Thread.currentThread().getName() +"停止");
                        return false;
                    }

                    raf.write(buffer,0,len);
                    //记录当前累记的下载量
                    downloadBytesBean.setAmount(downloadBytesBean.getAmount() + len);
                    ui.setProgressBarCurrentValue(len);


                }


            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(raf != null){
                    try {
                        raf.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if(is != null){
                    is.close();
                }
            }
        }else{
            throw new Exception("该文件类型,不支持" + urlConnection.getContentType());
        }


        return true;
    }

    public static boolean downloadBreakpoint(String url,String saveFilePath, DownloadBytesBean downloadBytesBean, DownLoadUI ui) throws Exception {

        if(downloadBytesBean != null && downloadBytesBean.getRangList() != null && downloadBytesBean.getRangList().size() > 0){
            List<Integer[]> rang = downloadBytesBean.getRangList();
            for (Integer[] array : rang){


                URLConnection urlConnection = openConnection(url);
                InputStream is = null;
                if(urlConnection == null){
                    return  false;
                }else{
                    urlConnection.setRequestProperty("Range","bytes="+ array[0]+"-" + (array[1] -1));
                    if(urlConnection.getContentLength() <= 0){
                        return  false;
                    }
                }


                File f = FilePathUtil.createNewFile(saveFilePath);
                RandomAccessFile raf = new RandomAccessFile(f,"rw");
                raf.seek(array[0] + downloadBytesBean.getAmount());

                Vector<String> vector = new Vector<String>();
                vector.add("application/octet-stream");
                vector.add("application/zip");
                vector.add("binary/octet-stream");

                if(true){
                    //支持直接读写的方式,其它压缩处理的文件,需要相应的解压处理,不然,下载后用不了

                    byte[] buffer = new byte[1024];
                    try {
                        is = urlConnection.getInputStream();
                        int len = 0 ;
                        while ((len = is.read(buffer)) != -1){
                            while (globalIsSuspend){
                                System.out.println(Thread.currentThread().getName() + "暂停");
                                Thread.sleep(1000);

                            }

                            while (globalIsStop){
                                System.out.println(Thread.currentThread().getName() +"停止");
                                return false;
                            }

                            raf.write(buffer,0,len);
                            //记录当前累记的下载量
                            downloadBytesBean.setAmount(downloadBytesBean.getAmount() + len);
                            ui.setProgressBarCurrentValue(len);


                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if(raf != null){
                            try {
                                raf.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        if(is != null){
                            is.close();
                        }
                    }
                }else{
                    throw new Exception("该文件类型,不支持" + urlConnection.getContentType());
                }





            }


        }










        return true;
    }

}
