package com.jason.app;

import sun.rmi.runtime.Log;

/**
 * Hello world!
 */
public class ProxyDemo {
    public static void main(String[] args) {
        LogHandler logHandler=new LogHandler();
        IHello helloProxy=(IHello)logHandler.bind(new HelloImpl());
        helloProxy.hello("Jason");
    }
}
