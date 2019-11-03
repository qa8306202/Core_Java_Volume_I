package com.chapter_5._1_inheritance;

/**
 * This program demonstrate inheritance.
 * @version 1.21 2019-11-03
 * @author Ssozh
 */
public class ManagerTest {
    public static void main(String[] args)
    {
        // construct a Manager obj
        Manager boss =new Manager("Carl Cracker",80000,1987,12,15);
        boss.setBonus(5000);

        Employee[] staff = new Employee[3];

        // fill staff array with Manager and Employee objs
        // this is theorem of replacement.
        // boss is subclass of Employee->Manager,but compiler regard stuff[0] as Employee class.
        // so staff[0].setBonus(5000)->error
        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker",50000,1989,10,1);
        staff[2] = new Employee("Tommy Tester",40000,1990,3,15);

        // print out info about all Employee objs
        for(Employee e: staff)
            System.out.println("name="+e.getName()+",Salary="+e.getSalary());
    }
}
