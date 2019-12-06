package com.chapter_6._2_interfaceInstance;

/**
 * 这个例子的重点是告诉我的Employee 类中的Date类的对象是可变对象，就是有更改器方法的类的实例对象
 * final一般修饰不可变的类，例如String。而对于StringBuilder属于可变的类，如果使用final会造成混乱。
 * Employee类中有一个更改器setHireDay，该方法会改变hireDay域的状态。这个更改器不该影响原来的对象，因此需要深拷贝
 *
 * 判断是否需要深拷贝：
 *   1.该类的域是否全部为基本类型。
 *   2.如果存在非基本类型，是否需要对该域设置更改器，如果需要更改器，则需要对这个域进行深拷贝。
 *
 * 深拷贝的两种方法：
 * 1.在类中实现Cloneable接口
 * 2.采用串行化特性，实现Serializable接口，然后把对象（实际上只是对象的一个拷贝）写到一个流里，再从流里读回来，便可以重建对象。
 */
public class CloneTest {
    public static void main(String[] args) {
        try {
            Employee original = new Employee("John Q. Public",50000);
            original.setHireDay(2000,1,1);
            Employee copy = original.clone(); //这个地方必须加 catch cloneNotSupportException
            copy.raiseSalary(10);
            copy.setHireDay(2002,12,13);
            System.out.printf("orginal="+original +"\n");
            System.out.println("copy="+copy);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
