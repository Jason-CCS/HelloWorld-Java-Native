package com.jason.app.builder;

/**
 * Created by jasonchang on 2017/4/21.
 */
public class Meal {
    private String mainDish;
    private String drink;
    private String sideDish;

    public void setMainDish(String mainDish) {
        this.mainDish = mainDish;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void setSideDish(String sideDish) {
        this.sideDish = sideDish;
    }

    @Override
    public String toString() {
        String all = "";
        if (mainDish != null) {
            all+=mainDish + " ";
        }
        if (this.drink != null) {
            all+=drink + " ";
        }
        if (this.sideDish != null) {
            all+=sideDish + " ";
        }

        return "此套餐有：" + all;
    }
}
