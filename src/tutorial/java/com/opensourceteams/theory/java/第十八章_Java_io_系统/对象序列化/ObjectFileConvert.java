package com.opensourceteams.theory.java.第十八章_Java_io_系统.对象序列化;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/1/22  上午10:01
 * 功能描述: java 序列化操作
 */

public class ObjectFileConvert {

    /**
     * 文件转化为Object
     * @param fileName
     * @return byte[]
     */
    public static Object fileToObject(String fileName) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            Object object = ois.readObject();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 把Object输出到文件
     * @param obj
     * @param outputFile
     */
    public static void objectToFile(Object obj, String outputFile) {
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(outputFile));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /**
     * @param args
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        /**
         * 对象保存到文件
         */
        String fileName = "src/tutorial/resources/output/object.obj";
        List<String> list = new ArrayList<String>();
        list.add("元素一");
        list.add("元素二");

        ObjectFileConvert.objectToFile(list, fileName);
        //System.out.println("success fileCompose List<String> to file.");

        List<String> tmpList = (List<String>) ObjectFileConvert
                .fileToObject(fileName);
        for (String tmp : tmpList) {
            System.out.println(tmp);
        }

        System.out.println("--------------------------------");

        /**
         * 文件转化为对象
         */
        fileName = "src/tutorial/resources/output/uservo.obj";
        UserVo vo = new UserVo("00001", "用户一", 18, new Date());

        ObjectFileConvert.objectToFile(vo, fileName);

        UserVo tmpvo = (UserVo) ObjectFileConvert.fileToObject(fileName);
        System.out.println("对象信息: " + tmpvo);

    }
}
