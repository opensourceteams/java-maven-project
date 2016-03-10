package com.opensourceteams.modeles.common.gramar.网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Scanner;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/6  上午9:49
 * 功能描述:网络编程
 */

public class JavaNet {
    public static void main(String[] args) throws IOException {
        InetAddress local = null ;
        InetAddress remote = null;

        local = InetAddress.getLocalHost();
        remote = InetAddress.getByName("http://spark.apache.org");

        System.out.println(local);
        System.out.println(remote);

        URL url = new URL("http://spark.apache.org");
        InputStream inputStream = url.openStream();

        Scanner scaner = new Scanner(inputStream);
        scaner.useDelimiter("\n");
        while (scaner.hasNext()){
            System.out.println(scaner.next());
        }
        System.out.println(url.getContent());

        URL url2 = new URL("https://wwww.baidu.com");
        URLConnection urlConnection = url2.openConnection();
        System.out.println("length " + urlConnection.getContentLength());
        System.out.println("contextType " + urlConnection.getContentType());
    }
}
