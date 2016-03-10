package com.opensourceteams.modeles.common.gramar.多线程.案例分析.生产者和消费者;

import java.util.ArrayList;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/4  下午4:24
 * 功能描述:
 */
class Pool{
    private List<Integer> pool = new ArrayList<Integer>();

    public void add(int value){
        pool.add(new Integer(value));
    }

    public Integer cut(){
        if(pool.size() <=0 ){
            return 0;
        }
        return pool.remove(0);
    }
}

class Producer extends Thread{

    Pool pool;

    public  Producer(Pool pool){
        this.pool = pool;
    }

    @Override
    public void run() {
        int i = 1 ;
        while (true){
            pool.add(i);
            System.out.println(Thread.currentThread().getName() +" :" + (i++));
           try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            yield();
        }
    }
}


class Customer extends Thread{

    Pool pool;

    public  Customer(Pool pool){
        this.pool = pool;
    }

    @Override
    public void run() {
        int i = 1 ;
        while (true){
            pool.cut();
            System.out.println(Thread.currentThread().getName() + "消费者:" + (i++));
            try {
                Thread.sleep(2000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            yield();
        }
    }
}
public class Run {

    public static void main(String[] args) {

        Pool pool = new Pool();

        new Producer(pool).start();
        new Customer(pool).start();



    }
}
