package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFood {
    private Food newFood;

    @BeforeEach
    void testFood() {
        this.newFood = new Food("TestFood", 50);
    }

    @Test
    public void testGetFoodName() {
        assertEquals("TestFood", newFood.getFoodName());
    }

    @Test
    public void testGetNutitrionValue() {
        assertEquals(50, newFood.getNutritionValue());
    }
}
