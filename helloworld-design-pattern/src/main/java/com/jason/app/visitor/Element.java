package com.jason.app.visitor;

/**
 * 供訪問的元素
 */
public interface Element {

    /**
     * 接受一種訪問類別，並在傳入後執行該類別對應的方法
     */
    public void accept(Visitor visitor);
}

