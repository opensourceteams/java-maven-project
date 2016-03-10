package com.opensourceteams.modeles.common.作业.第九天.生产者和消费者;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/6  上午11:59
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {

/*        Bee bee = new Bee();

        for(int i = 0 ;i < 100 ;i++){
            bee.product();
        }*/


        Pool pool = new Pool();
        Bee bee = new Bee(pool);
        bee.start();

        Bear bear = new Bear(pool);
        bear.start();


    }
}
