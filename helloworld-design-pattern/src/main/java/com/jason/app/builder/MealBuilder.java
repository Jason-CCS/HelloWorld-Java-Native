package com.jason.app.builder;

/**
 * Created by jasonchang on 2017/4/21.
 */
public class MealBuilder {
    private Meal meal;

    public MealBuilder buildMainDish(String mainDish){
        System.out.println("製作"+ mainDish +"中...");
        this.meal.setMainDish(mainDish);
        return this;
    }

    public MealBuilder buildDrink(String drink){
        System.out.println("製作"+ drink +"中...");
        this.meal.setDrink(drink);
        return this;
    }

    public MealBuilder buildSideDish(String sideDish){
        System.out.println("製作"+ sideDish +"中...");
        this.meal.setSideDish(sideDish);
        return this;
    }

    public Meal produceMeal(){
        System.out.println("製作完畢。");
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
