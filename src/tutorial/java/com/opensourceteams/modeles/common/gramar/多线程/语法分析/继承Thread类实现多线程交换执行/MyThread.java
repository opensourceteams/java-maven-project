package com.opensourceteams.modeles.common.gramar.多线程.语法分析.继承Thread类实现多线程交换执行;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/6  上午8:40
 * 功能描述: yield 继承Thread类实现多线程交换执行
 * 结果  死循环,方便看效果
 */

public class MyThread {


    public static void main(String[] args) {
        for (int i =0 ;i < 100 ;i ++){
            new RunThread().start();
        }

        System.out.println("结束:" + Thread.currentThread().getName());

    }
}


class RunThread  extends  Thread{

    @Override
    public void run() {

        while (true){
            System.out.println(Thread.currentThread().getName() );
            /**
             * 放弃,谦虚
             * 让线程放弃当前cpu的抢占权,
             * 但是放弃后,还会继续抢
             */
            yield();
            try {
                /**
                 * 让当前线程休眠,单位毫秒
                 */
                Thread.sleep(500l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
