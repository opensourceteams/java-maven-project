package com.opensourceteams.modules.common.gramar.图形化界面gui.n_05_jtable控件操作.n_07_jtable_显示一列数据;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午2:26
 * 功能描述:
 */

public class TableWindow extends  JFrame{


    JTable table = null;




    public TableWindow(){
        init();
    }

    public void init(){

        int x = 100 ;
        int y = 200 ;
        int width = 600 ;
        int height = 400;

        this.setLayout(null);

        this.setVisible(true);

        this.setLocation(x,y);//指定平面坐标

        this.setSize(width,height);//定义大小






        String[] columnNames = {"好友列表"};

        Object[][] data = {
                {"小明"},
                {"小华"},
                {"小军"}
        };

        // 把 data 数据变成更多
        Object[][] friends = new Object[100][1];
        for(int i = 0;i<100;i++){
            friends[i][0] = "好友名称" +(i+1);
        }


        table = new JTable(friends, columnNames);
        //table.setBounds(50 ,50,200,300);

        table.addMouseListener(new ButtonAdapt());

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50 ,50,200,150);





        this.add(scrollPane);


        // 事件
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(-1);
            }
        });

    }

    class ButtonAdapt extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            Component component = e.getComponent();
            if(component == table){
                System.out.println("单击了表格");
            }
        }
    }
}
