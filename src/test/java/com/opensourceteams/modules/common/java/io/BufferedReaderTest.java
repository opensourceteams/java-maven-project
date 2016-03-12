package com.opensourceteams.modules.common.java.io;

import com.opensourceteams.modules.common.java.timer.TimerUtil;
import org.junit.Test;

import java.io.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/11  下午3:08
 * 功能描述:
 */

public class BufferedReaderTest {



    /**
     * 功能测试,按字符读取缓冲区数据
     * 操作说明:
     * ).先去文件中读取 默认的字符缓冲大小为8k的字符数据,放到缓冲区defaultCharBufferSize
     * ).再一个一个字符从缓冲区读取数据
     * @throws IOException
     */
    @Test
    public void testRead() throws IOException {
        String path = "/opt/workspace/temp/data/22.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        int result = 0;
        while ((result = br.read()) != -1){
            System.out.print((char)result);
        }
        br.close();
    }


    /**
     * 功能测试,,按行读取数据
     * ).先去文件中读取 默认的字符缓冲大小为8k的字符数据,放到缓冲区defaultCharBufferSize
     * ).再一个一个字符从缓冲区中去遍历,直到找到 换行和回车符,才把该行内容返回
     * @throws IOException
     */
    @Test
    public void testReadLine() throws IOException {
        String path = "/opt/workspace/temp/data/22.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String result = null;
        StringBuffer sb = new StringBuffer();
        while ((result = br.readLine()) != null){
            //System.out.println(result);
            sb.append(result);
        }
        br.close();
    }

    /**
     * 解决GBK存储的中文乱码问题
     * 功能测试,,按行读取数据
     * ).先去文件中读取 默认的字符缓冲大小为8k的字符数据,放到缓冲区defaultCharBufferSize
     * ).再一个一个字符从缓冲区中去遍历,直到找到 换行和回车符,才把该行内容返回
     * @throws IOException
     */
    @Test
    public void testReadLine_GBK() throws IOException {
        String path = "src/test/resources/file/gbk_file.txt";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path), "GBK");
        BufferedReader br = new BufferedReader(isr);
        String result = null;
        StringBuffer sb = new StringBuffer();
        while ((result = br.readLine()) != null){
            //System.out.println(result);
            sb.append(result);
        }
        br.close();
        System.out.printf(sb.toString());
    }

    @Test
    public void testReadLineBigFile() throws IOException {
        long start = System.currentTimeMillis();
        String path = "/opt/workspace/temp/bigtxt4.write.txt"; //1.6g  执行时间83797
        BufferedReader br = new BufferedReader(new FileReader(path),1);
        String result = null;
        while ((result = br.readLine()) != null){
            //System.out.println(result);
        }
        br.close();

        TimerUtil.printWorkerTimeMillis(start);
    }


    /**
     * 得到文件的行号,读取文件行的内容
     * @throws IOException
     */
    @Test
    public void testGetLineNumber() throws IOException {
        String path = "a.txt";
        LineNumberReader l = new LineNumberReader(new FileReader(path));
        String result = null;
        while ((result = l.readLine()) != null){
            System.out.println("行号:"+ l.getLineNumber() + " --> " +result);

        }
        l.close();
    }

    /**
     * 只设置行号,不能改变指针
     * @throws IOException
     */
    @Test
    public void testSetLineNumber2() throws IOException {
        String path = "a.txt";
        LineNumberReader l = new LineNumberReader(new FileReader(path));
        String result = null;
        l.setLineNumber(6);
        result =l.readLine();
        System.out.println("行号:"+ l.getLineNumber() + " --> " +result );
        l.close();
    }
}
