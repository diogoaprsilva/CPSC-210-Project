package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask {
    private Task test;

    @BeforeEach
    public void beforeEach() {
         this.test = new Task("test");
    }

    @Test
    public void testTask() {
        assertEquals("test", test.getTaskName());
    }

    @Test
    public void testGetName() {
        assertEquals("test", test.getTaskName());
    }

}
