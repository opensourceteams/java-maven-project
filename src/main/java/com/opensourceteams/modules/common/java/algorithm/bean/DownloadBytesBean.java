package com.opensourceteams.modules.common.java.algorithm.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/23  上午5:19
 * 功能描述: zun循原则,前包后不包
 */

public class DownloadBytesBean implements  Comparable<DownloadBytesBean>{



        private int beginIndex;
        private int endIndex;
        private int length; //本次下载量
        private int totalLength;

        private int index;//序号

        private int amount;//合计,已下载量

        String urlStr; //下载url
        String saveFilePath; //本地保存地址

        boolean isOver; //是否已完成该线程


        List<Integer[]> rangList = new ArrayList<Integer[]>(); //断点续传使用

        public DownloadBytesBean(){

        }

        public DownloadBytesBean(int beginIndex, int endIndex,int index,int totalLength,String urlStr,String saveFilePath) {
            this.beginIndex = beginIndex;
            this.endIndex = endIndex;
            this.index = index;
            this.totalLength = totalLength;
            this.urlStr = urlStr;
            this.saveFilePath = saveFilePath;
        }

        public int getBeginIndex() {
            return beginIndex;
        }

        public void setBeginIndex(int beginIndex) {
            this.beginIndex = beginIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
        }

        public int getLength() {

           return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getTotalLength() {
            return totalLength;
        }

        public void setTotalLength(int totalLength) {
            this.totalLength = totalLength;
        }

        @Override
        public String toString() {
            return  "索引" +this.getIndex() +"次下载完成,当前线程下载量:" +(this.getEndIndex() - this.getBeginIndex())/1024 +"(KB)  -> " + (this.getEndIndex() - this.getBeginIndex()) /1024/1024 + "(MB)" +
                    ",所有线程总下载量:" +this.totalLength/1024+"(KB) -> " +this.totalLength/1024/1024 +"(MB)" +
                    ",当前线程总下载量:" +this.amount/1024+"(KB) -> " +this.amount/1024/1024 +"(MB)";
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getUrlStr() {
            return urlStr;
        }

        public void setUrlStr(String urlStr) {
            this.urlStr = urlStr;
        }

        public String getSaveFilePath() {
            return saveFilePath;
        }

        public void setSaveFilePath(String saveFilePath) {
            this.saveFilePath = saveFilePath;
        }

        public boolean isOver() {
            return isOver;
        }

        public void setOver(boolean over) {
            isOver = over;
        }

        public int compareTo(DownloadBytesBean o) {
            if(o == null && this == null){
                return  0;
            }else if ( o == null ){
                return  1;
            }else if (this == null){
                return -1;
            }else{
                return  beginIndex - o.beginIndex;
            }
        }


        public List<Integer[]> getRangList() {
            return rangList;
        }

        public void setRangList(List<Integer[]> rangList) {
            this.rangList = rangList;
        }
}
