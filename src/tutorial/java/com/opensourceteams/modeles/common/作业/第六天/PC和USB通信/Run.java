package com.opensourceteams.modeles.common.作业.第六天.PC和USB通信;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/1  上午10:34
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {
        PC pc = new PC();
        IUSB IUSB = new Fan();
        pc.common(IUSB);

        IUSB = new Mp3();
        pc.common(IUSB);

        IUSB = new Camera();
        pc.common(IUSB);
    }
}
