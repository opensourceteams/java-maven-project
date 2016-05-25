package com.opensourceteams.modules.common.gramar.文件IO操作.写文件操作;

import com.opensourceteams.modules.common.java.io.file.FileUtil;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/10  下午9:18
 * 功能描述:
 */

public class WriteFileBigData {


    @Test
    public void writeFile() throws IOException {
        List<String> list = new ArrayList<String>();
        String destPath = "a.txt";
        list.add("中国人民中国人民中国人民中国人民中国人民中国人民中国人民中国人民\n");
        FileUtil.writeFile(destPath,list);

    }
    @Test
    public void testWriteFileAppend() throws IOException {
        List<String> list = new ArrayList<String>();
        String destPath = "a.txt";
        list.add("中国人民中国人民中国人民中国人民中国人民中国人民中国人民中国人民\n");
        FileUtil.writeFileAppend(destPath,list);

    }

    @Test
    public void testWriteFileAppendList() throws IOException {
        Random random = new Random();

        List<String> list = new ArrayList<String>();
        int length = 10000;
        String destPath = "customer_" + length + "_w.txt";
        for (int i = 1 ;i <= 10000 * length ;i++){
            list.add(i + "," + "小明" +i +"," + random.nextInt(1000000) +"\n");
        }

        FileUtil.writeFileAppend(destPath,list);

    }
}
