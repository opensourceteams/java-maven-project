package com.opensourceteams.modules.common.java.io;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/11  下午1:17
 * 功能描述:
 */

public class FileWriterTest {


    /**
     * 字符串写入操作
     * @throws IOException
     */
    @Test
    public void testWrite() throws IOException {
        String path = "src/test/resources/file/writeData.txt";
        FileWriter fw = new FileWriter(path,false);
        for(int i = 0; i< 10 ;i++){
            fw.write("中国人 " +i);
            //fw.flush();
        }

        fw.close();
    }

    /**
     * 字符数组写入操作
     * @throws IOException
     */
    @Test
    public void testCharArray() throws IOException {

        char[] arry = new char[1024 * 10 ] ;
        arry[0] = '中';

        String path = "a.txt";
        FileWriter fw = new FileWriter(path,false);
        for(int i = 0; i< 10 ;i++){
            fw.write(arry);
            //fw.flush();
        }

        fw.close();
    }
}
