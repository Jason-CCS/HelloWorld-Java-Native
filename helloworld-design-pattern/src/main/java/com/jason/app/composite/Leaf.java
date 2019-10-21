package com.jason.app.composite;

/**
 * Created by jasonchang on 2017/5/12.
 * 樹葉節點（其下不可再有節點）
 */
public class Leaf implements Component {
    /**
     * 節點名稱
     */
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        System.out.println("葉節點不可增加子節點");
    }

    @Override
    public void remove(Component component) {
        System.out.println("葉節點不可移除子節點");
    }

    @Override
    public void display(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("|---");
        }
        System.out.println(this.name);
    }

}
