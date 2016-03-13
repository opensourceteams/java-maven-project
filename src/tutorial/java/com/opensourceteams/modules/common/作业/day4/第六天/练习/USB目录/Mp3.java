package com.opensourceteams.modules.common.作业.day4.第六天.练习.USB目录;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/1  下午1:38
 * 功能描述:
 */

public class Mp3 implements  IUSB {

    public void work(){
        System.out.println("MP3 ");
    }

    public static void main(String[] args) {
        Mp3 mp3 = new Mp3();

        mp3.work();
    }
}
