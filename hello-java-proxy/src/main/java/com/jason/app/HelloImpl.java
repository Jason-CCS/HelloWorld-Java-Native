package com.jason.app;

/**
 * Created by jc6t on 2015/7/1.
 */
public class HelloImpl implements IHello{
    public void hello(String str) {
        System.out.println("Hello, "+str);
    }
}
