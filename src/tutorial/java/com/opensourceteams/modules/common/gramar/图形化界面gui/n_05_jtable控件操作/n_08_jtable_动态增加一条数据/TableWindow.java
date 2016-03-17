package com.opensourceteams.modules.common.gramar.图形化界面gui.n_05_jtable控件操作.n_08_jtable_动态增加一条数据;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午2:26
 * 功能描述:
 */

public class TableWindow extends  JFrame{


    JTable table = null;

    JButton btnSave = new JButton("增加一条数据");

    Vector<Vector> rows = new Vector<Vector>();


    int i = 0;

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


        System.out.println("aa");
        while (true){

            if(i >= 5){
                break;
            }

            Vector<String> row = new Vector<String>();
            row.add("小明 " + (++i));
            rows.add(row);
        }

        System.out.println(" break");

        Vector<String> columnNames = new Vector<String>();
        columnNames.add("好友列表");



        table = new JTable(rows, columnNames);
        //table.setBounds(50 ,50,200,300);

        table.addMouseListener(new ButtonAdapt());

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50 ,50,200,150);




        btnSave.setBounds( width /2 +10 ,250,100,50);
        btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Vector<String> row = new Vector<String>();
                row.add("小明 " + (++i));
                rows.add(row);
                table.addNotify(); //届新 table中的数据
               // table.invalidate();
                System.out.println("增加了一条数据");
            }
        });


        this.add(scrollPane);
        this.add(btnSave);


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
