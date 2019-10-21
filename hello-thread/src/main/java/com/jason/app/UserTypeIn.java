package com.jason.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jc6t on 2015/3/2.
 */
public class UserTypeIn implements Runnable{
    public int typeCount=10;

    public UserTypeIn(){}
    public UserTypeIn(int typeCount) {
        this.typeCount=typeCount;
    }

    public void run(){
        while(typeCount>0){
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("User type in service is on, please enter any input then press enter...");
                System.out.printf("What you type is %s!", br.readLine());
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
            typeCount--;
            Thread.yield();
        }
    }
}
