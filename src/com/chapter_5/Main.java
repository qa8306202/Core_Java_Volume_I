package com.chapter_5;

import com.chapter_5._1_inheritance.Employee;
import com.chapter_5._1_inheritance.Manager;

public class Main {
    public static void main(String[] args) {
        Manager[] managers = new Manager[10];
        Employee[] staff = managers;

        // Exception in thread "main" java.lang.ArrayStoreException: com.chapter_5._1_inheritance.Employee
//        staff[0] = new Employee("Harry",50000,1980,12,15);
        staff[0] = new Manager("Harry",50000,1980,12,15);
//        staff[0].setBonus(500); // Employee dont find func setBonus(int)
        managers[0].setBonus(500);
        System.out.println(staff[0].getSalary());
    }
}
