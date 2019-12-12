package com.chapter_6._4_innClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        AnonymousTalkingClock clock = new AnonymousTalkingClock();
        clock.start(1000,true);

        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}


/**
 * A clock that prints the time in regular intervals
 */
class AnonymousTalkingClock{
    public void start(int interval, boolean beep){
        ActionListener listener = new ActionListener(){
          public void actionPerformed(ActionEvent event){
              System.out.println("At the tone, the time is "+  new Date());
              if(beep) Toolkit.getDefaultToolkit().beep();
          }
        };
    Timer t= new Timer(interval,listener);
    t.start();
    }
}