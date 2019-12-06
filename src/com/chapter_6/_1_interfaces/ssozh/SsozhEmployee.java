package com.chapter_6._1_interfaces.ssozh;

public class SsozhEmployee implements ISsozhComparable<SsozhEmployee>{
        private String name;
        private double salary;
        public SsozhEmployee(String name,double salary) {
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

    /**
     *
     * @param other 与其他进行比较工资排序
     * @return
     */
    @Override
        public int ssozhCompareTo(SsozhEmployee other) {
            return Double.compare(salary,other.salary);
        }
}
