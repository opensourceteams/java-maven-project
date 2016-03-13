package com.opensourceteams.modules.common.作业.第七天.用接口作内部类;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/1  上午11:52
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {

        Button button = new Button();

        IButtonListener iButtonListener = new IButtonListener(){
            public void click() {
                System.out.println("自定义单击事件");
            }
            public void dbclick() {
                System.out.println("自定义双击事件");
            }

            public void keyUp() {

            }

            public void keyDown() {

            }
        };
        button.addListener(iButtonListener);

        button.click();

        button.dbclick();

        System.out.println("button2");

        Button button2 = new Button();

        IButtonListener iButtonListener2 = new IButtonListener(){

            public void click() {
                System.out.println("button2 自定义单击事件");
            }

            public void dbclick() {

            }

            public void keyUp() {

            }

            public void keyDown() {

            }
        };

        button2.addListener(iButtonListener2);
        button2.click();


    }
}
