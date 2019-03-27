package com.opensourceteams.modules.java.util.video;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class VideoUtilTest {

    @Test
    public void getDuration() throws IOException {
        String path = "/Users/liuwen/Downloads/temp/语音测试文件/xiaoshizi.mp3" ;
      /*  String path = "/Users/liuwen/Downloads/temp/语音测试文件/xiaoshizi.mp4" ;
        String path = "/Users/liuwen/Downloads/temp/语音测试文件/xiaoshizi.wav" ;
        String path = "/Users/liuwen/Downloads/temp/语音测试文件/xiaoshizi.mov" ;
        String path = "/Users/liuwen/Downloads/temp/语音测试文件/xiaoshizi.m4a" ;*/

        long result = VideoUtil.getDuration(path);
        System.out.println(result);
    }

}