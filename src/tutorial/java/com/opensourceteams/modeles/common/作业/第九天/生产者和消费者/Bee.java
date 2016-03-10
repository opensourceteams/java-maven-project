package com.opensourceteams.modeles.common.作业.第九天.生产者和消费者;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/6  上午11:58
 * 功能描述: 蜜蜂
 */

public class Bee extends  Thread {

    public Bee(Pool pool){
        this.pool = pool;
    }

    Pool pool ;
    @Override
    public void run() {

        while (true){
            product();
        }

    }


    /**
     * 生产峰密的方法
     */
    public void  product()  {

        synchronized (pool){
            if(Pool.total >= 5){
                try {
                    //Pool.class.wait();
                    System.out.println("峰");
                    pool.wait();
                    System.out.println("峰2");
                    pool.notify();
                    //return;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

            Pool.total ++;
            System.out.println("本次生产蜂密一斤,已经生产多少斤:" + Pool.total);


        }

        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }



}
