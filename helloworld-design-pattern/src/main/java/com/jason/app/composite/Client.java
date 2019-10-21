package com.jason.app.composite;

/**
 * Created by jasonchang on 2017/5/12.
 * 模式名：組合模式
 * 模式解說：合成模式又稱部分整體模式，如果你的需求中，有需要部分與整體的概念，接著讓用戶端使用相同的方式操作各元素，就可以使用合成模式
 * 範例解說：此範例是使用html dom來解釋
 */
public class Client {
    public static void main(String[] args) {
        // 基本HTML Tag
        Composite html = new Composite("html");
        Composite title = new Composite("title");
        Composite head = new Composite("head");
        Composite body = new Composite("body");

        // div
        Composite div1 = new Composite("div1");
        Composite div2 = new Composite("div2");
        Composite div3 = new Composite("div3");

        // p
        Leaf p1 = new Leaf("p1");
        Leaf p2 = new Leaf("p2");
        Leaf p3 = new Leaf("p3");

        // 組裝div，第二個div空著，看看結果有沒有如我們所願
        div1.add(p1);
        div1.add(p2);
        div3.add(p3);

        // 組裝body
        body.add(div1);
        body.add(div2);
        body.add(div3);

        // 組裝head
        head.add(title);

        // 組裝html
        html.add(head);
        html.add(body);

        Composite div4 = new Composite("div4");
        div2.add(div4);

        Composite table = new Composite("table");
        Composite tr = new Composite("tr");
        Leaf td1 = new Leaf("td1");
        Leaf td2 = new Leaf("td2");
        Leaf td3 = new Leaf("td3");

        div4.add(table);
        table.add(tr);
        tr.add(td1);
        tr.add(td2);
        tr.add(td3);

        // 顯示，HTML為第1層
        html.display(0);
    }
}
