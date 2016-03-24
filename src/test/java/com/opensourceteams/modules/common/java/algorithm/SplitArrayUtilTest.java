package com.opensourceteams.modules.common.java.algorithm;

import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;
import com.opensourceteams.modules.common.java.util.net.URLUtil;
import org.junit.Test;

import java.net.URLConnection;
import java.util.List;
import java.util.Vector;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  下午8:02
 * 功能描述:
 */

public class SplitArrayUtilTest {

    @Test
    public void testSplitArray(){
        byte[] bytes = new byte[1024];
        for (int i =  0 ;i< bytes.length;i++){
            bytes[i]= 10;
        }

        List<byte[]> list = SplitArrayUtil.splitArray(bytes,500, (byte) 1);
        for (byte[] sub : list){
            for (byte b : sub){
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println("==========第二种遍历方式");
        for (int i = 0 ;i < list.size();i++){
            byte[] sub = list.get(i);
            for (int j = 0 ;j <sub.length;j++){
                if(j ==0){
                    byte[] values = SplitArrayUtil.getSplitValue(sub[j]);
                    System.out.print("类型:" +values[0]);
                    System.out.print("当前包数:" + values[1]);
                }else if ( j == 1){
                    System.out.println("总共包数:" +sub[j]);
                }else{
                    System.out.print(sub[j] +"\t");
                }
            }
            System.out.println();
        }
    }

    /**
     * 分隔bytes 数据
     */
    @Test
    public void testSplitBytesToVector(){
         String urlStr = "http://100.68.68.101/apache.mirrors.lucidnetworks.net/tomcat/tomcat-9/v9.0.0.M4/bin/apache-tomcat-9.0.0.M4.zip";

        URLConnection conn = URLUtil.openConnection(urlStr);
        int length = URLUtil.getContentLength(conn);
        Vector<DownloadBytesBean> vector =  SplitArrayUtil.splitBytesToVector(length,100 ,"","");

        System.out.println("原有长度:"+length);

        int cal = 0 ;
        for (int i = 0 ;i < vector.size();i ++){
            DownloadBytesBean d = vector.get(i);
            System.out.println(i + " "+d.getBeginIndex()+":" + d.getEndIndex()+":"  + d.getLength());
            cal = cal + d.getLength();
        }
        System.out.println("计算完成后的总长度:" + cal);
    }
}
