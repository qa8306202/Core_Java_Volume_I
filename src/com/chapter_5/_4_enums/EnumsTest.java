package com.chapter_5._4_enums;

import java.util.Scanner;

public class EnumsTest {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a Size:(SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input); //valueOf获取指定名字，给定类的枚举常量。
        System.out.println("size=" + size);
        System.out.println("abbr=" +size.getAbbr());
        if (size == Size.EXTRA_LARGE)
            System.out.println("Good jog--you paid attention to the _.");


    }


    public enum  Size // 这个声明定义了一个类，他刚好有4个实例分别是small... ，这个类的私有域是abbr，构造函数是私有的。还有一个获取参数的方法。
    {
        SMALL("s"), MEDIUM("M"), LARGE("L"),EXTRA_LARGE("XL");
        private  String abbr;
        private Size(String abbr) {this.abbr = abbr;}  //这个构造器是私有的！！！不能是公有的！实际上“枚举”的每一个常量都是创建的自身，只是 枚举 自动简化了。
        public String getAbbr() {return abbr;}
    }
}
