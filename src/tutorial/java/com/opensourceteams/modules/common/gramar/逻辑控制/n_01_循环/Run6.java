package com.opensourceteams.modules.common.gramar.逻辑控制.n_01_循环;

/**
 * 日期: 2016-09-03  11:58
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class Run6 {

    public static void main(String[] args) {
        int sum = 0 ;//定义变量,存储所有数的和
        for (int i = 1 ;i <= 100 ;i ++){
            if(i % 2 ==1){
                sum += i;
            }
        }
        System.out.println("结果:" + sum);
    }

}
