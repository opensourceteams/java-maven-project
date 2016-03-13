package com.opensourceteams.modules.common.java.io.file;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/13  下午5:07
 * 功能描述:
 */

public class FileTest {

    @Test
    public void testFile(){
        File f = new File("a.txt");
        System.out.println(f.getAbsoluteFile());
        System.out.println(f.getName());
        System.out.println(f.getParent());
        System.out.println(f.getParentFile());
        System.out.println(f.getFreeSpace());
        System.out.println(f.getTotalSpace());
        System.out.println(f.getTotalSpace() /1024 /1024/1024);
        System.out.println(f.getFreeSpace()/1024 /1024/1024);
    }



}
