package com.segmentfault.Java.Lesson1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.Callable;

/**
 * 内置类实例
 */
public class InnerClassDemo {
    //Static块
    static {
        new Runnable(){

            @Override
            public void run() {

            }
        };
    }
    //实例块
    {
        new Callable(){

            @Override
            public Object call() throws Exception {
                return null;
            }
        };
    }

    public static void main(String[] args) {
        //方法（类、或者实例）
        PropertyChangeListener l = new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent evt) {

            }
        };
    }




}
