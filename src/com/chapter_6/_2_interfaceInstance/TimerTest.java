package com.chapter_6._2_interfaceInstance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;


public class TimerTest {
    public static void main(String[] args) {
        //
        ActionListener listener = new TimePrinter();  // ActionListener是一个接口变量名（接口不是类），实现这个接口的类都可以被监听

        // construct a timer that calls the listener
        //once every 10 secs
        Timer t = new Timer(10000,listener);  // 延迟interval（这里是10秒） 通告ActionListener 一次【这个是一个循环。如果不停止t.stop会一直发送】
        t.start(); // 启动计时器，还有一个是停止计时器
        JOptionPane.showMessageDialog(null,"Quit program?");  // void javax.swing.JOptionPane.showMessageDialog(parent=null, message)
        System.exit(0);
    }

}

class TimePrinter implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, the time is "+ new Date());
        Toolkit.getDefaultToolkit().beep(); //发出一声响铃
    }
}
