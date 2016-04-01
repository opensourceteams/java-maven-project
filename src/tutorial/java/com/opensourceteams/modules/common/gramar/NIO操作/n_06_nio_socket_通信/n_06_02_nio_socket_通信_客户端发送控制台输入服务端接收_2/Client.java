package com.opensourceteams.modules.common.gramar.NIO操作.n_06_nio_socket_通信.n_06_02_nio_socket_通信_客户端发送控制台输入服务端接收_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 日期: 2016-03-31  11:34
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Client {

    public static void main(String[] args) throws Exception{



        ByteBuffer buf = ByteBuffer.allocate(1024);
        int port = 9999;
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost",8888));

        //sc.bind(new InetSocketAddress(port));
        sc.configureBlocking(false);


        String data = "";
        while (true){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                data = bufferedReader.readLine();

               // ByteBuffer buf = ByteBuffer.wrap(data.getBytes());

                buf.put(data.getBytes());
                buf.flip();
                sc.write(buf);
                buf.clear();

                System.out.println("sent -> " +data);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

       // Selector selector = Selector.open();
       // sc.register(selector,SelectionKey.OP_CONNECT);


    }
}
