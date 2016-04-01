package com.opensourceteams.modules.common.gramar.NIO操作.n_05_socket_Selector_操作;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
/**
 * 日期: 2016-03-31  15:45
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class NioServer {
    public static void main(String args[]) throws IOException {

        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.socket().bind(new InetSocketAddress(8085), 10);
        channel.configureBlocking(false);
        Selector selector = Selector.open();

        channel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {

            selector.select();
            Iterator<?> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {

                SelectionKey key = (SelectionKey) iterator.next();
                iterator.remove(); // 删除此消息
                handlekey(key, selector);


            }

        }
    }

    public static void handlekey(SelectionKey key,Selector selector) throws IOException {

        ServerSocketChannel server = null;
        SocketChannel client = null;

        if (key.isAcceptable()) {

            System.out.println("Acceptable");
            server = (ServerSocketChannel) key.channel();
            client = server.accept();// 接受连接请求
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);

        } else if (key.isReadable()) {

            client = (SocketChannel) key.channel();
            //
            ByteBuffer byteBuffer = ByteBuffer.allocate(200);
            int count=client.read(byteBuffer);

            if(count>0){

                System.out.println("Readable");
                System.out.println(new String(byteBuffer.array()));

            }else if(count ==-1){
                key.cancel();  //移除
                return;
            }


        }

    }
}