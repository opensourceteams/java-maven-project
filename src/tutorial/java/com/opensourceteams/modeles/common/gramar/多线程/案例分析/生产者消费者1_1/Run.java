package com.opensourceteams.modeles.common.gramar.多线程.案例分析.生产者消费者1_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/4  下午4:24
 * 功能描述:
 */


class Producer extends Thread{

    final static int MAX = 3;


    List<Integer> list ;

    public  Producer(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run() {
        int i = 0 ;
        while (true){
            synchronized (list){

                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int size = list.size();
                if(size >= MAX ){
                    try{
                        list.wait();
                    }catch (Exception e){

                    }

                }else{
                    list.add(new Integer(i++));
                    System.out.println("p 第:" + i + "次,元素的个数:" + list.size());
                    list.notify();
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
                try {
                    Thread.sleep(10000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(list.size() == 0){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    Integer i = list.remove(0);
                    System.out.println("元素的个数:" + list.size());
                    list.notify();
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



    }
}
