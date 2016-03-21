package com.opensourceteams.modules.common.作业.第十九天.n_04_UPD分离接收和发送单独的类;

import java.io.IOException;
import java.net.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  上午6:16
 * 功能描述:
 */

public class UDPSender {

    public static void sender(int receiverPost,String receiverIp,int port){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        int i =  1;



        while (true){


            byte[] buf = ("你好" + i ).getBytes();
            DatagramPacket packet  = new DatagramPacket(buf,buf.length);

            InetAddress inetAddress = null;
            try {
                //192.168.12.255 ->通配地址，该网段内的所有主机。
                inetAddress = InetAddress.getByName(receiverIp);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            packet.setAddress(inetAddress);
            packet.setPort(receiverPost);
            try {
                socket.send(packet);
                Thread.sleep(1000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;


        }
    }
}
