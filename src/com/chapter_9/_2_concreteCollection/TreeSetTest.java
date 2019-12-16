package com.chapter_9._2_concreteCollection;

import java.util.*;

/**
 * TreeSet类实现了接口NavigableSet，而NavigableSet接口是继承的SortedSet接口。
 * TreeSet类继承了父类AbstractSet
 * 根据TreeSet的构造函数发现：他是通过TreeMap实现的。虽然他没有继承TreeMap但是他使用了TreeMap的键，不用值
 * 而TreeMap则实现了接口NavigableSet，而且TreeMap是基于黑红树实现的。该映射根据其键的自然顺序进行排序，或者根据创建映射时提供的Comparator 进行排序，具体取决于使用的构造方法。
 * 这些算法是 Cormen、Leiserson和 Rivest 的 Introduction to Algorithms 中的算法的改编。
 * 注：用transient关键字标记的成员变量不参与序列化过程。
 * 出于性能原因，TreeMap是非同步的（not synchronized），如果需要在多线程环境使用，需要程序员手动同步；或者通过如下方式将TreeMap包装成（wrapped）同步的
 *
 *     // Red-black mechanics 写在地2040行
 *     getEntry 方法是算法的核心。根据key的自然顺序（或者比较器顺序）对二叉查找树进行查找，直到找到满足k.compareTo(p.key) == 0的entry。
 *          todo：有时间搞清楚getEntry的做法
 *     put(K key, V value)方法是将指定的key, value对添加到map里。该方法首先会对map做一次查找，看是否包含该元组，如果已经包含则直接返回
 *     get(Object key)方法根据指定的key值返回对应的value，该方法调用了getEntry(Object key)得到相应的entry，然后返回entry.value。
 */
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Bob",1234));
        parts.add(new Item("Amy",4562));
        parts.add(new Item("Modem",9912));
        System.out.println(parts);

        NavigableSet<Item> sortByDescription = new TreeSet<>(
            Comparator.comparing(Item::getDescription)); //这个双引号的意义表示note3.4方法引用,相当于一个lambda表达式。
        // 对树中的元素的排序方法

    //放入即自动排序好了。
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);

    }
}
class Item implements Comparable<Item> {
    private String description;
    private int partNumber;

    public Item(String aDescription, int aPartNumber) {
        description = aDescription;
        partNumber = aPartNumber;
    }

    // get method
    public int getPartNumber() {
        return partNumber;
    }

    public String getDescription() {
        return description;
    }

    //toString
    @Override
    public String toString() {
        return "[descriptor=" + description + ",partNumber=" + partNumber + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(description,partNumber);
    }

    @Override
    public int compareTo(Item other) {
        int diff = Integer.compare(partNumber,other.partNumber);
        return diff != 0 ? diff : description.compareTo(other.description);
    }
}

