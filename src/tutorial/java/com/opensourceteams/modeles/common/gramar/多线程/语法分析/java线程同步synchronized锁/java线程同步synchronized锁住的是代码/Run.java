package com.opensourceteams.modeles.common.gramar.多线程.语法分析.java线程同步synchronized锁.java线程同步synchronized锁住的是代码;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/5  上午5:42
 * 功能描述:锁住的是代码,可以传不同对象,同一段代码,只能同时只有一段程序执行
 */

class Sync{

    public  void test() {
        synchronized(Sync.class){
            System.out.println("test开始..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test结束..");
        }

    }
}

class MyThread extends Thread {

    public void run() {
        Sync sync = new Sync();
        sync.test();
    }
}

/**
 * 运行结果

 test开始..
 test开始..
 test开始..
 test结束..
 test结束..
 test结束..

 */
public class Run {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread();
            thread.start();
        }
    }
}
