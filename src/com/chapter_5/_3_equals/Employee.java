package com.chapter_5._3_equals;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    // constructor
    public Employee(String name, double salary, int year, int month, int day)
    {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    // first inheritance obj equals
    // class Objects is different with Object
    // Objects.equals will return true ,when both a and b is null.
    @Override
    public boolean equals(Object obj)
    {
        // a quick test to see if the objects are identical
        if (this == obj) return true;
        // must return false if the explicit parameter is null
        if (obj == null) return false;
        // if the classes do not match, they cannot be equal
        if (getClass() != obj.getClass())  return false;
        // now we know obj is non-null Employee
        Employee other = (Employee) obj;

        // test whether the fields have identical values
        return Objects.equals(name,other.name)
                && salary == other.salary
                && Objects.equals(hireDay,other.hireDay);// different with hireDay.equals(obj.hireDay)
    }

    // override Object and using Objects func hash
    @Override
    public int hashCode() {
        return Objects.hash(name,salary,hireDay);
    }

    @Override
    public String toString()
    {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }

}
