package org.example;

class NutritionsFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public NutritionsFacts(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static class Builder {

        //Required parameters
        private int servingSize;
        private int servings;
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;
        public Builder(int servingSize,int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionsFacts build(){
            NutritionsFacts nutritionsFacts = new NutritionsFacts(this);
            return nutritionsFacts;
        }
    }

    public static void main(String[] args) {
        NutritionsFacts.Builder cola = new Builder(10,2)
                .calories(2)
                .fat(2)
                .sodium(1)
                .carbohydrate(10);
        System.out.println(cola.carbohydrate);
    }

}


