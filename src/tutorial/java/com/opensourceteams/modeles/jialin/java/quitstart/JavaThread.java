package com.opensourceteams.modeles.jialin.java.quitstart;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/6  上午8:00
 * 功能描述: java 多线程
 */

public class JavaThread {
    public static void main(String[] args) {
        for (int i = 0 ; i< 1000 ; i++){
            System.out.println(Thread.currentThread().getName() + " main:" + i);
        }
        new HelloThread().start();

        /**
         * 第二种创建线程的方式
         */
        new Thread(new Runnable() {
            public void run() {
                System.out.println("第二种创建线程的方式");
                for (int i = 0 ; i< 1000 ; i++){
                    System.out.println(Thread.currentThread().getName() +  " new:" + i);
                }
            }
        }).start();
    }
}

class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0 ; i< 1000 ; i++){
            System.out.println(Thread.currentThread().getName() + " new 2:" + i);
        }
    }
}