package com.opensourceteams.modules.common.作业.第六天.Button监听事件;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/1  上午11:49
 * 功能描述:
 */

public class Button {

    public void addListener(ButtonListener buttonListener){

        if(buttonListener instanceof  CustomButtonClickListener){
            buttonListener.click();
        }else if(buttonListener instanceof  CustomButtonDBClickListener){
            buttonListener.dbclick();
        }

    }


}
