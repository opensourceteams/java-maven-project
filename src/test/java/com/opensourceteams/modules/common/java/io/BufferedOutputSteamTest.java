package com.opensourceteams.modules.common.java.io;

import org.junit.Test;

import java.io.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/13  上午10:54
 * 功能描述:
 */

public class BufferedOutputSteamTest {

    @Test
    public void testRead() throws IOException {
        FileOutputStream fos = new FileOutputStream("a.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] buffer = new byte[1024] ;
        buffer[0] = 'a' ;
        bos.write(buffer);
        bos.close();
        fos.close();

    }
}
