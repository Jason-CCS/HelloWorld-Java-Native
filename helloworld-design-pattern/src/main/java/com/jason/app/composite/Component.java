package com.jason.app.composite;

/**
 * Created by jasonchang on 2017/5/12.
 * 樹枝與樹葉節點需實作的介面
 */
public interface Component {
    /**
     * 新增子元素
     */
    public void add(Component component);

    /**
     * 移除子元素
     */
    public void remove(Component component);

    /**
     * 顯示本身與其下所有子節點
     */
    public void display(int i);
}
