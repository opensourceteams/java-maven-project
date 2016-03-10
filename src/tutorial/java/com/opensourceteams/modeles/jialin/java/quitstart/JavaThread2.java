package com.opensourceteams.modeles.jialin.java.quitstart;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/6  上午8:10
 * 功能描述:
 */

public class JavaThread2  {


    public static void main(String[] args) {
        new NewThread().run();
        for (int i = 0 ; i< 5000 ; i++){
            System.out.println(Thread.currentThread().getName() +  "main:" + i);
        }
    }
}

class NewThread implements Runnable {
    public void run() {
        for (int i = 0 ; i< 5000 ; i++){
            System.out.println(Thread.currentThread().getName() +  "new :" + i);
        }
    }
}
