package com.opensourceteams.modeles.common.作业.第九天.生产者和消费者3;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/6  下午12:27
 * 功能描述: 消费者
 */


public class Bear extends  Thread{

    Pool pool;
    private String name;
    public Bear(Pool pool,String name){
        this.pool = pool;
        this.name = name;
    }

    @Override
    public void run() {

        while (true){
            synchronized (pool){



                if(Pool.total >= 5){
                    Pool.total = Pool.total - 5 ;
                    System.out.println(name + "熊吃了5斤,还剩下多少斤:" +  Pool.total);
                    pool.notifyAll();

                    try {
                        pool.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                Thread.sleep(2000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }
    }
}
