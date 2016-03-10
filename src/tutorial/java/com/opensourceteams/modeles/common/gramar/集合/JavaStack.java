package com.opensourceteams.modeles.common.gramar.集合;

import java.util.Enumeration;
import java.util.Stack;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/6  下午12:12
 * 功能描述:
 */

public class JavaStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.add("d");
        stack.add("f");
        stack.add("g");
        stack.addElement("h");
        stack.addElement("i");

        System.out.println(stack);
        Enumeration<String> e =  stack.elements();

        while (e.hasMoreElements()){
            System.out.println(e.nextElement());
        }

        System.out.println("后进选出");
        while(!stack.empty()){
            System.out.println(stack.pop());

        }



    }
}
