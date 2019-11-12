package com.chapter_5._3_equals;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class EqualsTest {
    public static void main(String[] args) {
        Employee alice1 = new Employee("Alice Adams",75000,1987,12,15);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("Alice Adams",75000,1987,12,15);
        Employee bob = new Employee("Bob Brandson",50000,1989,10,1);

        // '==' means refer to the same obj,in other word, the pointer point the same address
        System.out.println("alice1 == alice2: " + (alice1 == alice2));

        System.out.println("alice1 == alice3: " + (alice1 == alice3));
        // equals definition is they have the same Class and their attr is the same
        System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));

        System.out.println("alice1.equals(bob): " + alice1.equals(bob));

        // System.out.println(bob)  == Sysem.out.println(bob.toString)
        System.out.println("bob.toString(): " + bob);

        Manager carl = new Manager("Carl Cracker",80000,1987,12,15);
        Manager boss = new Manager("Carl Cracker",80000,1987,12,15);
        boss.setBonus(5000);
        System.out.println("boss.toString():" + boss);
        // they are different in bonus
        System.out.println("carl.equals(boss): " + carl.equals(boss));
        // the same hashCode() of alice1 and alice3 ->-808853550,because override hashCode, which is hash attr rather obj address.
        System.out.println("alice1.hashCode(): " + alice1.hashCode());
        System.out.println("alice2.hashCode(): " + alice2.hashCode());
        System.out.println("alice3.hashCode(): " + alice3.hashCode());
        // the different hashCode()if bob
        System.out.println("bob.hashCode(): " + bob.hashCode());
        System.out.println("carl.toString():" + carl);

//        alice3.raiseSalary(10);
//        System.out.println("alice3: "+ alice3);
//        System.out.println("alice1: "+ alice1);

//        int[] nums = {2,3,4,5,6,7}; // 这里使用的是{} 不是[]
//        System.out.println(nums);  //  [I@6d78f375  , 其中 [I 表示int
//        String trans = Arrays.toString(nums);
//        System.out.println(trans);  //   [2, 3, 4, 5, 6, 7]




    }
}
