package com.chapter_5._1_inheritance;

import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Object
{
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
}
