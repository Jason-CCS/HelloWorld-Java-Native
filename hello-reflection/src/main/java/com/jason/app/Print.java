package com.jason.app;

/**
 * Created by jc6t on 2015/4/28.
 */
public class Print {
    public Print() {
        System.out.println(this.getClass().getCanonicalName());
        System.out.println(this.getClass().getName());
        System.out.println(this.getClass().getSimpleName());
    }

    public void print(String input){
        System.out.println(input);
    }
}
