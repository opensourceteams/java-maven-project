package com.opensourceteams.modules.common.java.io;

import org.junit.Test;

import java.io.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/14  下午4:45
 * 功能描述:
 */

public class ObjectInputStreamTest {

    @Test
    public void testWriteObject() throws IOException {
        FileOutputStream fos = new FileOutputStream("object.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(new String("中国人民"));
        oos.close();
        fos.close();
    }

    @Test
    public void testReadObject() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("object.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        System.out.println((String)obj);
        ois.close();
        fis.close();
    }
}
