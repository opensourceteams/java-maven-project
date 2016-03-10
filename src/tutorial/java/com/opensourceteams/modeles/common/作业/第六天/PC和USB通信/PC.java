package com.opensourceteams.modeles.common.作业.第六天.PC和USB通信;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/1  上午10:34
 * 功能描述: 电脑类
 */

public class PC {

    /**
     * 通用的功能方法
     * @param usb
     */
    void common(IUSB usb){
        usb.work();
    }
}
