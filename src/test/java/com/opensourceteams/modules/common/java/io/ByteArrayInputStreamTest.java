package com.opensourceteams.modules.common.java.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/13  上午11:39
 * 功能描述:
 */

public class ByteArrayInputStreamTest {

    @Test
    public void testRead() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(100);
        baos.write(128);
        baos.write(300);
        baos.write(400);

        byte[] bytes = baos.toByteArray();
        baos.close();



        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        int i = 0 ;
        while ((i = bais.read()) != -1){
            System.out.println(i);
        }

    }
}
