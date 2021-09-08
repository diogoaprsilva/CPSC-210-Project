package model;

//InventoryItem class for creating a new itemName with type
public class InventoryItem {
    private String itemName;
    private String type;

    // REQUIRES: String name, String type
    // MODIFIES: this
    // EFFECTS: -Sets itemName to name
    //          -Sets type to type
    public InventoryItem(String name, String type) {
        this.itemName = name;
        this.type = type;
    }

    // EFFECTS: - returns itemName
    public String getItemName() {
        return itemName;
    }

    // EFFECTS: - returns type
    public String getType() {
        return type;
    }

}

