package com.jason.app.facade;

/**
 * 模式名：外觀模式
 * 模式解說：有一複雜系統或多個複雜系統，欲對這個複雜系統做整合，提供一個簡易介面或代理，以便於使用者操作或使用
 * 範例解說：要安排旅遊時，需要做許多的行前安排，安排行程，訂機票，看哪邊好玩，晚上住哪，有了旅行社安排，
 * 就可以減少了許多自己研究的時間。
 */
public class Client {
    public static void main(String[] args) {
        TravelAgent agent = new TravelAgent();

        System.out.println("幫我安排日本京都的行程：");
        agent.getPackage("日本京都");
        System.out.println();

        System.out.println("幫我安排曼谷的機加酒就好");
        agent.getFlightAndHotel("泰國曼谷");
        System.out.println();
    }
}
