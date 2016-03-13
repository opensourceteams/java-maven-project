package com.opensourceteams.modules.common.gramar.多线程.语法分析;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/6  上午8:34
 * 功能描述:
 */

public class SleepThread {
    public static void main(String[] args) {
        new MyLogin().run();
        for (int i = 0 ; i< 1000 ; i++){
            System.out.println(Thread.currentThread().getName() +  " main:" + i);
        }
    }
}

class MyLogin implements  Runnable{
    public void run() {
        try {

            for (int i = 0 ; i< 1000 ; i++){
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() +  " new:" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
