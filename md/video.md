# java 读取音频/视频  文件时长
- 支持mp3,mp4,mov,m4a,wav 格式文件

## 源码
- https://github.com/opensourceteams/java-maven-project


### pom.xml
```aidl
  <!-- mp3文件支持(如语音时长)-->
    <dependency>
      <groupId>org</groupId>
      <artifactId>jaudiotagger</artifactId>
      <version>2.0.1</version>
    </dependency>

    <!-- mp4文件支持(如语音时长)-->
    <dependency>
      <groupId>com.googlecode.mp4parser</groupId>
      <artifactId>isoparser</artifactId>
      <version>1.1.22</version>
    </dependency>

```


### 单元测试

```aidl
package com.opensourceteams.modules.java.util.video;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class VideoUtilTest {

    @Test
    public void getDuration() throws IOException {
        String path = "/Users/liuwen/Downloads/temp/语音测试文件/xiaoshizi.mp3" ;
      /*  String path = "/Users/liuwen/Downloads/temp/语音测试文件/xiaoshizi.mp4" ;
        String path = "/Users/liuwen/Downloads/temp/语音测试文件/xiaoshizi.wav" ;
        String path = "/Users/liuwen/Downloads/temp/语音测试文件/xiaoshizi.mov" ;
        String path = "/Users/liuwen/Downloads/temp/语音测试文件/xiaoshizi.m4a" ;*/

        long result = VideoUtil.getDuration(path);
        System.out.println(result);
    }

}
```


### 工具类

```aidl
package com.opensourceteams.modules.java.util.video;



import com.coremedia.iso.IsoFile;

import java.io.IOException;


public class VideoUtil {


    /**
     * 获取视频文件的播放长度(mp4、mov格式)
     * @param videoPath
     * @return 单位为毫秒
     */
    public static long getMp4Duration(String videoPath) throws IOException {
        IsoFile isoFile = new IsoFile(videoPath);
        long lengthInSeconds =
                isoFile.getMovieBox().getMovieHeaderBox().getDuration() /
                isoFile.getMovieBox().getMovieHeaderBox().getTimescale();
        return lengthInSeconds;
    }


    /**
     * 得到语音或视频文件时长,单位秒
     * @param filePath
     * @return
     * @throws IOException
     */
    public static long getDuration(String filePath) throws IOException {
        String format = getVideoFormat(filePath);
        long result = 0;
        if("wav".equals(format)){
            result = AudioUtil.getDuration(filePath).intValue();
        }else if("mp3".equals(format)){
            result = AudioUtil.getMp3Duration(filePath).intValue();
        }else if("m4a".equals(format)) {
            result = VideoUtil.getMp4Duration(filePath);
        }else if("mov".equals(format)){
            result = VideoUtil.getMp4Duration(filePath);
        }else if("mp4".equals(format)){
            result = VideoUtil.getMp4Duration(filePath);
        }

        return result;
    }

    /**
     * 得到语音或视频文件时长,单位秒
     * @param filePath
     * @return
     * @throws IOException
     */
    public static long getDuration(String filePath,String format) throws IOException {
        long result = 0;
        if("wav".equals(format)){
            result = AudioUtil.getDuration(filePath).intValue();
        }else if("mp3".equals(format)){
            result = AudioUtil.getMp3Duration(filePath).intValue();
        }else if("m4a".equals(format)) {
            result = VideoUtil.getMp4Duration(filePath);
        }else if("mov".equals(format)){
            result = VideoUtil.getMp4Duration(filePath);
        }else if("mp4".equals(format)){
            result = VideoUtil.getMp4Duration(filePath);
        }

        return result;
    }


    /**
     * 得到文件格式
     * @param path
     * @return
     */
    public static String getVideoFormat(String path){
        return  path.toLowerCase().substring(path.toLowerCase().lastIndexOf(".") + 1);
    }


}


```



```aidl

package com.opensourceteams.modules.java.util.video;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;


import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;

public class AudioUtil {


    /**
     * 获取语音文件播放时长(秒) 支持wav 格式
     * @param filePath
     * @return
     */
    public static Float getDuration(String filePath){
        try{

            File destFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(destFile);
            AudioFormat format = audioInputStream.getFormat();
            long audioFileLength = destFile.length();
            int frameSize = format.getFrameSize();
            float frameRate = format.getFrameRate();
            float durationInSeconds = (audioFileLength / (frameSize * frameRate));
            return durationInSeconds;

        }catch (Exception e){
            e.printStackTrace();
            return 0f;
        }

    }

    /**
     * 获取mp3语音文件播放时长(秒) mp3
     * @param filePath
     * @return
     */
    public static Float getMp3Duration(String filePath){

        try {
            File mp3File = new File(filePath);
            MP3File f = (MP3File) AudioFileIO.read(mp3File);
            MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
            return Float.parseFloat(audioHeader.getTrackLength()+"");
        } catch(Exception e) {
            e.printStackTrace();
            return 0f;
        }
    }


    /**
     * 获取mp3语音文件播放时长(秒)
     * @param mp3File
     * @return
     */
    public static Float getMp3Duration(File mp3File){

        try {
            //File mp3File = new File(filePath);
            MP3File f = (MP3File) AudioFileIO.read(mp3File);
            MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
            return Float.parseFloat(audioHeader.getTrackLength()+"");
        } catch(Exception e) {
            e.printStackTrace();
            return 0f;
        }
    }


    /**
     * 得到pcm文件的毫秒数
     *
     * pcm文件音频时长计算
     * 同图像bmp文件一样，pcm文件保存的是未压缩的音频信息。 16bits 编码是指，每次采样的音频信息用2个字节保存。可以对比下bmp文件用分别用2个字节保存RGB颜色的信息。 16000采样率 是指 1秒钟采样 16000次。常见的音频是44100HZ，即一秒采样44100次。 单声道： 只有一个声道。
     *
     * 根据这些信息，我们可以计算： 1秒的16000采样率音频文件大小是 2*16000 = 32000字节 ，约为32K 1秒的8000采样率音频文件大小是 2*8000 = 16000字节 ，约为 16K
     *
     * 如果已知录音时长，可以根据文件的大小计算采样率是否正常。
     * @param filePath
     * @return
     */
    public static long getPCMDurationMilliSecond(String filePath) {
        File file = new File(filePath);

        //得到多少秒
        long second = file.length() / 32000 ;

        long milliSecond = Math.round((file.length() % 32000)   / 32000.0  * 1000 ) ;

        return second * 1000 + milliSecond;
    }






}


```