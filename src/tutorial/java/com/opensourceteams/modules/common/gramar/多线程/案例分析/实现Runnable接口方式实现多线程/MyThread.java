package com.opensourceteams.modules.common.gramar.多线程.案例分析.实现Runnable接口方式实现多线程;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/6  上午8:44
 * 功能描述:实现Runnable接口方式实现多线程
 */

public class MyThread   {
    public static void main(String[] args) {
        for (int i =0 ;i < 10 ;i ++){

            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }

}

class MyRunnable implements  Runnable{
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
