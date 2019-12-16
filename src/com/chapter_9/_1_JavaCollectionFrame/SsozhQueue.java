package com.chapter_9._1_JavaCollectionFrame;

import java.util.*;
import java.util.ArrayDeque;

public class SsozhQueue {
    public static void main(String[] args) {
        Queue<Integer> expressLane = new CircularArrayQueue<>(100);
        expressLane.add(100);

    }
}

//    <E> the type of elements held in this queue
class CircularArrayQueue<E>
        extends AbstractQueue<E>
        implements Queue<E>{
    CircularArrayQueue(int capacity){

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}

/**
 * AbstractCollection中toString的写法：
 *  用的是StringBuilder 写的
 *
 *    public String toString() {
 *         Iterator<E> it = iterator();
 *         if (! it.hasNext())
 *             return "[]";
 *
 *         StringBuilder sb = new StringBuilder();
 *         sb.append('[');
 *         for (;;) {  //使用for(;;)等价于while(true)但是比while(true)效率高，对于早期的C语言，两种写法性能会不一样。for语句编译器会优化成一条汇编指令，而while判断则编译器会生成好几条汇编指令。
 *             E e = it.next();
 *             sb.append(e == this ? "(this Collection)" : e); //append(String.valueOf(obj))
 *             if (! it.hasNext())
 *                 return sb.append(']').toString();
 *             sb.append(',').append(' ');
 *         }
 *     }
 */