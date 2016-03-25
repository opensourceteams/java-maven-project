package com.opensourceteams.modules.common.gramar.集合.向量vector.n_1_向量的基本操作;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/8  上午5:23
 * 功能描述:
 */

import java.util.*;

public class VectorDemo {

    public static void main(String args[]) {
        // initialCapacity size is 3, capacityIncrement is 2  int initialCapacity,
        Vector v = new Vector(3, 2);
        System.out.println("Initial size: " + v.size());
        System.out.println("Initial capacity: " +
                v.capacity());
        v.addElement(new Integer(1));
        v.addElement(new Integer(2));
        v.addElement(new Integer(3));
        v.addElement(new Integer(4));
        System.out.println("Capacity after four additions: " +
                v.capacity());

        v.addElement(new Double(5.45));
        System.out.println("Current capacity: " +
                v.capacity());
        v.addElement(new Double(6.08));
        v.addElement(new Integer(7));
        System.out.println("Current capacity: " +
                v.capacity());
        v.addElement(new Float(9.4));
        v.addElement(new Integer(10));
        System.out.println("Current capacity: " +
                v.capacity());
        v.addElement(new Integer(11));
        v.addElement(new Integer(12));
        System.out.println("First element: " +
                (Integer)v.firstElement());
        System.out.println("Last element: " +
                (Integer)v.lastElement());
        if(v.contains(new Integer(3)))
            System.out.println("Vector contains 3.");
        // enumerate the elements in the vector.
        Enumeration vEnum = v.elements();
        System.out.println("\nElements in vector:");
        while(vEnum.hasMoreElements())
            System.out.print(vEnum.nextElement() + " ");
        System.out.println();
    }
}