package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_13_简体qq聊天器_客户端退出后_服务器在线用户刷新.client.view;



import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_13_简体qq聊天器_客户端退出后_服务器在线用户刷新.client.controller.MouseEventProcessAdapter;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/17  上午3:40
 * 功能描述:
 */

public class QQMainWindow extends JFrame {

    static Socket socket;

    int width = 1000;
    int height = 800;
    int x = 0;
    int y = 0;

    static QQMainWindow qqMainWindow = null;


    public static synchronized QQMainWindow getInstance(){
        return getInstance("localhost");
    }
    public static synchronized QQMainWindow getInstance(String hostname) {
        if (qqMainWindow == null) {
            try {
                socket = new Socket(hostname,1234);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return qqMainWindow = new QQMainWindow();
        } else {
            return qqMainWindow;
        }
    }


    private static final long serialVersionUID = -6944831795769317874L;
    // 历史记录
    private JTextArea taHistory;
    // 内容
    private JTextArea taContent;
    // 发送按钮
    private JButton btnSend;


    /**
     * 联系人列表
     */
    static Vector<Vector> contractTableRowData = new Vector<Vector>(); //联系人行数据
    private JTable contractTable;  // 联系人列表
    private JScrollPane scrollPane;//联系人,滚动面板

    /**
     * 高度百分比率相对值
     **/
    //聊天记录
    int taHistoryHeightPercentile = 65;
    //聊天内容
    int taContentHeightPercentile = 15;
    //发送按钮
    int btnSendHeightPercentile = 10;


    private QQMainWindow() {

        init();
    }

    // 初始化
    private void init() {


        this.setSize(width, height);
        this.setLocation(x, y);

        // 绝对布局
        this.setLayout(null);




        Vector<String> columnNames = new Vector<String>();
        columnNames.add("好友列表");


        contractTable = new JTable(contractTableRowData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        contractTable.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                System.out.println("表格数据改变了");
            }
        });


        contractTable.setFont(new Font("SansSerif", Font.PLAIN, 20));

        contractTable.setRowHeight(40);//设置行高
        //contractTable.setBounds( width * 70 /100, 0, width * 30 /100, height);


        JScrollPane scrollPane = new JScrollPane(contractTable);
        scrollPane.setBounds(width * 70 / 100, 0, width * 30 / 100, height - 86);
        this.add(scrollPane);


        //聊天记录区

        int taHistoryHeight = getScaleValue(height, taHistoryHeightPercentile, taContentHeightPercentile, btnSendHeightPercentile);
        int taHistoryY = 0;
        taHistory = new JTextArea();
        taHistory.setEditable(false);
        taHistory.setBounds(0, taHistoryY, width * 69 / 100, taHistoryHeight);
        this.add(taHistory);

        //聊天内容
        int taContentHeight = getScaleValue(height, taContentHeightPercentile, taHistoryHeightPercentile, btnSendHeightPercentile);
        int taContentY = taHistoryHeight + 5;
        taContent = new JTextArea();
        taContent.setEditable(true);
        taContent.setBounds(0, taContentY, width * 69 / 100, taContentHeight);
        this.add(taContent);


        //发送按钮
        // int btnSendHeight = getScaleValue(height,taContentHeightPercentile,taHistoryHeightPercentile,btnSendHeightPercentile);
        btnSend = new JButton("发送");
        int btnSendX = 580;
        int btnSendY = taContentY + taContentHeight + 5;
        btnSend.setBounds(btnSendX, btnSendY, 100, 50);
        btnSend.addMouseListener(new MouseEventProcessAdapter(btnSend,taContent,socket));
        this.add(btnSend);



        this.setVisible(true);


        // 事件
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(-1);
            }
        });


        //contractTable.invalidate();
/*        contractTable = new JTable(rowData,columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };*/

    }


    /**
     * 得到百分比率相对值
     *
     * @param totalValue
     * @param currentValue
     * @param scales
     * @return
     */
    public int getScaleValue(int totalValue, int currentValue, int... scales) {

        int totalScal = currentValue;
        for (int scale : scales) {
            totalScal = totalScal + scale;
        }

        return (int) (totalValue * (currentValue / (double) totalScal));
    }






    public  boolean refleshContractTable(Set set) {
        // 把 data 数据变成更多
        contractTableRowData.clear();

        System.out.println("客户端窗体届新数据 start");
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            Vector vector = new Vector();
            String v = it.next();
            vector.add(v);
            contractTableRowData.add(vector);
            System.out.println("客户端窗体届新数据:-->"+v);
        }
        System.out.println("客户端窗体届新数据 end ============");
        contractTable.addNotify();


        return true;
    }

    public  boolean appendJTextAreaHistory(String text){
        taHistory.append(text);
        taHistory.addNotify();
        return  true;
    }


    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
