package com.opensourceteams.modules.common.作业.第八天.汽车过山洞2;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/5  上午4:23
 * 功能描述:
 * 题目:5辆汽车过山洞，依次经过山洞。每辆车通过山洞花费10秒，使用多线程实现
 */


/**
 * 山洞类,山油里有车道可以过车,有且仅有一辆车同时通过
 */
class Cave {

    private Cave(){};

    private static Cave cave = null;


    /**
     * 山洞只能有一个,所有,有且只能实例化一次
     * @return
     */
    public synchronized static Cave getInstance(){
        if(cave == null){
            return new Cave();
        }
        return cave;
    };

    /**
     * 车道通车,加上同频
     * @param carName
     * @throws InterruptedException
     */
    public synchronized void lane(String carName) throws InterruptedException {
        System.out.println(carName + "  正在过车道...\n");
        printSeconds(10);
        System.out.println(carName + "  已过完车道.");
        System.out.println("\n");
    }


    /**
     * 打印时间的功能方法
     * @param seconds
     * @throws InterruptedException
     */
    public void printSeconds(int seconds) throws InterruptedException {
        int remainTime = seconds ;
        long time = 1000l;
        while (remainTime-- >0){
            Thread.sleep(time);
            System.out.println("经过了" +  (seconds - remainTime ) +" 秒,还剩多少秒" + remainTime );
        }

    }
}

/**
 * 汽车,汽车有过山洞车道的功能
 */
class Car extends Thread{

    private Cave cave;

    public String name;


    /**
     * 构造函数中必须有Cave,以保证操作同一山洞对象,用于锁对象进行同步
     * @param name
     * @param cave
     */
    public Car(String name,Cave cave){
        this.name = name;
        this.cave = cave;
    }

    @Override
    public void run() {
        try {
            cave.lane(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Run{

    public static void main(String[] args) {

        Cave cave = Cave.getInstance();

        for(int i = 0;i<5;i++){
            new Car("宝马" + i,cave).start();
        }

    }
}


