package com.opensourceteams.modules.common.gramar.异常的处理.运行时异常;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/2  上午11:59
 * 功能描述:
 */

public class AgeTooSmallException extends Exception {

    private String into;

    public AgeTooSmallException(){}

    public AgeTooSmallException( String into) {
        this.into = into;
    }

    public String getInto() {
        return into;
    }

    public void setInto(String into) {
        this.into = into;
    }
}
