package com.opensourceteams.modules.common.java.algorithm.bean;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/23  上午5:19
 * 功能描述: zun循原则,前包后不包
 */

public class DownloadBytesBean {

        private int beginIndex;
        private int endIndex;
        private int length;
        private int totalLength;

        private int index;//序号

        public DownloadBytesBean(int beginIndex, int endIndex,int index,int totalLength) {
            this.beginIndex = beginIndex;
            this.endIndex = endIndex;
            this.index = index;
            this.totalLength = totalLength;
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
            return endIndex - beginIndex;
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
        return  "索引" +this.getIndex() +"次下载完成,当前下载量:" +this.getLength() +",总下载量:" +this.totalLength;
    }
}
