package com.jason.app.mediator;

/**
 * Created by jasonchang on 2017/5/12.
 * 模式名：中介者模式
 * 模式解說：當多對多交互作用發生時，物件與物件互相call來call去是很複雜的交互網，如果大家都只對一個中介者（伺服器）來滿足彼此的溝通，
 * 那將會簡化整個設計，以現代來說，市話與市話的溝通，手機與手機的溝通，網頁與網頁的溝通，都是有中介者的。
 * 範例解說：此範例為設計一個聊天室，同事A可以選擇廣播跟所有人溝通，也可以選擇跟某個人溝通，所有的溝通都通過中介者。
 */
public class Client {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague colleagueA = new ConcreteColleague(mediator, "同事A");
        Colleague colleagueB = new ConcreteColleague(mediator, "同事B");
        Colleague colleagueC = new ConcreteColleague(mediator, "同事C");

        mediator.join(colleagueA);
        mediator.join(colleagueB);
        mediator.join(colleagueC);

        colleagueA.send("大家好！");
        System.out.println("---");
        colleagueB.send("有個秘密我只跟你說…", colleagueA);
        System.out.println("---");
        colleagueC.send("哈囉！");
    }
}
