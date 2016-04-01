package com.opensourceteams.modules.common.gramar.NIO操作.n_05_socket_Selector_操作;

/**
 * 日期: 2016-03-31  15:45
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioClient {

    public static void main(String args[]) throws IOException {

        SocketChannel channel = SocketChannel.open(); //打开Channel
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress("127.0.0.1", 8085)); //连接

        Selector selector = Selector.open();    //打开Selector
        channel.register(selector, SelectionKey.OP_CONNECT); //注册OP_CONNECT

        while (true) {
            selector.select();  //    轮询
            Iterator iterator = selector.selectedKeys().iterator(); //获取可读的
            while (iterator.hasNext()) {

                SelectionKey key = (SelectionKey) iterator.next();
                iterator.remove();

                if (key.isConnectable()) {
                    Handle(key, selector);
                }
            }
        }
    }

    public static void Handle(SelectionKey key, Selector sel)
            throws IOException {

        SocketChannel client = (SocketChannel) key.channel();

        if (client.isConnectionPending()) {
            if (client.finishConnect()) {

                ByteBuffer byteBuffer = ByteBuffer.allocate(200);
                byteBuffer = ByteBuffer.wrap(new String("hello server")
                        .getBytes());
                client.write(byteBuffer);
                client.register(sel, SelectionKey.OP_READ);
            }
        } else if (key.isReadable()) {

        }

    }
}
