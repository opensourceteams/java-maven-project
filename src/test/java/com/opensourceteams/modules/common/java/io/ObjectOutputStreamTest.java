package com.opensourceteams.modules.common.java.io;

import org.junit.Test;

import java.io.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/14  下午4:45
 * 功能描述:
 */

public class ObjectOutputStreamTest {


    /**
     * 字节流输出,,将对象存储到二进制中
     */
    byte[] array = null;
    @Test
    public void testWriteObject1() throws IOException {
        //ByteArrayInputStream bai = new ByteArrayInputStream();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //FileOutputStream fos = new FileOutputStream("object.txt");
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("中国人民"));
        array = bos.toByteArray();
        oos.close();
        bos.close();
    }

    /**
     * 字节数组的读取
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void testReadObject2() throws IOException, ClassNotFoundException {
        testWriteObject1();
        ByteArrayInputStream bis = new ByteArrayInputStream(array);

        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = ois.readObject();
        System.out.println((String)obj);
        ois.close();
        bis.close();
    }

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
