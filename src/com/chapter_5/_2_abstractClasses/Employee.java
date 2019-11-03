package com.chapter_5._2_abstractClasses;

import java.time.LocalDate;
import java.time.Month;

public class Employee extends Person
{
    private double salary;
    private LocalDate hireDay;

    public Employee(String name,double salary,int year, int month, int day)
    {
        super(name);  // init with baseclass this.name = name
        this.salary = salary;
        this.hireDay = LocalDate.of(year,month,day);
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public double getSalary() {
        return salary;
    }

    @Override  // can be omit
    public String getDescription() {
        return String.format("an employee with salary of $%.2f",this.salary);
    }

    public void raiseSalary(double byPercent)
    {
        double raise = this.salary * byPercent / 100;
        this.salary+=raise;
    }

}
