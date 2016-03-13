package com.opensourceteams.modules.common.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/13  下午4:36
 * 功能描述:
 */

public class SystemTestMain {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = "";
        while ((line = br.readLine()) != null){
            if("exit".equals(line)){
                System.exit(-1);
            }
            System.out.println("输入的内容:" + line);
        }
        br.close();
    }
}
