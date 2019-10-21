package com.jason.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jc6t on 2015/3/2.
 * This example will run two threads at the same time.
 * One is count-down and lift off.
 * The other is user type in anything.
 * You can type in something and see count down on the console concurrently.
 */
public class ThreadFirstTry {
    public static void main(String[] args) {
        // set seconds before liftOff
        ExecutorService liftOffService=Executors.newCachedThreadPool();
        liftOffService.execute(new LiftOff(20));

        // set number times to input to test multi-thread
        ExecutorService userTypeInService= Executors.newSingleThreadExecutor();
        userTypeInService.execute(new UserTypeIn(5));
        liftOffService.shutdown();
        userTypeInService.shutdown();
    }
}


