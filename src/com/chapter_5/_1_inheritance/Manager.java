package com.chapter_5._1_inheritance;

public class Manager extends Employee
{
    private double bonus;

    /**
     * @param name the employee's name
     * @param salary the salary
     * @param year the hire year
     * @param month the hire month
     * @param day the hire day
     */
    public Manager(String name, double salary, int year, int month, int day)
    {
        super(name,salary,year,month,day); // inheritance
        this.bonus = 0;
    }

    public double getSalary()
    {
        double baseSalary = super.getSalary(); // must use super, otherwise this is a recurise
        return  baseSalary + this.bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
