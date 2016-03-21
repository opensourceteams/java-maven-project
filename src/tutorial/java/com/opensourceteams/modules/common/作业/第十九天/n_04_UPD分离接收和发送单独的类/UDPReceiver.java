package com.opensourceteams.modules.common.作业.第十九天.n_04_UPD分离接收和发送单独的类;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  上午6:12
 * 功能描述:
 */

public class UDPReceiver {

    /**
     * 接收数据,相当于客户端接收数据
     */
    public static void reveive(int port){

        DatagramSocket socket = null;
        byte[] buffer = new byte[1024] ;

        try {
            socket = new DatagramSocket(port);

            while (true){

                DatagramPacket pack = new DatagramPacket(buffer,buffer.length);
                socket.receive(pack);

                int len = pack.getLength();
                System.out.println(new String(buffer,0,len));

            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
