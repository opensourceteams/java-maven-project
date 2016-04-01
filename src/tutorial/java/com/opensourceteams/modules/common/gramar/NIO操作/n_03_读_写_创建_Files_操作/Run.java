package com.opensourceteams.modules.common.gramar.NIO操作.n_03_读_写_创建_Files_操作;

import io.netty.buffer.ByteBuf;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

/**
 * 日期: 2016-03-30  10:36
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Run {

    /**
     * 读到的数据放在堆当中
     * ).Files.readAllBytes
     */
    @Test
    public void testRead(){
        Path file = Paths.get("/opt/temp/CentOS-7-x86_64-Minimal-1503-01.iso");
        try {
            byte[] bytes = Files.readAllBytes(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 读文件,按行读取
     * ).指定编码
     * ).按行读取
     * ).Files.newBufferedReader
     */
    @Test
    public void testReadFileLine(){
        Path file = Paths.get("/opt/temp/data/text/a.txt");
        Charset charset = Charset.forName("UTF-8");
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = Files.newBufferedReader(file,charset);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 写文件
     * ).指定编码
     * ).Files.newBufferedWriter
     */
    @Test
    public void testWriteFileLine(){
        Path file = Paths.get("/opt/temp/data/text/a4.txt");
        Charset charset = Charset.forName("UTF-8");
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = Files.newBufferedWriter(file,charset);
            bufferedWriter.write("你好,中国");
            bufferedWriter.newLine();
            bufferedWriter.write("你好,中国");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取文件   包装类
     * ).BufferedReader
     * ).按行读取
     */
    @Test
    public void testInputStream(){
        Path path = Paths.get("/opt/temp/data/text/a4.txt");
        InputStream inputStream = null;
        try {
            inputStream = Files.newInputStream(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        try {
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写文件
     * ).bufferedOutputStream.write
     */
    @Test
    public void testWriteStream(){
        Path path = Paths.get("/opt/temp/data/text/a5.txt");
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedOutputStream.write("你好中国".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读时多了两个字节
     * todo SeekableByteChannel 读时多了两个字节
     */
    @Test
    public  void testSeekableByteChannelRead(){
        Path path = Paths.get("a.txt");
        try {
            SeekableByteChannel seekableByteChannel = Files.newByteChannel(path);
            ByteBuffer buf = ByteBuffer.allocate(5);
            System.out.println(System.getProperty("file.encoding"));
            int len = 0 ;
            while ((len = seekableByteChannel.read(buf)) > 0){
                buf.rewind();
                System.out.print(Charset.forName(System.getProperty("file.encoding")).decode(buf));
                buf.flip();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 读时多了两个字节
     * todo SeekableByteChannel 读时多了两个字节
     */
    @Test
    public  void testSeekableByteChannelRead3(){
        Path path = Paths.get("a.txt");
        try {
            SeekableByteChannel seekableByteChannel = Files.newByteChannel(path);
            ByteBuffer buf = ByteBuffer.allocate(50);
            System.out.println(System.getProperty("file.encoding"));
            int len = 0 ;
            while ((len = seekableByteChannel.read(buf)) > 0){
                buf.rewind();
                if(buf.hasRemaining()){
                    System.out.print((char) buf.getChar());

                }

                buf.flip();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * SeekableByteChannel read 读文件
     */
    @Test
    public  void testSeekableByteChannelRead2(){
        Path path = Paths.get("a.txt");
        try {
            SeekableByteChannel seekableByteChannel = Files.newByteChannel(path);
            ByteBuffer buf = ByteBuffer.allocate(5);
            System.out.println(System.getProperty("file.encoding"));
            int len = 0 ;
            int limit = 0 ;
            while ((len = seekableByteChannel.read(buf)) > 0){
                limit = buf.limit();
                //buf.rewind();
                buf.position(0);
                System.out.println(new String(buf.array(),0,len,"UTF-8"));
                buf.limit(limit);
                buf.position(0);
                //buf.flip();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 创建文件,指定文件权限
     */
    @Test
    public void  TestLogFilePermissions(){
        // Create the set of options for appending to the file.
        Set<OpenOption> options = new HashSet<OpenOption>();
        options.add(APPEND);
        options.add(CREATE);

        // Create the custom permissions attribute.
        Set<PosixFilePermission> perms =
                PosixFilePermissions.fromString("rw-r-----");
        FileAttribute<Set<PosixFilePermission>> attr =
                PosixFilePermissions.asFileAttribute(perms);


        // Convert the string to a ByteBuffer.
        String s = "Hello World! 中国";
        byte data[] = s.getBytes();
        ByteBuffer bb = ByteBuffer.wrap(data);

        Path file = Paths.get("permissions.log");

        try (SeekableByteChannel sbc =
                     Files.newByteChannel(file, options, attr)) {
            sbc.write(bb);
        } catch (IOException x) {
            System.out.println("Exception thrown: " + x);
        }



    }



}
