package com.opensourceteams.modules.common.java.io;

import org.junit.Test;

import java.io.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/13  下午3:34
 * 功能描述:
 */

public class OutputStreamWriterTest {


    /**
     * 写字符串
     * @throws IOException
     */
    @Test
    public void testWriteString() throws IOException {

        FileOutputStream fos = new FileOutputStream("subRecursionListFiles.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write("你好");
        osw.close();

    }

    /**
     * 先读后写
     * @throws IOException
     */
    @Test
    public void testWriteCharArry() throws IOException {

        FileInputStream fis = new FileInputStream("a.txt");
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");

        int len = 0;
        char[] arr = new char[1024];

        FileOutputStream fos = new FileOutputStream("subRecursionListFiles.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        while ( (len = isr.read(arr) )!= -1){
            osw.write(arr,0,len);
            System.out.println(new String(arr,0,len));
        }


        osw.close();
        fos.close();
        isr.close();
        fis.close();




    }
}
