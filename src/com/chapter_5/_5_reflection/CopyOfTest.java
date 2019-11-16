package com.chapter_5._5_reflection;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This program demonstrates the use of reflection for manipulating arrays.
 * @author Ssozh
 */

public class CopyOfTest {
    public static void main(String[] args) {
        int[] a = {1,2,3}; //int数组初始化可以简写成这样！
        a = (int[]) goodCopyOf(a,10);
        System.out.println(Arrays.toString(a));

        String[] b = {"abc","cde","edf"}; //必须是双引号，属于都可以使用{}括起来初始化
        b = (String[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(b));

        System.out.println("The following call will generate an exception.");
        b =(String[]) badCopyOf(b,10);  //  java.lang.ClassCastException

    }

    /**
     *  This method attempt to grow an array by allocating a new array and copying all elements
     * @param a the array to grow.This can be an object array or a primitive(primitive means "int, double, long, short, char, byte, float, boolean")
     * @param newLength the new length
     * @return a larger array that contains all elements of a. However, the returned array has type Object[], not the same type as a
     */
    public static Object[] badCopyOf(Object[] a, int newLength) // not useful
    {
        Object[] newArray = new Object[newLength];
        System.arraycopy(a,0,newArray,0,Math.min(a.length,newLength));  // copy a  array from A to B, (src, srcPos(源数组的拷贝起始位置),dest,destPost,长度)
        return newArray;
    }

    /**
     * This method grows a array by allocating a new array of the same type and copying all elements.
     * @param a the array to graw. This can be an object array or primitive
     * @param newLength  the new length
     * @return a large array that contains all elements of a
     */
    public static Object goodCopyOf(Object a, int newLength)
    {
        Logger log = Logger.getLogger("lavasoft");
        log.setLevel(Level.INFO);
        Class c1 = a.getClass();  // [I 表示int数组！ [Ljava.lang.String表示String数组
        log.info("Class c1 = " + c1);
//        Logger.global.info("Class c1 = " + c1);  // warning 已过时7
        if (!c1.isArray()) return null;
        Class componentType = c1.getComponentType();  //这个是直接返回int 很奇怪啊！
        log.info("componentType = " + componentType);
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType,newLength);
        System.arraycopy(a,0,newArray,0,Math.min(newLength,length));
        return newArray;
    }

}

