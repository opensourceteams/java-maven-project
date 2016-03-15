package com.opensourceteams.modules.common.java.io.file;

import java.io.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/14  下午5:02
 * 功能描述:
 */

public class ObjectSerializationUtil {


    /**
     * 对象序列化,将序列化后的字节数组保存到 byte[] 中返回
     * @param obj
     * @return
     * @throws IOException
     */
    public static byte[] objectSerialization(Object obj) throws IOException {
        byte[] array = null;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        array = bos.toByteArray();
        oos.close();
        bos.close();

        return array;
    }


    /**
     *
     * @param array
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object objectDeserialize(byte[] array) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(array);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = ois.readObject();
        ois.close();
        bis.close();
        return obj;
    }
}
