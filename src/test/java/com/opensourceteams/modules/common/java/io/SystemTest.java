package com.opensourceteams.modules.common.java.io;

import org.junit.Test;

import java.io.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/13  下午4:23
 * 功能描述:
 */

public class SystemTest {


    @Test
    public void testPrint() throws FileNotFoundException {
        System.setOut(new PrintStream(new FileOutputStream("a.txt")));
        System.out.println("中国1");
    }



}
