package com.opensourceteams.modules.common.作业.第七天;

import java.util.ArrayList;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/1  上午11:49
 * 功能描述:
 */

public class Button {

    List<IButtonListener> listenerList   = new ArrayList();

    public void addListener(IButtonListener buttonListener){
        listenerList.add(buttonListener);
/*        if(buttonListener instanceof CustomButtonClickListener){
            buttonListener.click();
        }else if(buttonListener instanceof CustomButtonDBClickListener){
            buttonListener.dbclick();
        }*/

    }


    public void click(){
        dealEvent();
    }

    public void dbclick(){
        dealEvent();
    }


    public void dealEvent(){
        for(IButtonListener v : listenerList){
            if(v instanceof CustomButtonClickListener){
                v.click();
            }else if(v instanceof CustomButtonDBClickListener){
                v.dbclick();
            }
        }
    }

    public void dealButtonClickEvent(){
        for(IButtonListener v : listenerList){
            if(v instanceof CustomButtonClickListener){
                v.click();
            }
        }
    }

    public void dealDBButtonClickEvent(){
        for(IButtonListener v : listenerList){
            if(v instanceof CustomButtonDBClickListener){
                v.dbclick();
            }
        }
    }



}
