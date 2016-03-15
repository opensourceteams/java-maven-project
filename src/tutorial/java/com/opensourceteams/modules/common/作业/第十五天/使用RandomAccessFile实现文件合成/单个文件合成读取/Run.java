package com.opensourceteams.modules.common.作业.第十五天.使用RandomAccessFile实现文件合成.单个文件合成读取;

import com.opensourceteams.modules.common.java.binary.IntConvertEachBinary;

import java.io.*;
import java.util.Random;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/15  下午12:22
 * 功能描述:
 */

public class Run {

    public static String srcFile = "src/tutorial/resources/data/input/a.txt" ;
    public static String descFile = "src/tutorial/resources/data/input/a_compose.txt" ;

    public static void main(String[] args) throws IOException {

        //fileCompose();
        read();
    }

    public static void read() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(descFile,"r");
        raf.seek(0);

        int fileType = raf.read(); //读取到的当前文件类型

        byte[] byteArrayFileLength = new byte[4];

        byte[] buffer = new byte[1024];

        raf.read(byteArrayFileLength);  //读数据到缓冲区中

        int fileLength = IntConvertEachBinary.getIntByArray(byteArrayFileLength) ;//读取到的当前文件长度

        int len = 0 ;
        while (raf.getFilePointer() >= 1 + 4 + fileLength   ||  (len = raf.read(buffer))  != -1){
            System.out.print(new String(buffer,0,len));
            break;
        }
       // raf.seek();
        int a1= raf.read(buffer);
        int a2= raf.read();
    }

    public static void write() throws IOException {

        File file = new File(srcFile);

        FileInputStream fis = new FileInputStream(file);


        System.out.println(file.length());
        System.out.println((int)file.length());
        FileOutputStream fos = new FileOutputStream(descFile);
        int len = 0 ;
        fos.write((byte)0);//文本文件
        fos.write(IntConvertEachBinary.convertIntToByteArry((int)file.length()));



        while ((len = fis.read()) != -1){
            fos.write(len);
        }

        fis.close();
        fos.close();
    }
}
