package com.opensourceteams.modules.common.java.util.properties;

import com.opensourceteams.modules.common.java.io.file.FilePathUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


/**
 * 日期: 2016-03-24  20:48
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class PropertiesUtil {


    /**
     * 属性文件 key 得到 value
     * @param filePath
     * @param key
     * @return
     */
    public static String getValueByKey(String filePath,String key){
        Properties p = new Properties();
        FileInputStream fileInputStream = null;
        try {
             fileInputStream = new FileInputStream(filePath);
             p.load(fileInputStream);
             return p.getProperty(key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 得到属性文件
     * @param filePath
     * @return
     */
    public static Properties getProperties(String filePath){
        Properties p = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            p.load(fileInputStream);
            return p;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Properties write(String filePath,Object key,Object value){
        Properties p = new Properties();
        p.put(key,value);
        try {
            p.store(new FileOutputStream(filePath),"这是一个什么样的说明文件");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }

    public static Properties write(String filePath,Properties properties){
        try {
            properties.store(new FileOutputStream(filePath),"这是一个什么样的说明文件");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static Properties writeAppen(String filePath,Object key,Object value){
        Properties p  = PropertiesUtil.getProperties(filePath);
        p.put(key,value);
        try {
            p.store(new FileOutputStream(filePath),"这是一个什么样的说明文件");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }

    public static Properties writeAppen(String filePath,Properties properties){
        Properties p  = PropertiesUtil.getProperties(filePath);
        p.putAll(properties);
        try {
            p.store(new FileOutputStream(filePath),"这是一个什么样的说明文件");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }


    /**
     * 得到属性文件
     * @param filePath
     * @return
     */
    public static Properties removeKey(String filePath,Object key){
        if(!FilePathUtil.exist(filePath)){
            return null;
        }
        Properties p = new Properties();
        FileInputStream fileInputStream = null;
        try {

            fileInputStream = new FileInputStream(filePath);
            System.out.println("removeKey filePath:"+filePath);
            p.load(fileInputStream);
            p.remove(key);
            p.store(new FileOutputStream(filePath),"属性文件更新描述信息");
            return p;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 过滤属性值
     * @param filePath
     * @param prefix
     * @return
     */
    public static Map<String,String> getPropertiesPrefix(String filePath,String prefix){
        Map<String,String> map = new HashMap<String, String>();
        Properties p = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            p.load(fileInputStream);

            Iterator it = p.keySet().iterator();


            if(it.hasNext()){
                Object obj = it.next();
                if(obj != null && obj.toString().contains(prefix)){
                    map.put(obj.toString(),p.getProperty(obj.toString()));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map<String,String> getPropertiesPrefix(Properties p,String prefix){
        Map<String,String> map = new HashMap<String, String>();

            Iterator it = p.keySet().iterator();


            while (it.hasNext()){
                Object obj = it.next();
                if(obj != null && obj.toString().contains(prefix)){
                    map.put(obj.toString(),p.getProperty(obj.toString()));
                }
            }
        return map;
    }
}
