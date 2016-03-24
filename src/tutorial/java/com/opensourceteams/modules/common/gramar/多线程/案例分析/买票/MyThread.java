package com.opensourceteams.modules.common.gramar.多线程.案例分析.买票;

public class MyThread   {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }

}

class MyRunnable implements  Runnable{
    private int ticket = 100;
    public void run() {
        for(int i=0; i<5;i++){
            synchronized(this) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " TicketID : " + ticket--);
                if(4 == i){
                    break;
                }
            }
        }
    }
}
