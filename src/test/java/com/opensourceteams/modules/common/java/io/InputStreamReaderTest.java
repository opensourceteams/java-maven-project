package com.opensourceteams.modules.common.java.io;

import org.junit.Test;

import java.io.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/13  下午3:27
 * 功能描述:
 */

public class InputStreamReaderTest {


    /**
     * 读,支持字符集指定
     * @throws IOException
     */
    @Test
    public void testRead() throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");

        int len = 0;
        char[] arr = new char[1024];
        while ( (len = isr.read(arr) )!= -1){
            System.out.println(new String(arr,0,len));
        }

    }
}
