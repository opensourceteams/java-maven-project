package com.opensourceteams.modules.common.gramar.多线程.案例分析.案例买票二6;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/4  下午2:32
 * 功能描述:同步方法
 */

class TicketPool{

    private int tickets = 10000000;

    public synchronized  int getTicket(){
        if (tickets <=0 ){
            return 0;
        }
        int tmp = tickets ;
        tickets = tickets - 1;
        return tmp;
    }
}

class Saler extends Thread{

    private String name;

    private TicketPool ticketPool;

    public Saler(String name,TicketPool ticketPool){
        this.name = name;
        this.ticketPool = ticketPool;
    }


    @Override
    public void run() {

         while (true){
             int no = ticketPool.getTicket();
             if(no != 0){
                 System.out.println(name +":" + no);
             }else {
                 return;
             }
             yield();
         }


    }
}

public class Run {

    public static void main(String[] args) {
       TicketPool pool = new TicketPool();



        for(int i =0 ;i< 100;i++){
            new Saler("n" +i ,pool).start();
        }
    }
}
