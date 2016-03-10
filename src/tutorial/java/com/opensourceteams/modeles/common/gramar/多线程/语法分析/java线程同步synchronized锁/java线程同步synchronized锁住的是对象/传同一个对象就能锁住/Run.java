package com.opensourceteams.modeles.common.gramar.多线程.语法分析.java线程同步synchronized锁.java线程同步synchronized锁住的是对象.传同一个对象就能锁住;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/5  上午5:42
 * 功能描述: 锁住的Sync类的实例对象,而每次在MyThread中调用,传的是同一个Sync实例对象,所以可以锁住
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
    private Sync sync;
    public MyThread(Sync sync){
        this.sync = sync;
    };

    public void run() {
        sync.test();
    }
}

/**
 * 运行结果

 test开始..
 test结束..
 test开始..
 test结束..
 test开始..
 test结束..

 */
public class Run {

    public static void main(String[] args) {

        Sync sync = new Sync();
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread(sync);
            thread.start();
        }
    }
}
