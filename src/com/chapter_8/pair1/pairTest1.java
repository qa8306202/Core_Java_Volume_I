package com.chapter_8.pair1;

import java.util.Arrays;

public class pairTest1 {
    public static void main(String[] args) {
        String[] words = {"Mary","Har","a","little","lamb"};
        Pair<String> mm =ArrayAlg.minmax(words);
        System.out.println("min=" + mm.getFirst());
        System.out.println("max=" + mm.getSecond());
        // 下面的<String>可以省略,这里的...a 在函数中用a表示，他本质上是一个T[]类型的数组
        String middle = ArrayAlg.<String>getMiddle("Mary","Har","a");
        System.out.println(middle);
//        // 以下这句出错是以为你a会被打包为一个double，两个Integer对象
//        double middle1 = ArrayAlg.getMiddle(3.14,1729,0);
        //修改方法1是把double的输入改成.0的形式，方法二是把double改成Object,让这个泛型T->Object
        double middle1 = ArrayAlg.getMiddle(3.14,120.0,0.0);
//        System.out.println(middle1);
//        Integer[] c = {1,3,4,5};
//        Object[] a = ArrayAlg.testPrint(c,"abv",123,45,6); //[3.14, 0, abc, c]???这个是怎么解释
//        System.out.println(a[0].getClass());
//        System.out.println(a[2].getClass());


    }
}

/**
 * gets the minimum and maximum of an array of strings.
 */
class ArrayAlg{
    public static Pair<String>minmax(String[] a){
        // a ==null 没有在堆里面开辟内存，即相当于没有new，a.length==0表示new了但内容为空
        if(a ==null || a.length==0) return null;
        String min=a[0];
        String max=a[0];
        for(int i=1;i<a.length;i++){
            if(min.compareTo(a[i])>0)min = a[i];
            if(max.compareTo(a[i])<0)max = a[i];
        }
        return new Pair<>(min,max);
    }
    //这里的...是java代码的一部分，它表明这个方法可以接收任意数量的对象（除fmt参数之外）[出自inheritance.txt]
    //下面的<T>表示这是一个泛型方法，其中返回的类型则是T 所以是<T>  T
    public static <T> T getMiddle(T...a){
        System.out.println(Arrays.asList(a));
        //这里返回的a[i]是T类型的，但是如果a是一个Object[]数组，包含int,double则无法转化为double数组。
        return a[a.length/2];
    }
    public static Object[] testPrint(Integer[] a,Object...b){
        System.out.println(Arrays.asList(a));
        return a;

    }
}
