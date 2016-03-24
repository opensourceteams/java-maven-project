package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_7_多线程下载_增加停止按钮_状态显示label;

import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;
import com.opensourceteams.modules.common.java.util.net.URLUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Vector;

/**
 * Created by hadoop on 16/3/24.
 */
public class Download_URLUtil extends URLUtil {


    public static boolean globalIsSuspend = false;

    public static boolean globalIsStop = false;


    public static byte[] getBytesIsSuspend(String urlStr, DownloadBytesBean downloadBytesBean) throws Exception {

        URLConnection urlConnection = openConnection(urlStr);
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
        if(vector.contains(urlConnection.getContentType())){

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

}
