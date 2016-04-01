package com.opensourceteams.modules.common.gramar.NIO操作.n_06_nio_socket_通信.n_06_03_nio_socket_通信_客户端发送控制台输入服务端接收并发送3;

/**
 * 日期: 2016-03-31  15:45
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Client {

    static ByteBuffer buf = ByteBuffer.allocate(1024);

    static  boolean isRead = true;

    public static void main(String args[]) throws IOException {
        int serverPort = 8888;

        SocketChannel channel = SocketChannel.open(); //打开Channel
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress("127.0.0.1", serverPort)); //连接

        Selector selector = Selector.open();    //打开Selector
        channel.register(selector, SelectionKey.OP_CONNECT); //注册OP_CONNECT


        while (true) {
            selector.select();  //    轮询
            Iterator iterator = selector.selectedKeys().iterator(); //获取可读的
            while (iterator.hasNext()) {

                SelectionKey key = (SelectionKey) iterator.next();
                iterator.remove();

                Handle(key, selector);
            }
        }
    }

    public static void Handle(SelectionKey key, Selector sel)
            throws IOException {

        SocketChannel client = (SocketChannel) key.channel();

        if (client.isConnectionPending()) {
            if (client.finishConnect()) {

/*                buf.put(new String("hello server").getBytes());
                buf.flip();
                client.write(buf);
                buf.clear();*/


                client.register(sel, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            }
        } else if (key.isReadable()) {
            isRead = true;
            buf.clear();

            int len = client.read(buf);
            if(len == -1){
                return;
            }
            buf.flip();
            byte[] bytes = new byte[buf.limit()];
            buf.get(bytes);

            System.out.println(new String(bytes));
        }else if(key.isWritable()){
            if(!isRead){
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String data = bufferedReader.readLine();
            buf.clear();
            buf.put(data.getBytes());
            buf.flip();
            client.write(buf);
            isRead =false;

        }

    }
}
