package com.chapter_5._2_abstractClasses;

public class PersonTest {
    public static void main(String[] args) {
        Person[] people = new Person[2];

        // fill the people array with Student and Employee objs
        people[0] = new Employee("Harry",50000,1983,10,1);
        people[1] = new Student("Marria","computer science");

        for(Person p : people)
            System.out.println(p.getName()+"."+p.getDescription());
    }
}
