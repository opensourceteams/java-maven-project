package com.opensourceteams.modules.common.java.io;

import com.opensourceteams.modules.common.java.io.file.FileSplitUtil;
import org.junit.Test;

import java.io.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/14  下午2:14
 * 功能描述:
 */

public class RandomAccessFileTest {

    @Test
    public void testRead() throws IOException {

        RandomAccessFile raf = new RandomAccessFile("a.txt","rw");
        //System.out.println(raf.getFilePointer());
       // System.out.println(raf.readLine());
       // System.out.println(raf.readUTF());
        byte[] buffer = new byte[1024];
        int len = 0 ;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = raf.read(buffer)) != -1){
            bos.write(buffer,0,len);
        }

        System.out.println(new String(bos.toByteArray()));

        bos.close();
        raf.close();

    }

    /**
     * 文件分隔
     * @throws IOException
     */
    @Test
    public void testFileSplit() throws IOException {

        String filePath = "a.txt" ;
        int splitPartCount = 4 ;
        FileSplitUtil.fileSplit(filePath,splitPartCount);

    }


    /**
     * 文件合成
     * @throws IOException
     */
    @Test
    public void testFileCompose() throws IOException {



        String[] filePaths =  {"a.txt__0__data","a.txt__1__data","a.txt__2__data"};

        for(String filePath : filePaths){


        }



    }




}
