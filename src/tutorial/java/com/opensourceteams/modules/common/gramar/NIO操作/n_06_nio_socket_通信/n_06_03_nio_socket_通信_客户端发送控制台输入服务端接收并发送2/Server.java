package com.opensourceteams.modules.common.gramar.NIO操作.n_06_nio_socket_通信.n_06_03_nio_socket_通信_客户端发送控制台输入服务端接收并发送2;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 日期: 2016-03-31  11:34
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Server {
    public static void main(String[] args) throws Exception {
        int port = 8888;
        //创建选择器,内部维护了三个集合
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();//打开服务器sorket通道
        ssc.bind(new InetSocketAddress(port));//绑定端口

        ssc.configureBlocking(false);//设置为非阻sai模式

        //在选择器中注册通道,选择感兴趣的动作
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //ServerSocketChannel server = null;
        //SocketChannel client = null;

        while (true){
            selector.select();//挑选发生感兴趣的通道对应的key

            Iterator<SelectionKey> itSelectionKey =  selector.selectedKeys().iterator();
            while (itSelectionKey.hasNext()){
                SelectionKey selectionKey = itSelectionKey.next();


                if(selectionKey.isAcceptable()){

                    System.out.println("Acceptable");
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel client = server.accept();// 接受连接请求
                    if(client!=null){
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                    }


                }else if(selectionKey.isReadable()){

                    //System.out.println("readable");
                    buf.clear();
                    SocketChannel client = (SocketChannel) selectionKey.channel();
                    int len = client.read(buf) ;
                    if(len == -1){
                        selectionKey.channel().close();
                        continue;
                    }else{
                        buf.flip();
                        byte[] bytes = new byte[buf.limit()];
                        buf.get(bytes);

                        System.out.println(new String(bytes));
                        selectionKey.attach(buf);
                    }

                    //client.register(selector, SelectionKey.OP_WRITE);



                }else if(selectionKey.isWritable()){
                   // System.out.println("writable");
                    SocketChannel client = (SocketChannel) selectionKey.channel();
                    ByteBuffer output = (ByteBuffer) selectionKey.attachment();




                    if(output !=null){
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        byteBuffer.clear();
                        byteBuffer.put("服务器返回:".getBytes());

                        output.flip();
                        byte[] bytes = new byte[output.limit()];
                        output.get(bytes);
                        byteBuffer.put(bytes);
                        byteBuffer.flip();
                        client.write(byteBuffer);
                        selectionKey.attach(null);


                    }

                }else  if (selectionKey.isConnectable()){
                    System.out.println("connectable");
                }

                itSelectionKey.remove();
                //selectionKey.channel().close();
                //selectionKey.cancel();

            }
            Thread.sleep(1000);
        }




    }
}
