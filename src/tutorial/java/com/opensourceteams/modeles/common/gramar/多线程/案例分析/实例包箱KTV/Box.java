package com.opensourceteams.modeles.common.gramar.多线程.案例分析.实例包箱KTV;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/6  上午8:44
 * 功能描述:继承Thread接口方式实现多线程
 * 后台线程,要等待其它的线程都执行完成了,自己才结束掉
 */

class Waitter   {
    public static void main(String[] args) throws InterruptedException {


        Box play1 = new Box("成龙",1);

        Box play2 = new Box("李连杰",2);

        Box play3 = new Box("子dan",3);
        Waiter watting = new Waiter();
        watting.setDaemon(true);


        play2.start();
        play3.start();
        watting.start();

        
        play2.join();
        play1.start();
        play1.join();
        play3.join();


        System.out.println(".....");
    }

}

class Waiter extends  Thread{
    @Override
    public void run() {
        int i = 0;
        while(true){
/*            try {
               Thread.sleep(1l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println("服务员报时" + (++i));
        }
    }
}
class Box extends   Thread{

    private String name;
    private int seconds;
    public Box(){}
    public Box(String name, int seconds){
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
