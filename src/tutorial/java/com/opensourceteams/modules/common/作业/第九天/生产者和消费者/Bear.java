package com.opensourceteams.modules.common.作业.第九天.生产者和消费者;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/6  下午12:27
 * 功能描述: 消费者
 */


public class Bear extends  Thread{

    Pool pool;
    public Bear(Pool pool){
        this.pool = pool;
    }

    @Override
    public void run() {

        while (true){
            synchronized (pool){



                if(Pool.total >= 5){
                    Pool.total = Pool.total - 5 ;
                    System.out.println("熊吃了5斤,还剩下多少斤:" +  Pool.total);
                    pool.notifyAll();
                    try {
                        Thread.sleep(2000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println("熊");
                        pool.wait();
                        System.out.println("熊2");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }



        }
    }
}
