package com.chapter_5._2_abstractClasses;

public abstract class Person {
    public abstract String getDescription();
    private String name;

    public Person(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
}
