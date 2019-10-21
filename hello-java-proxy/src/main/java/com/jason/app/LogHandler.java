package com.jason.app;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jc6t on 2015/7/1.
 */
public class LogHandler implements InvocationHandler{
    private Logger log=Logger.getLogger(this.getClass().getName());

    private Object delegate;

    public Object bind(Object delegate){
        this.delegate=delegate;
        return Proxy.newProxyInstance(delegate.getClass().getClassLoader(),delegate.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;

        try{
            log.log(Level.INFO,"method starts..."+method);

            result=method.invoke(delegate, args);

            log.log(Level.INFO,"method ends..."+method);
        }catch (Exception e){
            log.log(Level.INFO,e.toString());
        }

        return result;
    }
}
