package model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

//Creates a new Tamagotchi object, with inventory and ownedfoods,
//along side with a fixed health and new name
public class Tamagotchi {
    private static ArrayList<Food> ownedFoods = new ArrayList<>();
    private static ArrayList<InventoryItem> inventory = new ArrayList<>();
    private static ArrayList<Food> possibleFood = new ArrayList<>();
    private String petName;
    private Integer health = 500;
    private Food newFood;

    // REQUIRES: ArrayList<InventoryItem>
    // EFFECTS: returns inventory array
    public ArrayList<InventoryItem> returnInventory() {
        return inventory;
    }

    // REQUIRES: ArrayList<Food>
    // EFFECTS: returns ownedFoods array
    public ArrayList<Food> returnOwnedFoods() {
        return ownedFoods;
    }

    // REQUIRES: ArrayList<Food>
    // EFFECTS: returns possibleFood array
    public ArrayList<Food> returnPossibleFood() {
        return possibleFood;
    }

    // REQUIRES: String name
    // MODIFIES: possibleFood and inventory
    // EFFECTS: creates a new Tamagotchi based on the name and
    // generates the inventory and possibleFood array to their default value
    public Tamagotchi(String name) {
        this.petName = name;
        generateFoods();
        generateNameTag();
    }

    // EFFECTS: returns petName
    public String getName() {
        return petName;
    }

    // EFFECTS: returns health
    public Integer getHealth() {
        return health;
    }


    // REQUIRES: Food
    // MODIFIES: this
    // EFFECTS:
    // - If ownedfood contains the inputted food
    //      Increases health based on the nutritionvalue of the inputted food.
    //      removes the used food from the ownedFood array
    // - Else: do nothing
    public void petEat(Food food) {
        if (ownedFoods.contains(food)) {
            health = health + food.getNutritionValue();
            ownedFoods.remove(food);
        }
    }

    // REQUIRES: InventoryItem nametag, String name
    // MODIFIES: this
    // EFFECTS: - If inventory contains nameTag
    //   change petName to name
    // - Else: do nothing
    public void useNameTag(InventoryItem nameTag, String name) {
        if (inventory.contains(nameTag)) {
            this.petName = name;
            inventory.remove(nameTag);
        }
    }

    // REQUIRES: possibleFood
    // MODIFIES: this
    // EFFECTS: Initializes possibleFood with the Foods available
    public void generateFoods() {
        possibleFood.add(new Food("Banana", 10));
        possibleFood.add(new Food("Kiwi", 2));
        possibleFood.add(new Food("Apple", 20));
        possibleFood.add(new Food("Full Meal", 100));
    }

    // REQUIRES: inventory
    // MODIFIES: this
    // EFFECTS: Initializes inventory with 3 Name Tags
    public void generateNameTag() {
        inventory.add(new InventoryItem("Name Tag", "nametag"));
        inventory.add(new InventoryItem("Name Tag", "nametag"));
        inventory.add(new InventoryItem("Name Tag", "nametag"));
    }

    // REQUIRES: possibleFood and OwnedFood
    // MODIFIES: this
    // EFFECTS: Randomly selects a element from possibleFood
    // and adds it to ownedFoods as part of a reward
    public void createRandomReward() {
        Random r = new Random();
        int randomNumber = r.nextInt(possibleFood.size());
        newFood = possibleFood.get(randomNumber);
        ownedFoods.add(newFood);
    }

    // REQUIRES: petName
    // EFFECTS: Creates new JSONOject and adds the petName to it.
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", petName);
        return json;
    }



}
