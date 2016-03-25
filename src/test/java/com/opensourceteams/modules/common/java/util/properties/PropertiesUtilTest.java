package com.opensourceteams.modules.common.java.util.properties;

import com.opensourceteams.modules.common.java.io.file.FilePathUtil;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Set;

import static com.opensourceteams.modules.common.java.util.properties.PropertiesUtil.getValueByKey;

/**
 * 日期: 2016-03-24  14:24
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class PropertiesUtilTest {


    String filePath = "/opt/temp/download/ubuntu-15.10-desktop-amd64.iso.tmp";


    /**
     * 测试,key 得到 value
     */
    @Test
    public void testGetValueByKey(){
        String value = PropertiesUtil.getValueByKey(filePath,"thread.count");
        System.out.println(value);
    }
    /**
     * 测试,filePath 得到 getProperties
     */
    @Test
    public void testGetProperties(){
        Properties properties = PropertiesUtil.getProperties(filePath);
        System.out.println(properties.get("thread.count"));
    }





    /**
     * 将数据写入属性文件,如果文件中已有数据,会全部覆盖原来的数据
     * @throws Exception
     */
    @Test
    public void testWrite() throws Exception {
        Properties p = new Properties();
        //p.load(new FileInputStream(FilePathUtil.createNewFile("b.tmp")));
       // p.setProperty("a","b1");
        p.setProperty("b","2");
        p.setProperty("c","3");

        p.store(new FileOutputStream(filePath),"这是一个什么样的说明文件");

    }

    /**
     * 读取属性文件的属性值
     * @throws Exception
     */
    @Test
    public void testRead() throws Exception {
        Properties p = new Properties();
        p.load(new FileInputStream(FilePathUtil.createNewFile(filePath)));
        String value = p.getProperty("b");
        System.out.println(value);
    }

    /**
     * 读取属性文件的属性值
     * @throws Exception
     */
    @Test
    public void testReadValues() throws Exception {
        Properties p = new Properties();
        p.load(new FileInputStream(FilePathUtil.createNewFile(filePath)));
        Set<Object> set = p.keySet();

        for (Object o : set){
            String value = p.getProperty(o.toString());
            System.out.println(value);
        }
    }
}
