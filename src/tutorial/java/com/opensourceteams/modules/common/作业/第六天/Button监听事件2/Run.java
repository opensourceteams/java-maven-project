package com.opensourceteams.modules.common.作业.第六天.Button监听事件2;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/1  上午11:52
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {

        Button button = new Button();


        CustomButtonClickListener customButtonClickListener = new CustomButtonClickListener();


        CustomButtonDBClickListener customButtonDBClickListener = new CustomButtonDBClickListener();

        button.addListener(customButtonClickListener);

        button.addListener(customButtonDBClickListener);

        button.click();

        button.dbclick();


    }
}
