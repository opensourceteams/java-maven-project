package com.opensourceteams.modeles.common.作业.第六天.Button监听事件2;

import java.util.ArrayList;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/1  上午11:49
 * 功能描述:
 */

public class Button {

    List<ButtonListener> listenerList   = new ArrayList();

    public void addListener(ButtonListener buttonListener){
        listenerList.add(buttonListener);
/*        if(buttonListener instanceof CustomButtonClickListener){
            buttonListener.click();
        }else if(buttonListener instanceof CustomButtonDBClickListener){
            buttonListener.dbclick();
        }*/

    }


    public void click(){
        dealButtonClickEvent();
    }

    public void dbclick(){
        dealDBButtonClickEvent();
    }


    public void dealEvent(){
        for(ButtonListener v : listenerList){
            if(v instanceof  CustomButtonClickListener){
                v.click();
            }else if(v instanceof  CustomButtonDBClickListener){
                v.dbclick();
            }
        }
    }

    public void dealButtonClickEvent(){
        for(ButtonListener v : listenerList){
            if(v instanceof  CustomButtonClickListener){
                v.click();
            }
        }
    }

    public void dealDBButtonClickEvent(){
        for(ButtonListener v : listenerList){
            if(v instanceof  CustomButtonDBClickListener){
                v.dbclick();
            }
        }
    }



}
