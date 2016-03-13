package com.opensourceteams.modules.common.作业.第六天.Button监听事件2;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/1  上午11:49
 * 功能描述:
 */

public class CustomButtonDBClickListener extends ButtonDBClickListenerAdapter {


    @Override
    public void dbclick() {
        System.out.println("自定义双击事件");
    }
}
