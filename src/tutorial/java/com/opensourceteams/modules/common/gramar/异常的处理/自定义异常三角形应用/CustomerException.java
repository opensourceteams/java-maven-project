package com.opensourceteams.modules.common.gramar.异常的处理.自定义异常三角形应用;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/2  下午2:29
 * 功能描述:
 */

public class CustomerException extends Exception{

    private  String info;

    public CustomerException(){}

    public CustomerException( String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
