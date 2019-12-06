package com.chapter_6._2_interfaceInstance;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable{
    private String name;
    private double salary;
    private Date hireDay;

    // 初始化
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
        this.hireDay = new Date();
    }

    // 实现clone接口
    // 1. throwsCloneNotSupportExcepiton,防止对象没有实现Cloneable接口
    // 2. 将protected 改为public
    @Override
    public Employee clone() throws CloneNotSupportedException {
        //先调用浅拷贝，即Object.clone
        Employee cloned = (Employee) super.clone();
        //克隆可变域（mutable fields）
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
    }

    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year,month - 1 ,day).getTime();
        hireDay.setTime(newHireDay.getTime());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void raiseSalary(double byPercent){
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    @Override
    public String toString() {
        return "Employee[name=" + name + ",salary=" + salary + ",hireDay="+ hireDay +"]";
    }
}
