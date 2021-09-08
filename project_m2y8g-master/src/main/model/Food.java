package model;


//Food class for creating a new foodname with nutritionvalue
public class Food {
    private String foodName;
    private Integer nutritionValue;


    // REQUIRES: String name, Integer number
    // MODIFIES: this
    // EFFECTS: - Sets the value of foodName to name
    //             - Sets the value of nutritionValue to number
    public Food(String name, Integer number) {
        this.foodName = name;
        this.nutritionValue = number;
    }

    // EFFECTS: - outputs the foodName
    public String getFoodName() {
        return foodName;
    }

    // EFFECTS: - outputs the nutritionValue
    public Integer getNutritionValue() {
        return nutritionValue;
    }


}
