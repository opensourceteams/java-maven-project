package com.opensourceteams.modules.common.gramar.多线程.语法分析.java线程同步synchronized锁.java线程同步synchronized锁住的是对象.传不同的对象就锁不住;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/5  上午5:42
 * 功能描述: 锁住的Sync类的实例对象,而每次在MyThread中调用,都是new Sync() 是不同的实例对象,所以锁不住
 */

class Sync{

    public synchronized void test() {
        System.out.println("test开始..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test结束..");
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
