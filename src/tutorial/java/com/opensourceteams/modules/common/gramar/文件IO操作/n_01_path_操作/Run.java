package com.opensourceteams.modules.common.gramar.文件IO操作.n_01_path_操作;


import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 日期: 2016-03-30  09:25
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Run {

    /**
     * 路径
     */
    @Test
    public void testPath(){
        //直接写路径
        Path p1 = Paths.get("/tmp/foo");
        System.out.println(p1);


        /**
         * 定义一个URI的路径
         * ).本地文件系统
         * ).远程路径
         */
        Path p2 = Paths.get(URI.create("file:///opt/temp/data/text/shortText_8_byte.txt"));
        System.out.println(p2);

        //得到当前用户的目录  --> /Users/hadoop
        Path p4 = Paths.get(System.getProperty("user.home"));
        System.out.println(p4);
    }

    /*
        Retrieving Information abort a Path
     */
    @Test
    public void testRetrievingInfo() throws IOException {

        //文件
        Path path = Paths.get("/opt/temp/data/text/shortText_8_byte.txt");

        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());

        //目录

        System.out.println("目录\n");
        path = Paths.get("/opt/temp/data/text");

        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());


        //Removing Redundancies From a Path
        path = Paths.get("/opt/temp/./../");
        System.out.println(path.toString());
        System.out.println(path.toAbsolutePath());
        System.out.println(path.toRealPath());

        // Converting a Path    to URI
        Path p1 =  Paths.get("/opt/temp/data/text/shortText_8_byte.txt");
        System.out.format("%s%n",p1.toUri());



    }

    /**
     * Joing Two Paths
     */
    @Test
    public void testJoiningTwoPaths(){
        Path p1 = Paths.get("/opt/temp/data/");
        System.out.format("%s%n",p1.resolve("text/shortText_8_byte.txt"));
    }


    /**
     * Creating a Path Between Two Paths
     * --> )没理解
     */
    @Test
    public void testCreatingBetweenTwoPaths(){
        Path p1 = Paths.get("写文件操作");
        Path p2 = Paths.get("data");
        // Result is ../sally
        Path p1_to_p2 = p1.relativize(p2);
        // Result is ../joe
        Path p2_to_p1 = p2.relativize(p1);
        System.out.println(p1_to_p2);
        System.out.println(p2_to_p1);
    }

    @Test
    public  void testComparingTwoPaths(){


        Path path = Paths.get("/opt/temp/data/text/shortText_8_byte.txt");
        Path otherPath = Paths.get("/opt/temp/data/images/hadoop-logo-2.jpg");
        Path beginning = Paths.get("/opt/temp");
        Path ending = Paths.get("hadoop-logo-2.jpg");

        if (path.equals(otherPath)) {
            System.out.println("1");
        } else if (path.startsWith(beginning)) {
            System.out.println("2");
        } else if (path.endsWith(ending)) {

            System.out.println("3");
        }
    }



}
