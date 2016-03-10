package com.opensourceteams.modeles.common.gramar.多线程.语法分析.非线程安全;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/2  上午5:52
 * 功能描述:验证ArrayList 是非线程安全的,
 * 一共跑了10次,
 * 每一次10个线程,
 * 每个线程放100个ArrayList元素
 * 一共是10000个元素
 */

class MyThread implements Runnable {


    private List<Object> list;

    private CountDownLatch countDownLatch;

    public MyThread(List<Object> list, CountDownLatch countDownLatch)
    {
        this.list = list;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
       // System.out.println(Thread.currentThread().getName());
        // 每个线程向List中添加100个元素
        for(int i = 0; i < 100; i++)
        {
            list.add(new Object());
        }

        try
        {
            // 主线程等待所有子线程执行完成，再向下执行
            countDownLatch.await();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

       // System.out.println("完成"+Thread.currentThread().getName());
    }
}

class Run{

    public static void main(String[] args) throws InterruptedException {
        // 进行10次测试
        for(int i = 0; i < 10; i++)
        {
            test();
        }

    }

    public static void test() throws InterruptedException {
        // 用来测试的List
        List<Object> list = new ArrayList<Object>();

        // 线程数量(1000)
        int threadCount = 10;
        // 用来让主线程等待threadCount个子线程执行完毕
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        // 启动threadCount个子线程
        for(int i = 0; i < threadCount; i++)
        {
            Thread thread = new Thread(new MyThread(list,countDownLatch));
            thread.start();
        }





        System.out.println("记录数:"+list.size()); //记录总数据数
    }

}
