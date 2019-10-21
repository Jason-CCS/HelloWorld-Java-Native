package com.jason.app.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonchang on 2017/5/12.
 * 樹枝節點（其下可以有樹葉節點）
 */
public class Composite implements Component {
    /**
     * 節點名稱
     */
    private String name;

    /**
     * 子節點
     */
    private List<Component> childList = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        childList.add(component);
    }

    @Override
    public void remove(Component component) {
        childList.remove(component);
    }

    @Override
    public void display(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("|---");
        }
        System.out.println(this.name);

        childList.forEach(component -> component.display(i + 1));
    }
}
