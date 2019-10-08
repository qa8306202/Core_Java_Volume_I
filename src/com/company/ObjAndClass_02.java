package com.company;

import java.util.Random;
import java.util.stream.StreamSupport;


public class ObjAndClass_02
{
    public static void main(String[] args)
    {
        //p_4_3();
        //func_param();
        //p_4_4();
        p_4_5();


    }

    private static void p_4_3()
    {
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

    // 方法参数中：基本数据类型的参数x 和对象引用作为参数的区别y
    private static void tripleSalary(double x,Employee y)
    {
        x = x*3;  //
        y.raiseSalary(200);
    }

    // 4.5节方法参数,想要同时给基本数据类型的和引用提升三倍。对staff[0]使用基本数据类型，staff[1]使用类引用
    // 显然，salary传入，不改变薪资，staff[1]传入则改变。
    private static void func_param()
    {
        Employee[] staff = new Employee[2];
        staff[0] = new Employee("Carl Cracker",50000,1987,12,15);
        staff[1] = new Employee("Harry Hacker",50000,1989,10,1);
        double salary = staff[0].getSalary();
        System.out.println("提升前Carl的薪水："+salary+"\n提升前Harry的薪水"+staff[1].getSalary());
        tripleSalary(salary,staff[1]);
        System.out.println("提升后Carl的薪水："+salary+"\n提升后Harry的薪水"+staff[1].getSalary());
    }

    // ParamTest
    private static void p_4_4()
    {
        /*
         * Test 3: Methods cannot attach new objects to object parameters
         */
        System.out.println("Testing swap:");
        Employee a = new Employee("Alice",70000,1994,10,12);
        Employee b = new Employee("Bob",60000,1984,10,12);
        System.out.println("Before:a="+a.getSalary());
        System.out.println("Before:b="+b.getSalary());
        swap(a,b);
        System.out.println("After:a="+a.getSalary());
        System.out.println("After:b="+b.getSalary());
    }
    private static void swap(Employee x, Employee y)
    {
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("End of Method:x="+x.getName());  // Bob, changed
        System.out.println("End of Method:y="+y.getName());  // Alice, changed
    }

    //
    private static void p_4_5()
    {
        //fill the staff array with three Employee objects
        Employee_02[] staff = new Employee_02[3];

        staff[0] = new Employee_02("Harry",40000);
        staff[1] = new Employee_02(60000);
        staff[2] = new Employee_02();

        // print out info about all Employee_02 objects
        for(Employee_02 e : staff)
        {
            System.out.println("name="+e.getName()+", id="+e.getId()+", salary="+e.getSalary());
        }


    }
}

class Employee_01
{
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

class Employee_02
{
    // static field(class field)
    private static int nextId;

    // instance field
    private int id;
    private String name = ""; // instance filed initialization
    private double salary;

    // static initialization block
    // the key word static must be here,otherwise the nextId will changed every time when create obj
    static
    {
        Random generator = new Random();
        // set nextId to a random number between 0 and 9999
        nextId = generator.nextInt(9999);
    }

    // object initialization block
    //每次创建实例的时候 id都是改变的，所以这里不是static
    {
        this.id = nextId;
        nextId++;
    }

    //three overloaded constructors
    public Employee_02(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    public Employee_02(double salary)
    {
        // calls the employee_02(String, double) constructor
        this("Employee #"+nextId,salary);
    }

    // the default constructor
    public Employee_02()
    {
        // name initialized to  ""
        // salary not explicitly set -- initialized to 0
        // id initialized in initialization field
    }

    public double getSalary() {
        return this.salary;
    }
    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.id;
    }

}