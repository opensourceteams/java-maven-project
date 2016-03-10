package com.opensourceteams.modeles.common.笔记.第五天.类加载;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/29  下午7:53
 * 功能描述:
 */

public class ClassLoaderTree {

    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderTree.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
    }
}
