package com.opensourceteams.modules.common.gramar.多线程.案例分析.案例四人打牌;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/6  上午8:44
 * 功能描述:继承Thread接口方式实现多线程
 * 等待所有线程都执行完了,再继续执行主线程
 */

class Run   {
    public static void main(String[] args) throws InterruptedException {


        Player play1 = new Player("牌友1",1);

        Player play2 = new Player("牌友2",2);

        Player play3 = new Player("牌友3",3);
        Player play4 = new Player("牌友4",4);

        play1.start();
        play2.start();
        play3.start();
        play4.start();


        play1.join();
        play2.join();
        play3.join();
        play4.join();

        System.out.println("开始打牌了");
    }

}

class Player extends   Thread{

    private String name;
    private int seconds;
    public Player(){}
    public Player(String name,int seconds){
        this.name = name;
        this.seconds = seconds;
    }




    public void run() {
        System.out.println(Thread.currentThread().getName() + "name:" + name +" 出发了");
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "name:" + name +" 到了,执行了" + seconds);
    }
}
