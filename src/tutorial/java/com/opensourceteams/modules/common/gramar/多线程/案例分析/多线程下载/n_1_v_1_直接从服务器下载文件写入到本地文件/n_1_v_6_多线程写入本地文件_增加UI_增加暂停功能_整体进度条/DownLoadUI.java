package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_6_多线程写入本地文件_增加UI_增加暂停功能_整体进度条;

import com.opensourceteams.modules.common.java.util.net.URLUtil;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/23  上午11:20
 * 功能描述:
 */

public class DownLoadUI extends JFrame {


    JLabel labUrl;
    JTextArea taUrl;

    JLabel  labSaveFilePath;
    JTextArea tfSaveFilePath;

    JLabel labCount;
    JTextField tfCount;

    JProgressBar bar;

    JButton btDown;

    JButton btIsSuspend; //是否暂停

    public DownLoadUI(String title){
        init(title);
    }

    private void init(String title){
        int leftMargin = 10;
        int aboveMargin = 10;

        this.setLayout(null);
        this.setBounds(0,0,800,600);

        int y = 0;


        // URL
        labUrl = new JLabel("URL:");
        labUrl.setBounds(leftMargin,aboveMargin,100,50);

        taUrl = new JTextArea();
        taUrl.setBounds(100,aboveMargin,500,100);
        taUrl.setText("http://110.96.192.8:81/1Q2W3E4R5T6Y7U8I9O0P1Z2X3C4V5B/apache.mirrors.lucidnetworks.net/tomcat/tomcat-9/v9.0.0.M4/bin/apache-tomcat-9.0.0.M4.zip");



        y = y + 100;
        //本地文件

        labSaveFilePath = new JLabel("本地文件:");
        labSaveFilePath.setBounds(leftMargin,aboveMargin + y,100,50);


        y = y + 50;

        tfSaveFilePath = new JTextArea();
        tfSaveFilePath.setBounds(100,aboveMargin + y,500,100);
        tfSaveFilePath.setText("/opt/temp/apache-tomcat-9.0.0.M4.zip");

        //线程数量
        y = y +150 ;
        labCount = new JLabel("线程数量");
        labCount.setBounds(leftMargin,aboveMargin + y,100,50);
        tfCount = new JTextField();
        tfCount.setBounds(100,aboveMargin + y,500,50);
        tfCount.setText("10");


        //暂停

        y = y + 100 ;
        btIsSuspend = new JButton("暂停");
        btIsSuspend.setBounds(100,aboveMargin + y,100,50);
        btIsSuspend.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getComponent() == btIsSuspend){
                    if("暂停".equals(btIsSuspend.getText())){
                        Download_URLUtil.globalIsSuspend = true;
                        btIsSuspend.setText("继续");
                    }else{
                        btIsSuspend.setText("暂停");
                        Download_URLUtil.globalIsSuspend = false;
                    }
                }
            }
        });



        //进度条

        y = y +60 ;
        bar = new JProgressBar();
        bar.setBounds(100,aboveMargin + y,500,10);

        //保存按钮
        y = y + 50;


        btDown = new JButton("下载");
        btDown.setBounds(100,y,100,50);

        btDown.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getComponent() ==btDown){
                    bar.setVisible(true);

                    setProgressBarCurrentValue(0);

                    Downloader downloader =   new Downloader(DownLoadUI.this);
                    downloader.download(taUrl.getText(),tfSaveFilePath.getText(),tfCount.getText());
                }
            }
        });

        this.add(labUrl);
        this.add(taUrl);

        this.add(labSaveFilePath);
        this.add(tfSaveFilePath);

        this.add(labCount);
        this.add(tfCount);

        //暂停
        this.add(btIsSuspend);

        this.add(bar);

        this.add(btDown);


        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void setProgressBarMaxValue(int value){
        bar.setMaximum(value);
    }

    public synchronized void setProgressBarCurrentValue(int value)
    {

        bar.setValue(bar.getValue() + value);

        if(bar.getValue() >= bar.getMaximum()){
            bar.setValue(0);
            bar.setVisible(false);
        }
    }
}
