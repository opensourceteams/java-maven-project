package com.opensourceteams.modeles.common.作业.第九天.生产者和消费者3;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/6  上午11:59
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {
        Pool pool = new Pool();

        for(int i = 0 ;i < 3 ;i++){

            Bee bee = new Bee(pool,"蜜峰" + (i+1));
            bee.start();
        }







        Bear bear = new Bear(pool,"熊1");
        bear.start();

        Bear bear2 = new Bear(pool,"熊2");
        bear2.start();


    }
}
