package com.opensourceteams.modules.common.作业.第九天.生产者和消费者3;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/6  上午11:58
 * 功能描述: 蜜蜂
 */

public class Bee extends  Thread {

    private String name;
    public Bee(Pool pool, String name){
        this.pool = pool;
        this.name = name;
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
                    pool.notify();

                    pool.wait();

                    return;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

            Pool.total ++;
            System.out.println(name + " 本次生产蜂密一斤,已经生产多少斤:" + Pool.total);


        }

        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }



}
