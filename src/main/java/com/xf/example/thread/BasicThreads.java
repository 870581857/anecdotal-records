package com.xf.example.thread;

public class BasicThreads {
    public static void main(String[] args){
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("waiting for liftoff");
    }
}
