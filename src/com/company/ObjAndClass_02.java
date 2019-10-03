package com.company;

import java.util.stream.StreamSupport;

public class ObjAndClass_02 {
    public static void main(String[] args) {
        p_4_3();

    }
    private static void p_4_3(){
        Employee_01[] staff = new Employee_01[3];
        staff[0] = new Employee_01("Tom",40000);
        staff[1] = new Employee_01("Dick",60000);
        staff[2] = new Employee_01("Harry",65000);

        // print out info about all staffs
        for(Employee_01 e:staff){
            e.setId();
            System.out.println("name="+e.getName()+",id="+e.getId()+",salary="+e.getSalary());
        }

        int n =Employee_01.getNextId();
        System.out.println("Next available id="+n);
    }
}

class Employee_01{
    // 静态域
    private static int nextId = 1;
    // 实例域
    private String name;
    private double salary;
    private int id;
    // 构造方法
    public Employee_01(String n,double s){
        this.name = n;
        this.salary = s;
    }
    // 访问器

    public double getSalary() {
        return this.salary;
    }
    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.id;
    }
    // 更改器
    public void setId(){
        this.id = nextId;  // set id to next available id
        nextId++;
    }
    // 静态方法
    public static int getNextId(){
        return nextId;// nextId是静态域，所以这个地方是没有this的。
    }

}
