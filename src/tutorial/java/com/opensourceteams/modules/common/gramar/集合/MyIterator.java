package com.opensourceteams.modules.common.gramar.集合;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/6  下午12:19
 * 功能描述:
 */

public class MyIterator {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("a");
        linkedList.add("subRecursionListFiles");
        linkedList.add("c");
        linkedList.addFirst("aa");
        linkedList.addLast("d");

        Iterator<String> iterator =  linkedList.iterator();
        while (iterator.hasNext()){

            System.out.println(iterator.next());
        }
    }
}
