package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_02_简体qq聊天器_增加静态联系人.view;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/17  上午3:40
 * 功能描述:
 */

public class QQMainWindow extends JFrame {


    int width = 1000;
    int height = 800;
    int x = 200;
    int y = 200 ;


    private static final long serialVersionUID = -6944831795769317874L;
    // 历史记录
    private JTextArea taHistory;
    // 内容
    private JTextArea taContent;
    // 发送按钮
    private JButton btnSend;


    /** 联系人列表*/
    Vector<Vector> contractTableRowData = null; //联系人行数据
    private JTable contractTable;  // 联系人列表
    private JScrollPane scrollPane ;//联系人,滚动面板

    /** 高度百分比率相对值 **/
    //聊天记录
    int taHistoryHeightPercentile = 65 ;
    //聊天内容
    int taContentHeightPercentile = 15 ;
    //发送按钮
    int btnSendHeightPercentile = 10 ;


    public QQMainWindow(){

        init();
    }

    // 初始化
    private void init() {



        this.setSize(width, height);
        this.setLocation(x, y);

        // 绝对布局
        this.setLayout(null);




        // 把 data 数据变成更多
        Vector<Vector> contractTableRowData = new Vector<Vector>();
        Vector row1 = new Vector();
        row1.add("小明");
        contractTableRowData.add(row1);


        Vector<String>  columnNames= new Vector<String>();
        columnNames.add("好友列表");



        contractTable = new JTable(contractTableRowData,columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };






        contractTable.setFont(new Font("SansSerif",Font.PLAIN,20));

        contractTable.setRowHeight(40);//设置行高
        //contractTable.setBounds( width * 70 /100, 0, width * 30 /100, height);








        JScrollPane scrollPane = new JScrollPane(contractTable);
        scrollPane.setBounds( width * 70 /100, 0, width * 30 /100, height - 86);
        this.add(scrollPane);







        //聊天记录区

        int taHistoryHeight = getScaleValue(height,taHistoryHeightPercentile,taContentHeightPercentile,btnSendHeightPercentile);
        int taHistoryY = 0;
        taHistory = new JTextArea();
        taHistory.setEditable(false);
        taHistory.setBounds(0, taHistoryY,  width * 69 /100,  taHistoryHeight);
        this.add(taHistory);

        //聊天内容
        int taContentHeight = getScaleValue(height,taContentHeightPercentile,taHistoryHeightPercentile,btnSendHeightPercentile);
        int taContentY = taHistoryHeight + 5;
        taContent = new JTextArea();
        taContent.setEditable(true);
        taContent.setBounds(0, taContentY, width * 69 /100, taContentHeight);
        this.add(taContent);


        //发送按钮
       // int btnSendHeight = getScaleValue(height,taContentHeightPercentile,taHistoryHeightPercentile,btnSendHeightPercentile);
        btnSend = new JButton("发送");
        int btnSendX = 580;
        int btnSendY = taContentY +taContentHeight + 5;
        btnSend.setBounds(btnSendX,btnSendY,100, 50);
        this.add(btnSend);


        this.setVisible(true);



        // 事件
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(-1);
            }
        });


        /**
         * 手动增加联系人
         */
        Vector row2 = new Vector();
        row2.add("小明4");
        contractTableRowData.add(row2);


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
     * @param totalValue
     * @param currentValue
     * @param scales
     * @return
     */
    public int getScaleValue(int totalValue,int currentValue,int ... scales){

        int totalScal = currentValue;
        for(int scale : scales){
            totalScal = totalScal +scale;
        }

        return (int)(totalValue * (currentValue / (double)totalScal )) ;
    }


}
