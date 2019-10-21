package com.jason.app.facade;

/**
 * Created by jasonchang on 2017/5/3.
 * 複雜系統功能
 */
public class TravelPlan {
    public void plan(String destination){
        System.out.println("安排"+destination+"行程。。。");
    }

    public void buyFlightTicket(){
        System.out.println("購買機票");
    }

    public void bookHotel(){
        System.out.println("預定酒店或旅館");
    }

    public void checkTrasportation(){
        System.out.println("確定交通行程");
    }

    public void reserveRestaurant(){
        System.out.println("安排餐廳");
    }
}
