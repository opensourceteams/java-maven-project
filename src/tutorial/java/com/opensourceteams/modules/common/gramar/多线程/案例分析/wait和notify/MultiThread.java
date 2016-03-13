package com.opensourceteams.modules.common.gramar.多线程.案例分析.wait和notify;

import java.util.ArrayList;
import java.util.List;
/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/5  上午7:01
 * 功能描述:
 */

class Consume implements Runnable{
    private List container = null;
    private int count;
    public Consume(List lst){
        this.container = lst;
    }
    public void run() {

        while(true){
            synchronized (container) {
                if(container.size()== 0){
                    try {
                        container.wait();//容器为空，放弃锁，等待生产
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                container.remove(0);
                container.notify();
                System.out.println("我吃了"+(++count)+"个");
            }
        }

    }

}


 class Product implements Runnable {
    private List container = null;
    private int count;
    public Product(List lst) {
        this.container = lst;
    }

    public void run() {
        while (true) {
            synchronized (container) {
                if (container.size() > MultiThread.MAX) {
                    //如果容器超过了最大值，就不要在生产了，等待消费
                    try {
                        container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                container.add(new Object());
                container.notify();
                System.out.println("我生产了"+(++count)+"个");
            }
        }

    }

}



public class MultiThread {
    private List container = new ArrayList();
    public final static int MAX = 5;

    public static void main(String args[]) {

        MultiThread m = new MultiThread();

        new Thread(new Consume(m.getContainer())).start();
        new Thread(new Product(m.getContainer())).start();
        new Thread(new Consume(m.getContainer())).start();
        new Thread(new Product(m.getContainer())).start();
    }

    public List getContainer() {
        return container;
    }

    public void setContainer(List container) {
        this.container = container;
    }
}