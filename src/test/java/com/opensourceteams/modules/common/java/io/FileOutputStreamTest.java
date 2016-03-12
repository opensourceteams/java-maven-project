package com.opensourceteams.modules.common.java.io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/12  下午8:25
 * 功能描述:
 */

public class FileOutputStreamTest {

    @Test
    public void a() throws IOException {

        String path = "a.txt" ;
        FileOutputStream fos = new FileOutputStream(path);
        byte[] array = new byte[1024];
        array[0] = 'a';
        array[1] = 'b';
        fos.write(array,0,4);
        fos.write(20013);

        fos.close();

        System.out.println((int)'中');
    }
}
