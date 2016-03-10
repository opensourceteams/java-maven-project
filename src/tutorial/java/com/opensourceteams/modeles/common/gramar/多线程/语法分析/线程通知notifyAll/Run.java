package com.opensourceteams.modeles.common.gramar.多线程.语法分析.线程通知notifyAll;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/5  上午11:10
 * 功能描述:
 */
class Cave{

}
class Car extends  Thread{
    Cave cave;
    String name;

    public Car(Cave cave,String name){
        this.cave = cave ;
        this.name = name;

    }

    @Override
    public void run() {
        synchronized (cave){
            System.out.println(name +":进洞了");
            try {
                cave.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name +":wait后代码");

        }
    }
}
public class Run {

    public static void main(String[] args) throws InterruptedException {
        Cave cave = new Cave();
        Car c1 = new Car(cave,"C1");
        Car c2 = new Car(cave,"C2");

        c1.start();
        c2.start();

        Thread.sleep(5000);
        synchronized (cave){
            cave.notifyAll();
        }

    }
}
