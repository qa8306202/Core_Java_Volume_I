package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
注意：在这个源文件中包含了两个类。Employee 类和 ObjAndClass_01两个类。
如果是将两个类分成两个文件，这样组织文件有两种编译源程序的方法。一种是使用通配符调用Java编译器,或者直接键入下列命令：
    javac ObjAndClass_01.java
这种方式虽然没有显式地编译Employee.java，然而，当java编译器发现ObjAndClass.java使用了Employee.class的文件。如果没有这个文件，
就会自动搜索Employee.java，然后对他进行编译。
我们可以认为Java编译器内置了“make"功能。
 */

public class ObjAndClass_01 {
    public static void main(String[] args) {
        int TEST = 2;
        if (TEST == 0) test1();
        else if (TEST == 1) p_4_1();
        else if (TEST ==2)p_4_2();

    }
    private static void test1() {
        // 这里of方法里面包含了new
        LocalDate newYearsEve = LocalDate.of(1999, 12, 31);
        // 这里plusDays方法并没有改变原来的对象newYearsEve，而是重新生成了一个新的对象，并把这个新对象赋给aThousandDayLater
        // 所以我们说plusDay方法没有更改调用这个方法的对象，类似于String类的toUpperCase一样。
        // 这个方法就是访问器方法————plusDay
        LocalDate aThousandDayLater = newYearsEve.plusDays(1000);
        // 更改器方法：Gregorian
        GregorianCalendar someDay = new GregorianCalendar(1999, 11, 31);
        someDay.add(Calendar.DAY_OF_MONTH, 1000);
        int year = someDay.get(Calendar.YEAR);  // 2002
        int month = someDay.get(Calendar.MONTH) + 1;  // 9
        int day = someDay.get(Calendar.DAY_OF_MONTH); //26
        System.out.println(day);
    }

    private static void p_4_1() {
        LocalDate date = LocalDate.now();
        //  获取当前的日和月
        int month = date.getMonthValue(); // 和getMonth不一样, month =10
//        System.out.println(month);
        int today = date.getDayOfMonth(); // 2
//        System.out.println(today);

        date = date.minusDays(today - 1);  // minusDays是指负几天，就是说对当前的日期减去参数个天数。比如今天是15号，则这个月初就应该是15-14
//        System.out.println(date);  // class : LocalDate 2019-10-01
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue(); // 1 = Monday,...7=Sunday
        System.out.println(value);  // 2 = Tue

        // 打印表头
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }
        // 打印主体
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());  // 打印这一天是几号
            if (date.getDayOfMonth() == today)
                System.out.print("*");
            else
                System.out.print(" ");
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1)  // 如果是周一
                System.out.println("");
        }

    }

    private static void p_4_2() {
        //在java中对象都是在堆中创建的，先构造了一个Employee数字，并填入了三个雇员对象
        Employee[] staff = new  Employee[3];
        // 创建数组用new，创建单个实例还要用new
        staff[0] = new Employee("Carl Cracker",75000,1987,12,15);
        staff[1] = new Employee("Harry Hacker",50000,1989,10,1);
        staff[2] = new Employee("Tony Tester",40000,1990,3,15);

        // 涨工资。每人5%
        for(Employee e: staff){
            e.raiseSalary(5);
        }

        // 打印出每个人的信息
        for(Employee e:staff){
            System.out.println("name="+e.getName()+",Salary="+e.getSalary()+",hireDay="+e.getHireDay());
        }
    }
}

/*
剖析Employee类：
    1.构造器：构造器与类同名。相当于python中的__init__,在构造Employee类的对象时，构造器会运行，以便将实力域初始化为所希望的状态。构造器与其他的方法不同
之处在于，构造器总是便随着new操作符的执行被被调用，正因为是new出来的，所以java对象都是在堆中构造的。另外构造器是没有返回值的。
    2.在Java中，所有的方法都必须在类的内部定义，但并不表示它们是内联（inline）方法，（C++中类的内部定义方法会自动成为inline方法）
是否将某个方法设置为内联方法是Java虚拟机的任务。
    3.封装的优点
 */
class Employee {
    // 实力域定义私有变量private
    private String name;
    private double salary;
    private LocalDate hireDay;

    // 构造方法和类名同名。相当于python中的__init__,
    // 但是构造方法中的局部变量名是不能和实力域重名的。this.xxx == xxx 这里的this表示隐式参数，相当于python中的self
    public Employee(String n, double s, int year, int month, int day) {
        this.name = n;
        salary = s;
        this.hireDay = LocalDate.of(year, month, day);
    }

    // 三个public方法用于获取实例域，public方法就是再其他的类中也可以调用的方法，
    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public LocalDate getHireDay() {
        return this.hireDay; //如果这个hireDay是Date类，则不能这么编写返回引用可变对象的访问器方法，因为如果使用Date类，
        // 其中有一个更改器方法setTime,可以设置毫秒数，Date对象就是可变的。这一点破坏了封装性。
        // 如果需要返回一个可变对象的引用，应该先对他进行克隆clone。
        // LocalDate类是没更改器方法，他的对象不属于可变对象。
    }


    // 加薪也是要在其他类中使用，因此需要public
    // 注意这里的显式变量也不要和实力域重复
    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }
}

