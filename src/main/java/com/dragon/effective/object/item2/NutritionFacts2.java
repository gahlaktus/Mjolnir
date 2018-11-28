package com.dragon.effective.object.item2;

/**
 * @author huangzhibo
 * @date 10/10/2017
 */
public class NutritionFacts2 {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builders implements Builder<NutritionFacts2>{   //内部静态类

        // required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;

        public Builders(int servingSize, int serings) {
            this.servingSize = servingSize;
            this.servings = serings;
        }

        public NutritionFacts2.Builders calories(int val) {
            calories = val;
            return this;
        }
        public NutritionFacts2.Builders fat(int val) {
            fat = val;
            return this;
        }
        public NutritionFacts2.Builders sodium(int val) {
            sodium = val;
            return this;
        }
        public NutritionFacts2.Builders carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        @Override
        public NutritionFacts2 build() {
            return new NutritionFacts2(this);
        }
    }

    private NutritionFacts2(Builders builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public int getServingSize() {
        return servingSize;
    }

    public int getServings() {
        return servings;
    }

    public int getCalories() {
        return calories;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

}
