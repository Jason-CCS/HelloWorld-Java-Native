package com.jason.app.strategy.collection.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jasonchang on 2017/4/21.
 * 模式名：策略模式
 * 模式解說：
 * 範例解說：Java native的Collection.sort(要排序的list,要排序的策略)也是使用這個模式
 */
public class Main {
    public static void main(String[] args) {
        // 準備三個村莊的資料
        Village appleFarm = new Village(3,"apple farm",32,5.1);
        Village barnField = new Village(1,"barn field",22,1.7);
        Village capeValley = new Village(2, "cape valley",  10  ,10.2);


        ArrayList<Village> vilages = new ArrayList<>();
        vilages.add(appleFarm);
        vilages.add(barnField);
        vilages.add(capeValley);

        System.out.println("沒排序過的資料");
        showList(vilages);

        System.out.println("根據ID排序");
        Collections.sort(vilages,new SortById());
        showList(vilages);

        System.out.println("根據名子排序");
        Collections.sort(vilages,new SortByName());
        showList(vilages);

        System.out.println("根據人口排序");
        Collections.sort(vilages,new SortByPopulation());
        showList(vilages);

        System.out.println("根據面積排序");
        Collections.sort(vilages,new SortByArea());
        showList(vilages);
    }

    // 只是為了把資料印出來看
    public static void showList (ArrayList<Village> list){
        for(Village v : list){
            System.out.println(v);
        }
    }
}
