package com.jason.app.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonchang on 2017/5/11.
 * 實際的中介者
 */
public class ConcreteMediator implements Mediator {

    /**
     * 裝載所有需要仲介栛調的物件
     */
    private List<Colleague> colleagueList = new ArrayList<>();

    @Override
    public void join(Colleague colleague) {
        colleagueList.add(colleague);
    }

    /**
     * 走訪全部對象並傳送訊息
     */
    @Override
    public void send(String message) {
        for (Colleague colleague:colleagueList){
            colleague.receive(message);
        }
    }

    /**
     * 單純對一位傳送訊息，並告訴它誰傳的
     */
    @Override
    public void send(String message, Colleague sender, Colleague receiveer) {
        receiveer.receive(message, sender);
    }
}
