package com.opensourceteams.modules.product.项目.n_01_屏广软件.n_01_v_01_屏广软件;

/**
 * 日期: 2016-03-27  10:56
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Constanct {

    private static int receiverPort = 7779; //接收端启用的端口号
    private static  int senderPort = 7778 ; //发送端启用的端口号

    public static int getReceiverPort() {
        return receiverPort;
    }

    private static void setReceiverPort(int receiverPort) {
        Constanct.receiverPort = receiverPort;
    }

    public static int getSenderPort() {
        return senderPort;
    }

    public static void setSenderPort(int senderPort) {
        Constanct.senderPort = senderPort;
    }
}
