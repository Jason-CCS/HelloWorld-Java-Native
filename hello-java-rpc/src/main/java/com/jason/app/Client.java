package com.jason.app;

/**
 * Created by jc6t on 2015/7/1.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        IHello iHello=RPCFramework.refer(IHello.class, "localhost", 8080);
        for(int i=0;i<100;i++){
            String str=iHello.hello(i+" world");
            System.out.println(str);
            Thread.sleep(1000);
        }
    }
}
