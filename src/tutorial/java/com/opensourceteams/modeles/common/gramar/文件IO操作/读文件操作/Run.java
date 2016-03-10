package com.opensourceteams.modeles.common.gramar.文件IO操作.读文件操作;

import java.io.FileReader;
import java.io.IOException;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/10  下午9:03
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {


        System.out.println(getFileContent("a.txt"));
        System.out.println(getFileContent("/opt/workspace/bigdata/all_frame_intellij/java-maven/b.txt"));
    }


    public static String getFileContent(String path){
        try {
            StringBuffer str = new StringBuffer();
            char[] buf = new char[2];
            FileReader f = new FileReader(path);
            while(f.read(buf)>0){
                str.append(buf);
            }
            return str.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
