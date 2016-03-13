package com.opensourceteams.modules.common.java.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/13  上午11:14
 * 功能描述:
 */

public class LineNumberReaderTest {


    @Test
    public void testGetLineNumber() throws IOException {
        FileReader fr = new FileReader("a.txt");
        LineNumberReader lnr = new LineNumberReader(fr);
        String str = "";
        if((str = lnr.readLine()) != null){
            System.out.println("行号:"+lnr.getLineNumber() + "内容:" +str);
        }
    }
}
