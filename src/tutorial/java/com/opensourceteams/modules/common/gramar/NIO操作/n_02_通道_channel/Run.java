package com.opensourceteams.modules.common.gramar.NIO操作.n_02_通道_channel;

import com.opensourceteams.modules.common.java.timer.TimerUtil;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 日期: 2016-03-29  18:06
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Run {


    /**
     * 文件管道读,写
     */
    @Test
    public void testFileChannelReadWirte(){
        try {
            FileInputStream fis = new FileInputStream("a.txt");
            FileChannel srcChannel  = fis.getChannel();


            RandomAccessFile raf = new RandomAccessFile("a_2.txt","rw");
            FileChannel destChannel = raf.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(5);

            while (srcChannel.read(buf) != -1){
                //buf.flip();
 /*               limit = position;
                position = 0;
                mark = -1;*/


                buf.limit(buf.position()) ;
                buf.position(0);
                destChannel.write(buf);

                buf.position(0);

            }
            srcChannel.close();
            destChannel.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 文件管道读,写
     */
    @Test
    public void testFileChannelReadWirteCopyFile(){
        long start = 0;

        String srcFilePath = "/opt/temp/download/Win10_1511_Chinese(Simplified)_x64.iso";
        String fileName = "";
        String fileNamePrefix = "";
        String fileNameLast = "";
        int capacity = 0 ;

        for (int i = 1; i <= 20 ; i++){
            capacity = i * 1024 ;
            start = System.currentTimeMillis();
            fileNamePrefix = srcFilePath.substring(0,srcFilePath.lastIndexOf("."));
            fileNameLast = srcFilePath.substring(srcFilePath.lastIndexOf("."));
            fileName = fileNamePrefix +"_"+ i+"_" + (capacity / 1024 /1024 )+"(MB)"+"_" + (capacity / 1024 /1024/1024 )+"(KB)" + fileNameLast;

            copyFileChannelDirect(srcFilePath,fileName,capacity);
            TimerUtil.printlnWorkerTimeMillis(start,fileName);
        }




    }

    public boolean copyFileChannel(String srcFilePath,String descFilePath,int capacity){
        FileChannel srcChannel = null;
        FileChannel destChannel = null;
        try {
            FileInputStream fis = new FileInputStream(srcFilePath);
            srcChannel  = fis.getChannel();


            RandomAccessFile raf = new RandomAccessFile(descFilePath,"rw");
            destChannel = raf.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(capacity);

            while (srcChannel.read(buf) != -1){


                buf.limit(buf.position()) ;
                buf.position(0);
                destChannel.write(buf);

                buf.position(0);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                srcChannel.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                destChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return true;

    }

    public boolean copyFileChannelDirect(String srcFilePath,String descFilePath,int capacity){
        FileChannel srcChannel = null;
        FileChannel destChannel = null;
        try {
            FileInputStream fis = new FileInputStream(srcFilePath);
            srcChannel  = fis.getChannel();


            RandomAccessFile raf = new RandomAccessFile(descFilePath,"rw");
            destChannel = raf.getChannel();

            ByteBuffer buf = ByteBuffer.allocateDirect(capacity);

            while (srcChannel.read(buf) != -1){



                buf.limit(buf.position()) ;
                buf.position(0);
                destChannel.write(buf);

                buf.position(0);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                srcChannel.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                destChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return true;

    }
}
