package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInventoryItem {
    private InventoryItem test;

    @BeforeEach
    public void beforeEach() {
     this.test = new InventoryItem("test", "type");
    }

    @Test
    public void testGetItemName() {
        assertEquals("test", test.getItemName());
    }

    @Test
    public void testGetType() {
        assertEquals("type", test.getType());
    }


}
