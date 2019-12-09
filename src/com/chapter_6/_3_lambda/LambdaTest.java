package com.chapter_6._3_lambda;


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Date;
import javax.swing.Timer;


public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        // 这种是打印不出来的，打印数组的方法是通过Arrays.toString打印。
        // System.out.println(planets);

        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted by length:");
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(1000, event ->
        {
            System.out.println("The time is" + new Date());
            Toolkit.getDefaultToolkit().beep();
        });
        t.start();

        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
