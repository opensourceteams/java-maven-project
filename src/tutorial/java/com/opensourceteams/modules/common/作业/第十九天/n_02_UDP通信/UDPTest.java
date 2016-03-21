package com.opensourceteams.modules.common.作业.第十九天.n_02_UDP通信;

import org.junit.Test;

import java.net.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/20  下午4:05
 * 功能描述:
 */

public class UDPTest {


    @Test
    public void testReceive() throws Exception {
        DatagramSocket socket = new DatagramSocket(8889);

        byte[] buffer = new byte[1024] ;
        while (true){

            DatagramPacket pack = new DatagramPacket(buffer,1024);
            socket.receive(pack);

            int len = pack.getLength();
            System.out.println(new String(buffer,0,len));

        }
    }


    @Test
    public void testSend() throws  Exception{
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8888);
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
                inetAddress = InetAddress.getByName("192.168.0.103");
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            packet.setAddress(inetAddress);
            packet.setPort(8889);
            socket.send(packet);
            i++;
            Thread.sleep(1000);
            // System.out.println("发送的数据包" +i);
        }
    }
}
