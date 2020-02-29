package com.extra_test;

/**
 * return this 表示可以连续调用（chained call） 类似于python的 return self
 */
public class ReturnThis {
    public static void main(String[] args) {
        ReturnThis example = new ReturnThis();
        example.getName("haha").getAge(18);
        System.out.println(example);

    }

    private String dogName;
    private int dogAge;
    public ReturnThis getName(String name){
        dogName = name;
        return this;
    }
    public ReturnThis getAge(int age){
        dogAge = age;
        return this;
    }

    @Override
    public String toString() {
        return "ReturnThis{" +
                "dogName='" + dogName + '\'' +
                ", dogAge=" + dogAge +
                '}';
    }
}
