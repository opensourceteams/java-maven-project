package com.opensourceteams.modules.common.gramar.设计模式.单例设计模式;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/17  上午11:13
 * 功能描述: 设计模式 ---->单例模式(懒汉式)
 */

public class SingletonModel {

    /**
     * 实例对象
     */
    private static SingletonModel instance;

    /**
     * 私有,不让外部直接实例化
     */
    private SingletonModel(){}

    /**
     * 得到类实例
     * @return
     */
    public static synchronized SingletonModel getInstance(){
        if(instance == null){
            instance = new SingletonModel();
        }
        return instance;
    }
}
