package com.opensourceteams.modules.common.作业.第七天.用接口作内部类;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/1  上午11:49
 * 功能描述:
 */

public class Button {

    IButtonListener iButtonListener   = null;

    public void addListener(IButtonListener buttonListener){
        iButtonListener = buttonListener;

    }


    public void click(){
        iButtonListener.click();
    }

    public void dbclick(){
        iButtonListener.dbclick();
    }





}
