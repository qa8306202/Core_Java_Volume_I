package com.chapter_5._3_equals;


import java.util.function.DoublePredicate;

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

    @Override
    public boolean equals(Object otherObject)
    {
        // first judge otherObject is equals to Employee
        if (!super.equals(otherObject)) return false;
        // cast otherObject to Manager class
         Manager other = (Manager) otherObject;
         // super.equals checked that this and other belong to the same class
        return bonus == other.bonus;
    }

    public int hashCode()
    {
        return super.hashCode() + 17 * new Double(bonus).hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + "[bonus=" + bonus + "]";

    }
}
