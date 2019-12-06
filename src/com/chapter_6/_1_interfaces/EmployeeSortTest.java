package com.chapter_6._1_interfaces;

import java.lang.reflect.Array;
import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Craker",35000);
        staff[1] = new Employee("Harry Hacker",50000);
        staff[2] = new Employee("Tommy Tester",40000);
        // 判断Employee接口是否实现了Comparable
        if (staff[0] instanceof Comparable)
            Arrays.sort(staff);
        else
            System.out.println("You dont implement Comparable!");

        // print out info about all Employee objs
        for(Employee e: staff){
            System.out.println("name=" + e.getName() + ",salary="+e.getSalary());
        }
    }
}
