package com.opensourceteams.modules.common.gramar.图形化界面gui.n_05_jtable控件操作.n_05_jtable放在JFrame中显示不了列标题;

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






        String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};

        Object[][] data = {
                {"Kathy", "Smith",
                        "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown",
                        "Pool", new Integer(10), new Boolean(false)}
        };


        table = new JTable(data, columnNames);
        table.setBounds(50 ,50,400,300);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.addMouseListener(new ButtonAdapt());





        this.add(table);


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
