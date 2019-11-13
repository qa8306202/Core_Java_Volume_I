package com.chapter_5._3_equals;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args)
    {
        // fill the staff array list with three Employee objects
        ArrayList<Employee> staff = new ArrayList<>();

        staff.add(new Employee("Carl Cracker",80000,1987,12,15));
        staff.add(new Employee("Harry Hacker",50000,1989,10,1));
        staff.add(new Employee("Tommy Tester",40000,1990,3,15));

        // raise everyone's salary by 5%
        for (Employee e:staff)
        {
            e.raiseSalary(5);
        }

        // print out infor about all Employee ojb
        for (Employee e : staff)
        {
            System.out.println(e);
        }
    }
}
