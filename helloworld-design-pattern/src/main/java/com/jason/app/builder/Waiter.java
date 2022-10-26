package com.jason.app.builder;

/**
 * Created by jasonchang on 2017/4/21.
 */
public class Waiter {
    private MealBuilder builder = new MealBuilder();
    public Meal getMealA(){
        builder.setMeal(new Meal());
        builder.buildMainDish("大麥克").buildDrink("中杯可樂").buildSideDish("中暑");
        return builder.produceMeal();
    }

    public Meal getMealB(){
        builder.setMeal(new Meal());
        builder.buildMainDish("麥香魚").buildDrink("中杯可樂").buildSideDish("中暑");
        return builder.produceMeal();
    }

    public Meal getMealC(){
        builder.setMeal(new Meal());
        builder.buildMainDish("四塊雞塊").buildDrink("小杯可樂").buildSideDish("小暑");
        return builder.produceMeal();
    }
}
