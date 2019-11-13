package com.chapter_5._4_enums;

public class WrapperTest_and_ParaTest {
    public static void main(String[] args)
    {
        Integer a = 1000;
        Integer b = 1000;
        System.out.println(a==b);  // false!
        triple(a);
        System.out.println(a);  // 1000 rather than 3000!


        double  m = max(3.1, 40.0, -10.1);
        System.out.println(m);  // 40.0 , "double[] values" is different with "double ... values"



    }

    public static void triple(Integer x)
    {
        x = x * 3;
    }

    public static double max_error(double[] values)
    {
        double largest = Double.NEGATIVE_INFINITY;
        for(double v : values)
        {
            if (v>largest)
                largest = v;
        }
        return largest;
    }

    public static double max(double ... values)
    {
        double largest = Double.NEGATIVE_INFINITY;
        for(double v : values)
        {
            if (v>largest)
                largest = v;
        }
        return largest;
    }
}
