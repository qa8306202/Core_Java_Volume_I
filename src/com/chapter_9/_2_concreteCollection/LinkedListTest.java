package com.chapter_9._2_concreteCollection;

import java.util.*;

public class LinkedListTest {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>(); //创建一个链表数组
        List<String> c = new ArrayList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        // merge the words from b into a
        // be attention:interface Iterator not ListIterator.
        ListIterator<String> aIter = a.listIterator(); //ListIterator是一个接口，他包含在接口List里面的，而LinkedList类实现了接口List
        Iterator<String> bIter = b.iterator();  //Iterator也是一个接口，他也包含在接口List里面。
        /*
        Iterator和ListIterator主要区别在以下方面：

            1. ListIterator有add()方法，可以向List中添加对象，而Iterator不能

            2. ListIterator和Iterator都有hasNext()和next()方法，可以实现顺序向后遍历，但是ListIterator有hasPrevious()和previous()方法，可以实现逆向（顺序向前）遍历。Iterator就不可以。

            3. ListIterator可以定位当前的索引位置，nextIndex()和previousIndex()可以实现。Iterator没有此功能。

            4. 都可实现删除对象，但是ListIterator可以实现对象的修改，set()方法可以实现。Iterator仅能遍历，不能修改。
         */

        while (bIter.hasNext()){
            if(aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }
        System.out.println(show(a));

        // remove every second word from b
        bIter = b.iterator();
        while (bIter.hasNext()){
            bIter.next(); // skip one element
            if(bIter.hasNext()){
                bIter.next(); // skip next element
                bIter.remove();
            }
        }
        System.out.println(b);

        // bulk operation: remove all words in b from a
        a.removeAll(b);
        System.out.println(a);
    }
    public static String show(List a){
        ListIterator<String> it = a.listIterator();
        if(!it.hasNext()) return "[]";


        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (it.hasNext()){
            String e = it.next();
            sb.append(e);   //append(String.valueOf(obj))
            sb.append(',').append(' ');
        }
        sb.append(']');
        return sb.toString();


    }
}

