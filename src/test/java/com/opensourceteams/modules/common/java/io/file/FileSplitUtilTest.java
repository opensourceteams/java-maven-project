package com.opensourceteams.modules.common.java.io.file;

import com.opensourceteams.modules.common.gramar.二进制.十进制轩二进制表示.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/15  上午11:58
 * 功能描述:
 */

public class FileSplitUtilTest {

    /**
     * 文件分隔
     * @throws IOException
     */
    @org.junit.Test
    public void testFileSplit() throws IOException {
        FileSplitUtil.fileSplit("a.txt",3);
    }

    /**
     * 文件合成 一个字符一个字节合成
     * @throws IOException
     */
    @org.junit.Test
    public void testFileCompose() throws IOException {

        List<String> list = new ArrayList<String>();
        list.add("a.txt__0__data");
        list.add("a.txt__1__data");
        list.add("a.txt__2__data");

        String composefilePath = "a.compose.txt";
        FileOutputStream fos = new FileOutputStream(composefilePath);


        for (String s : list){

            FileInputStream fis = new FileInputStream(s);
            int len = 0 ;
            while ((len = fis.read()) != -1){
               // System.out.println((char)len);
                fos.write(len);
            }

        }

    }


    /**
     * 文件合成 字节数组合成
     * @throws IOException
     */
    @org.junit.Test
    public void testFileComposeByteArray() throws IOException {

        List<String> list = new ArrayList<String>();
        list.add("a.txt__0__data");
        list.add("a.txt__1__data");
        list.add("a.txt__2__data");

        String composefilePath = "a.compose.txt";
        FileSplitUtil.fileCompose(list,composefilePath);



    }
}
