package com.opensourceteams.modules.common.gramar.NIO操作.n_04_MappedByteBuffer操作;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * 日期: 2016-03-31  10:47
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class A {

    public static void main(String[] args) {
        try {
            RandomAccessFile rdf = new RandomAccessFile("a.txt","r");
            FileChannel fcIn = rdf.getChannel();
            fcIn.map(FileChannel.MapMode.READ_ONLY,0,fcIn.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
