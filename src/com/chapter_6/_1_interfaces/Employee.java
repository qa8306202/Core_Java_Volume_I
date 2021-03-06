package com.chapter_6._1_interfaces;

public class Employee implements Comparable<Employee> {
    private String name;
    private double salary;
    public Employee(String name,double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void  raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary +=raise;
    }

    public int compareTo(Employee other) {
        return Double.compare(salary,other.salary);
    }
}
