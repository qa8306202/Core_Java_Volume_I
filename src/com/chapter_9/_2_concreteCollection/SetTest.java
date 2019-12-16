package com.chapter_9._2_concreteCollection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * alice in Wonderland downloads from :http://www.gutenberg.org/
 *
 */

public class SetTest {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();  // HashSet implements Set
        long totalTime = 0;
//        try (Scanner in = new Scanner(System.in)){
//            while (in.hasNext()){
//                String word = in.next();
//                long callTime = System.currentTimeMillis();
//                words.add(word);
//                callTime = System.currentTimeMillis() - callTime;
//                totalTime += callTime;
//            }
//
//        }

        // 获取当前路径
        String cmd = System.getProperty("user.dir");
        System.out.println(cmd);  //这个当前路径是项目的ROOT路径
        try {
            File file = new File( "./src/com/chapter_9/_2_concreteCollection/alice30.txt"); //创建一个文件类
            InputStream is = new FileInputStream(file); // catch FileNotFoundException。他的输入的文件类
            Scanner in = new Scanner(is); // Scanner输入的是InputStream ，scanner类实现了接口Iterator<String> 和克隆
            while (in.hasNext()){
                String word = in.next();
                long callTime = System.currentTimeMillis(); //获取当前时间 用毫秒。
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        Iterator<String> iter = words.iterator();
        for(int i=1;i<=20 && iter.hasNext();i++){
            System.out.println(iter.next());
        }
        System.out.println("...");
        System.out.println(words.size() +" distinct words.\n" + totalTime + " milliseconds");

    }
}
