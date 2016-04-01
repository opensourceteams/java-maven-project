package com.opensourceteams.modules.common.gramar.NIO操作.n_05_socket_Selector_操作;

import org.junit.Test;

import java.io.IOException;
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
public class Run {

    @Test
    public void testServer() throws IOException {
        int port = 8888;
        //创建选择器,内部维护了三个集合
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();//打开服务器sorket通道
        ssc.bind(new InetSocketAddress(port));//绑定端口

        ssc.configureBlocking(false);//设置为非阻sai模式

        //在选择器中注册通道,选择感兴趣的动作
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        SocketChannel sc = null;
        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (true){
            selector.select();//挑选发生感兴趣的通道对应的key

            Set<SelectionKey> setSelectionKey =  selector.selectedKeys();
            for (SelectionKey selectionKey : setSelectionKey){
                //SelectableChannel selectableChannel = selectionKey.channel();
                int sum = selectionKey.interestOps();
                if(selectionKey.isAcceptable()){
                    System.out.println("acceptable");
                    Object obj = selectionKey.attachment();
                    sc = ssc.accept();
                    sc.register(selector,SelectionKey.OP_READ | SelectionKey.OP_WRITE);



                }else if(selectionKey.isReadable()){
                    sc = (SocketChannel) selectionKey.channel();
                    sc.read(buf);
                    System.out.println("readable");
                }else if(selectionKey.isWritable()){
                    System.out.println("writable");
                }else  if (selectionKey.isConnectable()){
                    System.out.println("connectable");
                }

            }
        }




    }
    @Test
    public void b() throws IOException {

        int port = 9999;
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost",8888));

        //sc.bind(new InetSocketAddress(port));
        sc.configureBlocking(false);
        ByteBuffer buf = ByteBuffer.wrap("你好".getBytes());
        sc.write(buf);
        System.out.println("over");

        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

       // Selector selector = Selector.open();
       // sc.register(selector,SelectionKey.OP_CONNECT);


    }
}
