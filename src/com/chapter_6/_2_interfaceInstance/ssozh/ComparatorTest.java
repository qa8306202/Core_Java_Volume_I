package com.chapter_6._2_interfaceInstance.ssozh;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 这个类是用于搞清楚Arrays.sort使用Comparable接口和Comparator接口的区别
 *  1.comparable将未知类的实例变为comparable接口变量来边界，一个实现了comparable的类一定可以调用Arrays.sort。
 *  2.但是对于已经实现了comparable接口的类如果需要另外一种比较方法，这个时候应该使用comparator接口
 *  3.首先写comparator接口的实现类，然后在Arrays.sort(比较对象数组，new 实现类) 即可按照你想要的比较方法来比较
 *  4. 其本质是改变了
 *
 */
public class ComparatorTest {
    public static void main(String[] args) {
        String[] friends = {"peter","Paul","Mary"};
        Arrays.sort(friends,new LengthComparator()); //尽管LengthComparator对象没有状态，但是还是要实例化,因为compare不是一个静态方法。

        for(String f:friends)
            System.out.println(f);

    }
}

/**
 * 这个类是对Comparator接口的实现，覆盖了方法compare 由String中
 */
class LengthComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}