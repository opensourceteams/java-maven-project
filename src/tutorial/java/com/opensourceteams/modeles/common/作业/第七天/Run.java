package com.opensourceteams.modeles.common.作业.第七天;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/1  上午11:52
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {

        Button button = new Button();




        CustomButtonDBClickListener customButtonDBClickListener = new CustomButtonDBClickListener();

        IButtonListener iButtonListener = new CustomButtonClickListener(){
            @Override
            public void click() {
                System.out.println("自定义单击事件");
            }
            @Override
            public void dbclick() {
                System.out.println("自定义双击事件");
            }
        };
        button.addListener(iButtonListener);



        button.click();

        button.dbclick();

        System.out.println("button2");

        Button button2 = new Button();

        IButtonListener iButtonListener2 = new CustomButtonClickListener(){
            @Override
            public void click() {
                System.out.println("button2 自定义单击事件");
            }
        };

        button2.addListener(iButtonListener2);
        button2.click();


    }
}
