package com.opensourceteams.modules.common.java.io;

import com.opensourceteams.modules.common.java.array.ArrayUtil;
import com.opensourceteams.modules.common.java.io.file.FileUtil;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/11  上午11:10
 * 功能描述:
 */

public class BufferedWriterTest {


    /**
     * 往文件中写入字符串,覆盖原有文件数据
     * ).BufferedWriter.fileCompose 方法,把字符串写入默认为8k的缓冲区
     * ).缓冲区中的数据,待close 或 flushBuffer 才把数据写到文件中去
     * @throws IOException
     */
    @Test
    public void testWrite() throws IOException {
        String path = "a.txt";
        BufferedWriter buffer =  new BufferedWriter(new FileWriter(path));
        buffer.write("中国a");
        buffer.write("中国b");
        buffer.close();

    }

    /**
     * 往文件中写入字符数组,覆盖原有文件数据
     * ).BufferedWriter.fileCompose 方法,把字符串写入默认为8k的缓冲区
     * ).缓冲区中的数据,待close 或 flushBuffer 才把数据写到文件中去
     * @throws IOException
     */
    @Test
    public void testWriteBuffer() throws IOException {
        char[] buffer = new char[1024];
        buffer[0] = '中';
        buffer[1] = '国';
        buffer[2] = '人';
        buffer[3] = 'a';
        String path = "a.txt";
        BufferedWriter bw =  new BufferedWriter(new FileWriter(path));
        bw.write(buffer,0,4);
        bw.close();

    }

    /**
     * 往文件中写数据
     * @throws IOException
     */
    @Test
    public void testPrintWriter() throws IOException {
        String path = "a.txt";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path)));
        out.println("你好");
        out.println("小明");
        out.close();
    }

    /**
     1457668215399
     1457668229032
     执行时间:13633
             11282
               1351
     * @throws Exception
     */
    @Test
    public void testFileCopy() throws Exception {
        long start = System.currentTimeMillis();
        System.out.println(start);

        String srcPath = "/opt/workspace/temp/bigtxt2.fileCompose.txt";
        String destPath="/opt/workspace/temp/bigtxt3.fileCompose.txt";

        FileUtil.fileCopy(srcPath,destPath);
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("执行时间:" + (end -start ));

    }

    public void testBigFileCopy() throws Exception {
        long start = System.currentTimeMillis();
        System.out.println(start);

        String srcPath = "/opt/workspace/temp/bigtxt.txt";
        String destPath="/opt/workspace/temp/bigtxt2.fileCompose.txt";
        for(int i =0;i< 100 ;i++){
            FileUtil.fileCopyAppend(srcPath,destPath);
        }

        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("执行时间:" + (end -start ));

    }



    /**
     * 1457668567811
     1457668568174
     执行时间:363
     * @throws IOException
     */
    @Test
    public void testWriter1() throws IOException {

        long start = System.currentTimeMillis();
        System.out.println(start);

        char[] charArry = new char[1024];
        String destPath="/opt/workspace/temp/bigtxt6.fileCompose.txt";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(destPath)));

        for(int i = 0 ;i< 1000000;i++){
            out.write("中国人民中国人民中国人民中国人民中国人民中国人民中国人民中国人民\n");

        }

        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("执行时间:" + (end -start ));

    }

    @Test
    public void testWriter2() throws IOException {

        long start = System.currentTimeMillis();
        System.out.println(start);

        String destPath="/opt/workspace/temp/bigtxt10.fileCompose.txt";


        String s = "中国人民中国人民中国人民中国人民中国人民中国人民中国人民中国人民\n";
        FileWriter writer = new FileWriter(destPath,false);
        for(int i = 0 ;i< 1000000;i++){
            writer.write(s);
        }

        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("执行时间:" + (end -start ));

        System.out.println("===========================");

         start = System.currentTimeMillis();
        System.out.println(start);

        char[] charArry = new char[1024];
        //String destPath2="/opt/workspace/temp/bigtxt6.fileCompose.txt";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(destPath)));

        for(int i = 0 ;i< 1000000;i++){
            out.write(s);

        }

         end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("执行时间:" + (end -start ));

    }



    /**
     * 1457668247213
     1457668258495
     执行时间:11282
     * @throws IOException
     */
    @Test
    public void testWriter() throws IOException {

        long start = System.currentTimeMillis();
        System.out.println(start);
        String srcPath = "/opt/workspace/temp/bigtxt2.fileCompose.txt";
        String destPath="/opt/workspace/temp/bigtxt4.fileCompose.txt";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(destPath)));


        FileReader fr = new FileReader(srcPath);
        int length = 1024; //定义缓冲区的大小
        char[] charArry = new char[length];
        int len =0 ;
        //StringBuffer sb = new StringBuffer();
        while ((len  = fr.read(charArry,0,length)) != -1) {
            //System.out.print(new String(charArry,0,len));

            out.write(charArry,0,len);
        }
        fr.close();

        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("执行时间:" + (end -start ));
        /**
         * 1457667680264
         1457667680489
         执行时间:225
         */
    }

}
