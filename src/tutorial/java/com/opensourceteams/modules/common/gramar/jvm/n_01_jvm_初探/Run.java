package com.opensourceteams.modules.common.gramar.jvm.n_01_jvm_初探;

/**
 * 日期: 2016-03-28  15:07
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Run {

    public static void main(String[] args) {

        try {
            Class.forName("com.opensourceteams.modules.common.gramar.jvm.n_01_jvm_初探.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
