package com.chapter_6._4_innClass.ssozh;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 深入学习反射，反射机制的默认行为受限于java的访问机制.
 *      f.setAccessible(true);为反射对象设置可访问标志。
 *      flag为true表明屏蔽java语言的访问检查，使得对象的私有属性也可以被查询和设置。
 *      class.getFields只能获得全部public字段，这里应该使用getDeclaredFields()获取某个类的自身的所有字段，不包括父类的字段。
 *      所以 如果想获得全部 应该加declared！！
 *
 * 搞懂编译器反射内部类的过程
 * 在内部类被翻译成$符号，Unix可能需要添加"\$" ， Windows下不需要添加  "\"
 * 这里的输入应该是：com.chapter_6._4_innClass.ssozh.TalkingClock$TimerPrinter
 * 这里，我把arg和Scanner都注释掉了。可以直接运行
 *
 * 注意：这里的内部类是由访问权限设置的，但是反射内部类的唯一方法是使用$，与访问权限无关！
 */

public class ReflectionInnClassTest {

    public static void main(String[] args) {
        // read class name from command line args or user input
//        String name;
//        if (args.length > 0) name = args[0];
//        else {
//            Scanner in = new Scanner(System.in);
//            System.out.println("Enter class name(e.g. java.util.Date):");
//            name = in.next();
//        }
        // 多一个  final com.chapter_6._4_innClass.ssozh.TalkingClock this$0;
        String name = "com.chapter_6._4_innClass.ssozh.TalkingClock";

        System.out.println();
        try {
            // print class name and superclass name (if !=Object)
            Class c1 = Class.forName(name);
            Class superc1 = c1.getSuperclass();
            // 判断是否有修饰符，如果有则输出，
            String modifiers = Modifier.toString(c1.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            // 输出class 和 全限定名
            System.out.print("class " + name);
            // 判断是否继承超类，如果是继承某一个超类且不是Object 则输出继承部分
            if (superc1 != null && superc1 != Object.class)
                System.out.print(" extend " + superc1.getName());

            // print constructor method field
            System.out.print("\n{\n");
            // 输出类别c1的构造器
            printConstructors(c1);
            System.out.println();
            //输出类c1的方法
            printMethods(c1);
            System.out.println();
            //输出类c1的域
            printFields(c1);
            System.out.println("}");

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * Prints all constructors of a class
     *
     * @param c1 a class
     */
    public static void printConstructors(Class c1) {
        Constructor[] constructors = c1.getDeclaredConstructors();  // 获得全部构造器（可能有多个）
        for (Constructor c : constructors) {
            String name = c.getName();  // 获取构造器的名字
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers());  // 获取这个构造器的全部修饰符（可能有多个,但是可以一次性打印,.因为类型是String）
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name + " (");

            //打印参数类型
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Prints all methods of a class
     *
     * @param c1 a class
     */
    public static void printMethods(Class c1) {
        Method[] methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            String name = method.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(method.getModifiers()); // 获取methods的修饰符
            // should be public java.util.Date (java.lang.String);
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name + "(");
            // print para type
            Class[] paramTypes = method.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * print all fields of a class
     *
     * @param c1 a class
     */
    public static void printFields(Class c1) {
        Field[] fileds = c1.getDeclaredFields();  //这个方法是获得全部public字段！！！！
        for (Field field : fileds) {

            field.setAccessible(true);
            // 获取域名
            String name = field.getName();
            //获取域名类型
            Class type = field.getType();
            System.out.print("  ");
            // 获取域名对应的修饰符（int型），并转为String
            String modifiers = Modifier.toString(field.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}

