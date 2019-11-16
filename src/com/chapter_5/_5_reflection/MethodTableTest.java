package com.chapter_5._5_reflection;

import java.lang.reflect.*;


/**
 * This program shows how to invoke methods through reflection.
 * In the book,we  needn't to use try ... catch, but here must use it
 * @author Ssozh
 */

public class MethodTableTest {
    public static void main(String[] args)
    {
        // We must use try catch when using getMethod, OR     public static void main(String[] args) throws Exception
        try {
            // get method pointers to the square and sqrt methods
            Method square = MethodTableTest.class.getMethod("square", double.class); //类名.class.getMethod("方法名")
            Method sqrt = Math.class.getMethod("sqrt", double.class);
            // print tables of x- and y-values
            printTable(1,10,10,square);
            printTable(1,10,10,sqrt);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * returns the square of a number
     * @param x a number
     * @return  x squared
     */
    public static double square(double x)
    {
        return  x*x;
    }

    public static void printTable(double from, double to, int n, Method f)
    {
        // print out the method as table header
        System.out.println(f);

        double dx = (to -from) / (n-1);
        for (double x = from; x<=to;x+=dx)
        {
            try {
                double y = (double) f.invoke(null,x);
                System.out.printf("%10.4f | %10.4f%n",x,y);
            }
            catch ( Exception e)
            {
                e.printStackTrace();
            }
        }
    }

}
