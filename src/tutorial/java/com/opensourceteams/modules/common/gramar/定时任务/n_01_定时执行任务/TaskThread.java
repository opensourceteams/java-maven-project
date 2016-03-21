package com.opensourceteams.modules.common.gramar.定时任务.n_01_定时执行任务;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  下午2:12
 * 功能描述:
 */

public class TaskThread extends Thread {


    long timeInterval = 1000;

    public TaskThread (){
    };

    public TaskThread (long timeInterval){
        this.timeInterval = timeInterval;
    };


    @Override
    public void run() {
        while (true){

            System.out.println("这是定时执行的任务");
            try {
                Thread.sleep(timeInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
