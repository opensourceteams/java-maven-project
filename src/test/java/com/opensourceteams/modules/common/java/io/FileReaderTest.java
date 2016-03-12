package com.opensourceteams.modules.common.java.io;

import com.opensourceteams.modules.common.java.timer.TimerUtil;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/11  下午3:51
 * 功能描述:
 */

public class FileReaderTest {

    /**
     * 一个字符一个字符的读取
     * @throws IOException
     */
    @Test
    public void testRead() throws IOException {
        long start = System.currentTimeMillis();
        String  path = "a.txt";



        FileReader fr = new FileReader(path);

        int value = 0;
        while ((value = fr.read()) !=-1){
            System.out.print((char)value);
        }

        fr.close();
        TimerUtil.printWorkerTimeMillis(start);

    }


    /**
     * 带缓冲区的读取
     * @throws IOException
     */
    @Test
    public void testReadBuffer() throws IOException {
        long start = System.currentTimeMillis();
        String  path = "a.txt";



        FileReader fr = new FileReader(path);
        char[] buffer = new char[1024] ;

        int length = 0;
        while ((length = fr.read(buffer)) !=-1){
            System.out.println(new String(buffer,0,length));
        }

        fr.close();
        TimerUtil.printWorkerTimeMillis(start);

    }

    /**
     * 带缓冲区的读取,字符 的中文乱码问题
     * ).FileReader read 字符数组的没有传字符集的方法
     * ).FileReader read 字节数组可以传字符集,可以指定编码
     * @throws IOException
     */
    @Test
    public void testReadBuffer_GBK() throws IOException {
        long start = System.currentTimeMillis();
        String  path = "src/test/resources/file/gbk_file.txt";


        InputStreamReader isr = new InputStreamReader(new FileInputStream(path), "GBK");
        //FileReader fr = new FileReader(path);
        char[] buffer = new char[1024] ;

        int length = 0;
        while ((length = isr.read(buffer)) !=-1){
            System.out.println(new String(buffer,0,length));
        }
        isr.close();
        TimerUtil.printWorkerTimeMillis(start);

    }

    //直接用 FileReader 不好处理中文乱码问题
    @Test
    public void testReadBuffer_GBK2() throws IOException {
        long start = System.currentTimeMillis();
        String  path = "src/test/resources/file/gbk_file.txt";



        //InputStreamReader isr = new InputStreamReader(new FileInputStream(path), "GBK");
        FileReader fr = new FileReader(path);

        System.out.println(fr.getEncoding());
        char[] buffer = new char[1024] ;

        int length = 0;


        while ((length = fr.read(buffer,0,10)) !=-1){
            System.out.println(new String(buffer,0,length));
        }
        fr.close();
        TimerUtil.printWorkerTimeMillis(start);

    }

    private byte[] getBytes (char[] chars) {
        Charset cs = Charset.forName ("GBK");
        CharBuffer cb = CharBuffer.allocate (chars.length);
        cb.put (chars);
        cb.flip ();
        ByteBuffer bb = cs.encode (cb);

        return bb.array();

    }

    @Test
    public void testReadBigFile() throws IOException {
        long start = System.currentTimeMillis();
        String path = "/opt/workspace/temp/bigtxt4.write.txt"; //1.6g  执行时间83797 8642  9860

        path = "a.txt";

        FileReader fr = new FileReader(path);
        char[] buffer = new char[1024] ;

        int length = 0;
        while ((length = fr.read(buffer)) !=-1){
            //System.out.println(new String(buffer,0,length));
        }

        fr.close();
        TimerUtil.printWorkerTimeMillis(start);

    }


}
