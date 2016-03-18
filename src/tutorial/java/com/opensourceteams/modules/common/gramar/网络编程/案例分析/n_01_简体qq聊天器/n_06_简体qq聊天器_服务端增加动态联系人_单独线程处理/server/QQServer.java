package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_06_简体qq聊天器_服务端增加动态联系人_单独线程处理.server;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/17  上午7:15
 * 功能描述:
 */

public class QQServer {

    private static QQServer qqServer = new QQServer();

    /** 联系人列表*/
    private static Vector<Vector> contractTableRowData = null; //联系人行数据
    static {
        // 把 data 数据变成更多
        contractTableRowData = new Vector<Vector>();
        Vector row1 = new Vector();
        row1.add("小明");
        contractTableRowData.add(row1);

        Vector row2 = new Vector();
        row2.add("小黄");
        contractTableRowData.add(row2);
    }




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


    public static Vector<Vector> getContractTableRowData() {
        return contractTableRowData;
    }

    public static void setContractTableRowData(Vector<Vector> contractTableRowData) {
        QQServer.contractTableRowData = contractTableRowData;
    }

    /**
     * 更新好友列表
     * @param rowData
     * @return
     */
    public static synchronized boolean addContractTableRowData(Vector rowData){
        if(contractTableRowData != null){
            contractTableRowData.add(rowData) ;

            System.out.println("增加后服务端的数据");
            for(Vector<String> v :contractTableRowData){
                System.out.println(v.toString());
            }
        }
        return true;
    }

    /**
     * 更新好友列表
     * @param hostname
     * @return
     */
    public static synchronized boolean addContractTableRowData(String hostname){
        if(contractTableRowData != null){
            Vector<String> rowData = new Vector<String>();
            rowData.add(hostname);


            contractTableRowData.add(rowData) ;

            System.out.println("增加后服务端的数据");
            for(Vector<String> v :contractTableRowData){
                System.out.println(v.toString());
            }
        }
        return true;
    }
}
