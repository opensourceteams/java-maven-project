package com.opensourceteams.modules.common.gramar.集合.属性文件;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

/**
 * Created by hadoop on 16/3/23.
 */
public class Run {


    public static void main(String[] args) throws Exception {
        while (true){
            a();
            Thread.sleep(1000);
        }

        }




    public static  void a(){
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("/opt/workspace/bigdata/all_frame_intellij/java_maven/src/main/resources/a.properties"));


            Set<Object> set = p.keySet();
            Collection<Object> values = p.values();
            System.out.println(p.getProperty("a"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
