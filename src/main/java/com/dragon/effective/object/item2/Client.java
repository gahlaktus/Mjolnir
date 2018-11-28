package com.dragon.effective.object.item2;

/**
 * @author huangzhibo
 * @date 10/10/2017
 */
public class Client {

    public static void main(String[] args) {
        NutritionFacts cocacola = new NutritionFacts.Builder(240, 8).calories(100).sodium(20).build();

        System.out.println(cocacola.getSodium());

    }

}
