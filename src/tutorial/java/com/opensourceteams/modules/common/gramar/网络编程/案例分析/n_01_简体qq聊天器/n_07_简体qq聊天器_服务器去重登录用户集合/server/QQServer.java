package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.server;




import com.opensourceteams.modules.common.java.util.SetUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/17  上午7:15
 * 功能描述:
 */

public class QQServer {

    private static QQServer qqServer = new QQServer();

    /** 联系人列表*/
    private static Set<String> contractTableRowData = new HashSet<String>(); //联系人行数据




    private QQServer(){

    }

    public static synchronized QQServer getInstance(){
        return qqServer;
    }



    /**
     * 启动
     * @param port
     * @return
     */
    public boolean start(int port){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("QQ服务器已启动... 端口为:" +serverSocket.getLocalPort());

            while (true){

                Socket socket = serverSocket.accept();
                new AddContractThread(socket).start();
                new MessageReceiverThread(socket).start();
                new MessageSenderThread(socket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


    public static Set<String> getContractTableRowData() {
        return contractTableRowData;
    }

    public static void setContractTableRowData(Set<String> contractTableRowData) {
        QQServer.contractTableRowData = contractTableRowData;
    }


    /**
     * 更新好友列表
     * @param hostname
     * @return
     */
    public static synchronized boolean addContractTableRowData(String hostname){

        contractTableRowData.add(hostname) ;
        System.out.println("增加后服务端的数据begin");
        SetUtil.println(contractTableRowData);
        System.out.println("增加后服务端的数据end");

        return true;
    }
}
