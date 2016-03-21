package com.opensourceteams.modules.common.java.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/20  下午4:50
 * 功能描述:
 */

public class DatagramPacketReceiveTest {



    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8889);

        byte[] buffer = new byte[1024] ;
         while (true){

             DatagramPacket pack = new DatagramPacket(buffer,1024);
             socket.receive(pack);

             int len = pack.getLength();
             System.out.println(new String(buffer,0,len));

         }

    }
}
