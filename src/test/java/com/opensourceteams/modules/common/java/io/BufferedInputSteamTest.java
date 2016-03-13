package com.opensourceteams.modules.common.java.io;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/13  上午10:54
 * 功能描述:
 */

public class BufferedInputSteamTest {

    @Test
    public void testRead() throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] buffer = new byte[1024] ;

        int length = 0 ;
        while ((length = bis.read(buffer)) != -1){
            System.out.println(new String(buffer,0,length));
        }
    }
}
