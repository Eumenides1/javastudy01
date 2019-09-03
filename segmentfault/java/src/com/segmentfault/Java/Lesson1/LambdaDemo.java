package com.segmentfault.Java.Lesson1;

import java.util.stream.Stream;

public class LambdaDemo {
    public static void main(String[] args) {

    }
    private static void stream(){
        Stream.of(1,2,3,4,5).map(String::valueOf);
    }
}
