package com.opensourceteams.modules.common.gramar.图形化界面gui.n_02_label_控件操作;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  上午11:13
 * 功能描述:
 * LabelDemo.java needs one other file:
 *  src/tutorial/resources/images/middle.gif
 */
public class LabelDemo extends JPanel {
    public LabelDemo() {
        super(new GridLayout(3,1));  //3 rows, 1 column
        JLabel label1, label2, label3;

        ImageIcon icon =new ImageIcon();
        icon.setImage(getImage("src/tutorial/resources/images/middle.gif"));

        //Create the first label.
        label1 = new JLabel("Image and Text",
                icon,
                JLabel.CENTER);
        //Set the position of its text, relative to its icon:
        label1.setVerticalTextPosition(JLabel.BOTTOM);
        label1.setHorizontalTextPosition(JLabel.CENTER);

        //Create the other labels.
        label2 = new JLabel("Text-Only Label");
        label3 = new JLabel(icon);

        //Create tool tips, for the heck of it.
        label1.setToolTipText("A label containing both image and text");
        label2.setToolTipText("A label containing only text");
        label3.setToolTipText("A label containing only an image");

        //Add the labels.
        add(label1);
        add(label2);
        add(label3);
    }

    protected  static BufferedImage getImage(String path){
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path,
                                               String description) {

        java.net.URL imgURL = Thread.currentThread().getContextClassLoader().getResource(path);// LabelDemo.class.getResource(path);
       // System.out.println(imgURL.getPath());
       // System.out.println(imgURL.getFile());
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("LabelDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new LabelDemo());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);

                createAndShowGUI();
            }
        });
    }
}
