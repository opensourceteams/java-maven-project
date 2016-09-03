package com.opensourceteams.modules.common.gramar.逻辑控制.n_01_循环;

/**
 * 日期: 2016-09-03  11:58
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class Run2 {

    public static void main(String[] args) {
        for (int i = 1 ;i <= 10 ;i ++){
            if( i == 5) continue;
            System.out.println("这是第 " + i  + " 次打印输出");
        }
    }

}
