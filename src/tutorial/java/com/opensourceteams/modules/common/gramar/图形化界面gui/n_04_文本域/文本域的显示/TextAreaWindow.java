package com.opensourceteams.modules.common.gramar.图形化界面gui.n_04_文本域.文本域的显示;

import javax.swing.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/23  上午8:49
 * 功能描述:
 */

public class TextAreaWindow extends JFrame {

    public TextAreaWindow(String title){
        init(title);
    }


    private void init(String title){



        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);//用户单击“关闭”按钮时关闭窗口

        this.setVisible(true);

    }
}
