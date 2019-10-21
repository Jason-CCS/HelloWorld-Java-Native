package com.jason.app.visitor;

/**
 * 訪問者
 *
 * 宣告實作類別中，有幾種元素需要處理，
 * 所以有幾種Element，這邊就要有幾個method
 */
public interface Visitor {

    void visit(Man man);

    void visit(Woman woman);

    void visit(Dog dog);

}
