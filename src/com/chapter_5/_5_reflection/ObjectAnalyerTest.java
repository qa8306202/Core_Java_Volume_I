package com.chapter_5._5_reflection;

import java.util.ArrayList;

public class ObjectAnalyerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i=1;i<=5;i++)
            squares.add(i * i);
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
