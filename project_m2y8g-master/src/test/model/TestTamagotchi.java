package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTamagotchi {
    private Tamagotchi test;

    @BeforeEach
    public void beforeEach() {
         this.test = new Tamagotchi("test");
    }

    @Test
    public void testConstructor(){
        assertEquals("test", test.getName());
        assertFalse(test.returnOwnedFoods().isEmpty());
        assertFalse(test.returnPossibleFood().isEmpty());
        assertFalse(test.returnInventory().isEmpty());
    }

    @Test
    public void testReturnInventory() {
        assertFalse(test.returnInventory().isEmpty());
    }

    @Test
    public void testReturnOwnedFoods() {
        assertTrue(test.returnOwnedFoods().isEmpty());
    }

    @Test
    public void testReturnPossibleFoods() {
        assertFalse(test.returnPossibleFood().isEmpty());
    }

    @Test
    public void testGetName() {
        assertEquals("test", test.getName());
    }

    @Test
    public void testGetHealth() {
        assertEquals(test.getHealth(), 500);
    }

    @Test
    public void testPetEat() {
        test.createRandomReward();
        assertEquals(test.getHealth(), 500);
        test.petEat(test.returnOwnedFoods().get(0));
        assertFalse(test.getHealth() == 500);
    }

    @Test
    public void testPetEatNoFood() {
        assertTrue(test.returnOwnedFoods().isEmpty());
        Food newFoodItem = new Food("banana", 2);
        test.petEat(newFoodItem);
        assertTrue(test.getHealth() == 500);
    }

    @Test
    public void noNameTag() {
        test.returnInventory().clear();
        assertTrue(test.returnInventory().isEmpty());
        InventoryItem newNameTag = new InventoryItem("nametag", "nametag");
        test.useNameTag(newNameTag, "test123");
        assertEquals("test", test.getName());
    }

    @Test
    public void testUseNameTag() {
        assertEquals("test",test.getName());
        test.useNameTag(test.returnInventory().get(0), "test2");
        assertEquals("test2",test.getName());
    }

    @Test
    public void generateNameTag() {
        assertFalse(test.returnInventory().isEmpty());
    }

    @Test
    public void createRandomReward() {
        assertTrue(test.returnOwnedFoods().isEmpty());
        test.createRandomReward();
        assertFalse(test.returnOwnedFoods().isEmpty());
    }

}
