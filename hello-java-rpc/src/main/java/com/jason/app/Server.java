package com.jason.app;

/**
 * Created by jc6t on 2015/7/1.
 */
public class Server {
    public static void main(String[] args) throws Exception {
        IHello iHello=new HelloImpl();
        RPCFramework.export(iHello, 8080);
    }
}

