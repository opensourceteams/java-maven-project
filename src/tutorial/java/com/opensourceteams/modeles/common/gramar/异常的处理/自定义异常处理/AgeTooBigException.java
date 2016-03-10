package com.opensourceteams.modeles.common.gramar.异常的处理.自定义异常处理;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/2  上午11:59
 * 功能描述:
 */

public class AgeTooBigException extends Exception {

    private String into;

    public AgeTooBigException(){}

    public AgeTooBigException( String into) {
        this.into = into;
    }

    public String getInto() {
        return into;
    }

    public void setInto(String into) {
        this.into = into;
    }
}
