package com.opensourceteams.modules.common.作业.第十九天.n_04_UPD分离接收和发送单独的类;

import org.junit.Test;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/20  下午4:05
 * 功能描述:
 */

public class UDPTest {


    @Test
    public void testReceive() throws Exception {
       UDPReceiver.reveive(8889);

    }


    @Test
    public void testSend() throws  Exception{
        UDPSender.sender(8889,"192.168.0.103",8888);
    }
}
