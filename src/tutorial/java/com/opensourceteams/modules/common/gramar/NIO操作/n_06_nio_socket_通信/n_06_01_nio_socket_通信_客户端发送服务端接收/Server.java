package com.opensourceteams.modules.common.gramar.NIO操作.n_06_nio_socket_通信.n_06_01_nio_socket_通信_客户端发送服务端接收;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

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

        ServerSocketChannel server = null;
        SocketChannel client = null;

        while (true){
            selector.select();//挑选发生感兴趣的通道对应的key

            Set<SelectionKey> setSelectionKey =  selector.selectedKeys();
            for (SelectionKey selectionKey : setSelectionKey){
                //SelectableChannel selectableChannel = selectionKey.channel();
                setSelectionKey.remove(selectionKey);

                int sum = selectionKey.interestOps();
                if(selectionKey.isAcceptable()){
/*                    System.out.println("acceptable");
                    Object obj = selectionKey.attachment();
                    //sc = ssc.accept();
                    sc = ((ServerSocketChannel)selectionKey.channel()).accept();


                    sc.register(selector,SelectionKey.OP_READ);*/
                    System.out.println("Acceptable");
                    server = (ServerSocketChannel) selectionKey.channel();
                    client = server.accept();// 接受连接请求
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);

         /*           System.out.println("Acceptable");
                    server = (ServerSocketChannel) key.channel();
                    client = server.accept();// 接受连接请求
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);*/



                }else if(selectionKey.isReadable()){
                    System.out.println("readable");
                    client = (SocketChannel) selectionKey.channel();
                    int len = 0 ;


                    while ((len = client.read(buf)) != 0 ){
                        System.out.write(buf.array(),0,len);
                    }






                   // System.out.println(buf.toString());


                }else if(selectionKey.isWritable()){
                    System.out.println("writable");
                }else  if (selectionKey.isConnectable()){
                    System.out.println("connectable");
                }

            }
        }




    }
}
