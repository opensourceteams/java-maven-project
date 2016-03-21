package com.opensourceteams.modules.common.gramar.图形化界面gui.n_00_HelloWorldSwing;

/*
 * HelloWorldSwing.java requires no other files.
 */
import javax.swing.*;


/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  下午1:42
 * 功能描述:
 */

public class HelloWorldSwing {

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
