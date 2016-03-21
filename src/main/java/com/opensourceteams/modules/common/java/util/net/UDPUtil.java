package com.opensourceteams.modules.common.java.util.net;

import com.opensourceteams.modules.common.java.io.file.ObjectSerializationUtil;

import java.io.IOException;
import java.net.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  上午6:51
 * 功能描述:
 */

public class UDPUtil {



    /**
     * 接收数据,相当于客户端接收数据
     */
    public static byte[] reveiveOnceDeserialize(int port){

        DatagramSocket socket = null;
        byte[] buffer = new byte[1024] ;

        try {
            socket = new DatagramSocket(port);


                DatagramPacket pack = new DatagramPacket(buffer,buffer.length);
                socket.receive(pack);

                int len = pack.getLength();
                byte[] bytes = new byte[len];
                System.arraycopy(buffer,0,bytes,0,len);

                Object obj = ObjectSerializationUtil.objectDeserialize(bytes);
                //System.out.println(new String(buffer,0,len));
                socket.close();
                return (byte[])obj;


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 接收数据,相当于客户端接收数据
     * ).接数据据包的包装类DatagramSocket
     * ).DatagramSocket里边有接收数据的功能: receive
     * ).
     */
    public static byte[] reveiveOnce(int port){

        DatagramSocket socket = null;
        byte[] buffer = new byte[1024 * 64] ;

        try {
            socket = new DatagramSocket(port);


            DatagramPacket pack = new DatagramPacket(buffer,buffer.length);
            socket.receive(pack);

            int len = pack.getLength();
            byte[] bytes = new byte[len];
            System.arraycopy(buffer,0,bytes,0,len);

            //Object obj = ObjectSerializationUtil.objectDeserialize(bytes);
            //System.out.println(new String(buffer,0,len));
            socket.close();
            return bytes;


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public  static DatagramSocket getSingleDatagramSocket(DatagramSocket socket,int receivePort){
        if(socket == null){
            DatagramSocket newSocket = null;
            try {
                newSocket = new DatagramSocket(receivePort);
            } catch (SocketException e) {
                e.printStackTrace();
            }
            return newSocket;
        }else{
            return socket;
        }
    }


    public static byte[] reveive(DatagramSocket socket){

        byte[] buffer = new byte[1024 * 64] ;

        try {



            DatagramPacket pack = null;
            pack = new DatagramPacket(buffer,buffer.length);
            socket.receive(pack);

            int len = pack.getLength();
            byte[] bytes = new byte[len];
            System.arraycopy(buffer,0,bytes,0,len);

            //Object obj = ObjectSerializationUtil.objectDeserialize(bytes);
            //System.out.println(new String(buffer,0,len));
            //socket.close();
            return bytes;


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }



    /**
     * 发送数据
     * @param receiverPort
     * @param receiverIp
     * @param port
     * @param sendData
     */
    public static void senderOnce(int receiverPort, String receiverIp, int port, byte[] sendData){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        //将数据序列化
        try {
           // byte[] objectSerialization = ObjectSerializationUtil.objectSerialization(sendData);
            //DatagramPacket packet  = new DatagramPacket(objectSerialization,objectSerialization.length);

            DatagramPacket packet  = new DatagramPacket(sendData,sendData.length);

            InetAddress inetAddress = null;
            //192.168.12.255 ->通配地址，该网段内的所有主机。
            inetAddress = InetAddress.getByName(receiverIp);
            packet.setAddress(inetAddress);
            packet.setPort(receiverPort);
            socket.send(packet);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void sender(DatagramSocket socket,int receiverPort, String receiverIp, byte[] sendData){

        //将数据序列化
        try {


            DatagramPacket packet  = new DatagramPacket(sendData,sendData.length);

            InetAddress inetAddress = null;
            //192.168.12.255 ->通配地址，该网段内的所有主机。
            inetAddress = InetAddress.getByName(receiverIp);
            packet.setAddress(inetAddress);
            packet.setPort(receiverPort);
            socket.send(packet);
            //socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 发送数据
     * @param receiverPort
     * @param receiverIp
     * @param port
     * @param sendData
     */
    public static void senderOnceSerialization(int receiverPort, String receiverIp, int port, byte[] sendData){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        //将数据序列化
        try {
             byte[] objectSerialization = ObjectSerializationUtil.objectSerialization(sendData);
            DatagramPacket packet  = new DatagramPacket(objectSerialization,objectSerialization.length);


            InetAddress inetAddress = null;
            //192.168.12.255 ->通配地址，该网段内的所有主机。
            inetAddress = InetAddress.getByName(receiverIp);
            packet.setAddress(inetAddress);
            packet.setPort(receiverPort);
            socket.send(packet);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void senderOnce(int receiverPost, String receiverIp, int port){
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
