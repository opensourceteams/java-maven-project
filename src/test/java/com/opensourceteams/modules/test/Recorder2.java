package com.opensourceteams.modules.test;


import javax.sound.sampled.*;
import java.io.File;

public class Recorder2 {
    TargetDataLine line;
    AudioFormat a = new AudioFormat(16000, 16, 2, true, true);

    public void start() {
        try {
            System.out.println("开始录制音频......");
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, a);
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(a);
            line.start();
            AudioInputStream ais = new AudioInputStream(line);
            AudioSystem.write(ais, AudioFileFormat.Type.WAVE,
                    new File("1.wav"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Recorder2();
    }

    public Recorder2() {
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                line.stop();
                line.close();
                System.out.println("录制完成");


            }
        });
        stopper.start();
        start();
    }
}