package com.opensourceteams.modules.test;


import javax.sound.sampled.*;
import java.io.File;

public class Recorder3 {
    AudioFormat audioFormat = new AudioFormat(16000, 16, 1, true, true);
    TargetDataLine targetDataLine = null;

    public void start() {
        try {


            DataLine.Info targetInfo =
                    new DataLine.Info(
                            TargetDataLine.class,
                            audioFormat); // Set the system information to read from the microphone audio stream


            if (!AudioSystem.isLineSupported(targetInfo)) {
                System.out.println("麦克风不支持,直接退出");
                System.exit(0);
            }
            // Target data line captures the audio stream the microphone produces.
             targetDataLine = (TargetDataLine) AudioSystem.getLine(targetInfo);

            targetDataLine.open(audioFormat);
            targetDataLine.start();
            System.out.println("开始录制音频......");
            AudioInputStream ais = new AudioInputStream(targetDataLine);
            AudioSystem.write(ais, AudioFileFormat.Type.WAVE,
                    new File("20.wav"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Recorder3();
    }

    public Recorder3() {
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(20 * 1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                targetDataLine.stop();
                targetDataLine.close();
                System.out.println("录制完成");


            }
        });
        stopper.start();
        start();
    }
}