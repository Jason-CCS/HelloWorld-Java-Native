package com.jason.app.proxy;

/**
 * 模式名：代理模式
 * 模式解說：在某些情况下，一个客户不想或者不能直接引用一个对象，此时可以通过一个称之为“代理”的第三者来实现间接引用。
 * 代理对象可以在客户端和目标对象之间起到中介的作用，并且可以通过代理对象去掉客户不能看到的内容和服务或者添加客户需要的额外服务。
 * 範例解說：此範例是實際Jason無法出席開庭，由律師來代理開庭，並且擁有律師額外增加的服務，這邊是增加"Ｘ律師代表"這幾個字
 */
public class Client {
    public static void main(String[] args) {
        //本人
        RealSubject jason = new RealSubject("Jason");

        //委任律師
        Proxy lawyer = new Proxy(jason, "陳律師");

        //在法庭答辯
        lawyer.speak("Hello everyone");
    }
}
