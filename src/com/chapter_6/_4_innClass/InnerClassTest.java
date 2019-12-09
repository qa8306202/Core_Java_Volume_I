package com.chapter_6._4_innClass;


import com.chapter_6._4_innClass.ssozh.TalkingClock;

import javax.swing.*;

public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(2000,true);
        clock.start();

        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null,"Quit Program?");
        System.exit(0);


    }
}

//class TalkingClock{
//    private int interval;
//    private boolean beep;
//
//    /**
//     * constructs a talking clock
//     * @param interval interval the interval between messages(in milliseconds)
//     * @param beep beep true if the clock should beep
//     */
//    public TalkingClock(int interval,boolean beep){
//        this.interval = interval;
//        this.beep = beep;
//    }
//
//    public void start(){
//        ActionListener listener = this.new TimerPrinter();
//        Timer t = new Timer(interval, listener);
//        t.start();
//    }
//
//    /**
//     * 这个就是TalkingClock的公有内部类TimePrinter
//     * 这个内部类包含一个公有方法actionPerformed。
//     * 这里需要注意TimerPrinter虽然是内部类，这并不意味着每个TalkingCLock都有一个TimePrinter实例域。
//     * TimePrinter类没有实例域或者名为beep的变量，取而代之的是beep引用了创建TimePrinter的TalkingClock对象的域。
//     * 这里相当于内部类默认生成了一个构造器outer = TalkingClock clock; beep实际上是out.beep
//     */
//    public class TimerPrinter implements ActionListener{
//        public void actionPerformed(ActionEvent event){
//            System.out.println("At the tone, the time is " + new Date());
//            if(beep) Toolkit.getDefaultToolkit().beep();  // beep 是TalkingClock.this.beep的简写
//        }
//    }
//}
