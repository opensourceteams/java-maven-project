package com.opensourceteams.modules.common.gramar.多线程.语法分析.继承Thread类实现多线程;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/6  上午8:40
 * 功能描述: 继承Thread类实现多线程
 * 结果
 Thread-0
 Thread-2
 Thread-1
 Thread-3
 Thread-5
 Thread-4
 Thread-6
 Thread-7
 Thread-8
 Thread-9
 */

public class MyThread {


    public static void main(String[] args) {
        for (int i =0 ;i < 10 ;i ++){
            new RunThread().start();
        }

        System.out.println("结束:" + Thread.currentThread().getName());

    }
}


class RunThread  extends  Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() );
    }
}
