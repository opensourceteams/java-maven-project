package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_12_多线程下载_断点续传_解决保存数据的问题;


import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/23  上午11:20
 * 功能描述:
 */

public class DownLoadUI extends JFrame {

    String urlText = "http://localhost:8080/ubuntu-15.10-desktop-amd64.iso";
    String saveFilePath = "/opt/temp/download/ubuntu-15.10-desktop-amd64.iso";
    int countThread = 3;


    JLabel labUrl;
    JTextArea txtaUrl; //url地址

    JLabel labSaveFilePath;
    JTextArea txtaSaveFilePath; //本地文件保存地址

    JLabel labCount;
    JTextField txtCount; //线程数量

    JButton btIsSuspend; //是否暂停

    JButton butIsStop; //是否停止

    JButton btDown; //下载
    JButton butBreakpointDown;  //继续下载

    JProgressBar bar; //进度条

    JLabel labState;//下载状态信息

    public DownLoadUI(String title) {
        init(title);
    }

    private void init(String title) {
        int leftMargin = 10;
        int aboveMargin = 10;

        this.setLayout(null);
        this.setBounds(0, 0, 800, 600);

        int y = 0;


        // URL
        labUrl = new JLabel("URL:");
        labUrl.setBounds(leftMargin, aboveMargin, 100, 50);

        txtaUrl = new JTextArea();
        txtaUrl.setBounds(100, aboveMargin, 500, 100);
        txtaUrl.setText(urlText);


        y = y + 100;
        //本地文件

        labSaveFilePath = new JLabel("本地文件:");
        labSaveFilePath.setBounds(leftMargin, aboveMargin + y, 100, 50);


        y = y + 50;

        txtaSaveFilePath = new JTextArea();
        txtaSaveFilePath.setBounds(100, aboveMargin + y, 500, 100);

        txtaSaveFilePath.setText(saveFilePath);

        //线程数量
        y = y + 150;
        labCount = new JLabel("线程数量");
        labCount.setBounds(leftMargin, aboveMargin + y, 100, 50);
        txtCount = new JTextField();
        txtCount.setBounds(100, aboveMargin + y, 500, 50);
        txtCount.setText(countThread +"");


        //暂停

        y = y + 100;
        btIsSuspend = new JButton("暂停");
        btIsSuspend.setBounds(100, aboveMargin + y, 100, 50);
        btIsSuspend.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getComponent() == btIsSuspend) {
                    if ("暂停".equals(btIsSuspend.getText())) {
                        Download_URLUtil.globalIsSuspend = true;
                        btIsSuspend.setText("继续");
                    } else {
                        btIsSuspend.setText("暂停");
                        Download_URLUtil.globalIsSuspend = false;
                    }
                }
            }
        });

        //停止

        butIsStop = new JButton("停止");
        butIsStop.setBounds(210, aboveMargin + y, 100, 50);
        butIsStop.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Download_URLUtil.globalIsStop = true;
                updateState("已停止下载任务");
            }
        });


        //下载

        btDown = new JButton("下载");
        btDown.setBounds(320, aboveMargin + y, 100, 50);

        btDown.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getComponent() == btDown) {
                    bar.setVisible(true); //进度条可见
                    bar.setValue(0); //当前进度条长度
                    btDown.setText("开始下载");

                    setProgressBarCurrentValue(0);//进度条当前进度为0
                    Download_URLUtil.globalIsStop = false; //是否停止,不停止
                    Download_URLUtil.globalIsSuspend = false ; //是否暂停,不暂停

                    Downloader downloader = new Downloader(DownLoadUI.this);
                    downloader.download(txtaUrl.getText(), txtaSaveFilePath.getText(), txtCount.getText());
                }
            }
        });

        //继续下载
        butBreakpointDown = new JButton("继续下载");
        butBreakpointDown.setBounds(430, aboveMargin + y, 100, 50);
        butBreakpointDown.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getComponent() == butBreakpointDown) {
                    bar.setVisible(true); //进度条可见
                    butBreakpointDown.setText("继续下载");

                    Download_URLUtil.globalIsStop = false; //是否停止,不停止
                    Download_URLUtil.globalIsSuspend = false ; //是否暂停,不暂停

                    Downloader downloader = new Downloader(DownLoadUI.this);
                    downloader.continueDownload( txtCount.getText());
                }
            }
        });

        //下载状态信息
        labState = new JLabel("状态个息显示");
        //labState.setVisible(false);
        labState.setBounds(580, aboveMargin + y, 100, 50);

        //进度条

        y = y + 60;
        bar = new JProgressBar();
        bar.setBounds(100, aboveMargin + y, 500, 10);



        this.add(labUrl);
        this.add(txtaUrl);//url

        this.add(labSaveFilePath);
        this.add(txtaSaveFilePath); //本地文件路径

        this.add(labCount);
        this.add(txtCount); //线程数量


        this.add(btIsSuspend);//暂停

        this.add(butIsStop);//停止

        this.add(bar); //进度条

        this.add(labState) ;//下载状态信息

        this.add(btDown); //下载
        this.add(butBreakpointDown) ; //继续下载


        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    /**
     * 设置进度条的最大显示值,初使显示值
     * @param value
     */
    public void setProgressBarMaxValue(int value) {
        bar.setMaximum(value);
    }

    /**
     * 设置当前进度条的显示值
     * @param value
     */
    public synchronized void setProgressBarCurrentValue(int value) {

        bar.setValue(bar.getValue() + value);

        if (bar.getValue() >= bar.getMaximum()) {
            //bar.setValue(0);
            //bar.setVisible(false);
            updateState("下载完成");
        }
    }

    /**
     * 更新下载状态显示信息
     * @param state
     */
    public void updateState(String state) {
        labState.setText(state);
        labState.setVisible(true);
    }
}
