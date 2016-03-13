package com.opensourceteams.modules.common.gramar.多线程.案例分析.案例买票二3;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/4  下午2:32
 * 功能描述: 死循环,一直在卖,对同一个
 */

class Saler extends Thread{

    private String name;
    private static int tickets = 100 ;

    private static Object obj = new Object();

    public Saler(String name){
        this.name = name;
    }


    @Override
    public void run() {
        synchronized (obj){   //同步代码块
            while (tickets > 0){


                    try {
                        Thread.sleep(100l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int tmp = tickets;
                    tickets = tmp - 1 ;
                    System.out.println(name + " : " + tmp);



                yield();
            } //end while

        }  //end synchronized
    }
}

public class Run {

    public static void main(String[] args) {
        Saler s1 = new Saler("Marry");

        Saler s2 = new Saler("He");
        s1.start();
        s2.start();
    }
}
