package com.jason.app.proxy;

/**
 * Created by jasonchang on 2017/5/3.
 */
public class Proxy implements Subject {
    /**
     * 委託人
     */
    private Subject subject;

    /**
     * 律師姓名
     */
    private String name;

    /**
     * 建構式傳入委託人與律師姓名
     * @param subject
     * @param name
     */
    public Proxy(Subject subject, String name) {
        this.subject = subject;
        this.name = name;
    }

    /**
     * 由律師代表本人發言
     * @param words
     */
    @Override
    public void speak(String words) {
        System.out.println(name+"代表");
        subject.speak(words);
    }
}
