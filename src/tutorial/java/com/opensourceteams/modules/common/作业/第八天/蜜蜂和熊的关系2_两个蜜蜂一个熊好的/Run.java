package com.opensourceteams.modules.common.作业.第八天.蜜蜂和熊的关系2_两个蜜蜂一个熊好的;

class BeeSugarPool{


    Object increaseWait = new Object();
    Object subtractWait = new Object();

    public static int beeSuger = 0 ;

    public static int currentBeeSuger = 0;

    public static int onceIncrease = 5;

    /**
     * 生产蜂密
     * @return
     * @throws InterruptedException
     */
    public void increase(String name) throws InterruptedException {


        synchronized (BeeSugarPool.class){
            currentBeeSuger++;
            if(currentBeeSuger > Run.MAX){
                //BeeSugarPool.class.notifyAll();
                BeeSugarPool.class.wait();
                //return 1 ;
            }
        }

        try {
            System.out.println(name + " 多生产一斤蜂密生产的过程中... 一共有:" + beeSuger + " 当前有:" +currentBeeSuger);
            Thread.sleep(1000l);
        }catch (Exception e){
            currentBeeSuger--;
        }






        synchronized (BeeSugarPool.class){
            beeSuger++;
            System.out.println(name + " 完成,完成的:" + beeSuger + " 当前有:" +currentBeeSuger);
            if(beeSuger >= Run.MAX){
                BeeSugarPool.class.notifyAll();
            }
        }


    }

    public void subtract(String name) throws InterruptedException {

        synchronized (BeeSugarPool.class){
            if(beeSuger >= Run.MAX){
                currentBeeSuger = currentBeeSuger - onceIncrease ;
            }else{
                BeeSugarPool.class.wait();
                //return -1;
            }
        }

        try {
            System.out.println(name + " 熊在消费的过程中... 已完成:" + beeSuger + " 当前有:" +currentBeeSuger);
            Thread.sleep(1000l);
        }catch (Exception e){
            currentBeeSuger--;
        }






        synchronized (BeeSugarPool.class){
            beeSuger = beeSuger - onceIncrease ;
            currentBeeSuger = currentBeeSuger - onceIncrease ;
            System.out.println(name + " 完成,一共有" + beeSuger+ " 当前有:" +currentBeeSuger);
            BeeSugarPool.class.notifyAll();
            //BeeSugarPool.class.wait();

        }

    }

    /**
     * 得到当前的蜂密
     * @return
     */
    public int getBeeSuger(){
        return  beeSuger;
    };

}

/**
 * 蜜蜂
 */
class Bee extends Thread{
    private String name;
    private BeeSugarPool beeSugarPool;
    public Bee(BeeSugarPool beeSugarPool, String name){
        this.beeSugarPool = beeSugarPool;
        this.name = name;

    };

    @Override
    public void run() {
        while (true){
            try {
                beeSugarPool.increase(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}

/**
 * 熊
 */
class Bear extends Thread{

    private String name;
    private BeeSugarPool beeSugarPool;
    public Bear(BeeSugarPool beeSugarPool, String name){
        this.beeSugarPool = beeSugarPool;
        this.name = name;

    };

    @Override
    public void run() {
        while (true){
            try {
                beeSugarPool.subtract(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/5  上午5:03
 * 功能描述:
 */
public class Run {

    public static final int MAX = 5 ;

    public static void main(String[] args) {


        new Bee(new BeeSugarPool(),"蜜蜂1").start();
        new Bee(new BeeSugarPool(),"蜜蜂2").start();
        new Bear(new BeeSugarPool(),"熊1").start();
        //new Bear(new BeeSugarPool(),"熊2").start();



    }
}
