package com.opensourceteams.modules.common.gramar.多线程.案例分析.死锁notifyAll;

import java.util.ArrayList;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/4  下午4:24
 * 功能描述:
 */

class Producer extends Thread{

    final static int MAX = 1;


    List<Integer> list ;

    public  Producer(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run() {
        int i = 0 ;
        while (true){
            synchronized (list){
                int size = list.size();
                if(size >= MAX ){
                    try{
                        list.wait();
                    }catch (Exception e){

                    }

                }else{
                    list.add(new Integer(i++));
                    System.out.println("p:" + i);
                    list.notifyAll();
                }
            }




            yield();
        }
    }
}


class Customer extends Thread{

    List<Integer> list ;

    public  Customer(List<Integer> list ){

        this.list = list;
    }

    @Override
    public void run() {

        while (true){
            synchronized (list){
                if(list.size() == 0){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    Integer i = list.remove(0);
                    System.out.println("c:" + i);
                    list.notifyAll();
                }

            }


            yield();
        }
    }
}

public class Run {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        new Producer(list).start();
        new Customer(list).start();
        new Customer(list).start();

    }
}
