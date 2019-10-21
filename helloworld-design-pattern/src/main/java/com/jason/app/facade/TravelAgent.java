package com.jason.app.facade;

/**
 * Created by jasonchang on 2017/5/3.
 * Facade 門面，也就是agent
 */
public class TravelAgent {
    private TravelPlan travelPlan = new TravelPlan();

    public void getPackage(String destination) {
        travelPlan.plan(destination);
        travelPlan.checkTrasportation();
        travelPlan.buyFlightTicket();
        travelPlan.bookHotel();
        travelPlan.reserveRestaurant();
    }

    public void getFlightAndHotel(String destination) {
        travelPlan.plan(destination);
        travelPlan.buyFlightTicket();
        travelPlan.bookHotel();
    }
}
