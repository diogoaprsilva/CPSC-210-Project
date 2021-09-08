package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestToDoList {
    public ToDoList createToDo;
    public Task testTask;
    public Task testTask2;
    public Task testTask3;
    public Task testTask4;

    @BeforeEach
    public void runBefore(){
        createToDo = new ToDoList();
        createToDo.returnUserTasks().clear();
        createToDo.returnCompletedTasks().clear();
        testTask = new Task("test1");
        testTask2 = new Task("test2");
        testTask3 = new Task("test3");
        testTask4 = new Task("test4");
    }

    @Test
    public void testGetTask(){
        createToDo.addTask(testTask);
        assertEquals("test1", createToDo.getTask(0));
    }

    @Test
    public void testGetCompletedTask(){
        try {
        createToDo.addTask(testTask);
        createToDo.addTask(testTask2);
        createToDo.markCompleted(0);
        createToDo.markCompleted(0);
        assertEquals("test1", createToDo.getCompletedTask(0));
        assertEquals("test2", createToDo.getCompletedTask(1));
        assertTrue(createToDo.containsCompleted(testTask));
        assertTrue(createToDo.containsCompleted(testTask2));
        assertFalse(createToDo.containsCompleted(testTask3));
    } catch (Exception e) {

        }
    }

    @Test
    public void testAddTask() {
        createToDo.addTask(testTask);
        assertTrue(createToDo.containsTask(testTask));
        createToDo.addTask(testTask2);
        assertTrue(createToDo.containsTask(testTask2));
        assertTrue(createToDo.containsTask(testTask));
    }

    @Test
    public void testMarkCompleted() {
        try {
            createToDo.addTask(testTask);
            createToDo.addTask(testTask2);
            createToDo.addTask(testTask3);
            createToDo.addTask(testTask4);
            createToDo.markCompleted(0);
            createToDo.markCompleted(0);
            createToDo.markCompleted(1);
            assertTrue(createToDo.containsCompleted(testTask));
            assertTrue(createToDo.containsCompleted(testTask2));
            assertTrue(createToDo.containsCompleted(testTask4));
            assertEquals("test1", createToDo.getCompletedTask(0));
            assertEquals("test2", createToDo.getCompletedTask(1));
        } catch (Exception e) {

        }
    }

    @Test
    public void testMarkCompletedNoUserTasks() {
        try {
            createToDo.markCompleted(0);
            fail("Cannot complete task when user Task is 0");
        } catch (Exception e) {
        }
    }

    @Test
    public void testReturnUserTasks() {
        assertEquals(0, createToDo.returnUserTasks().size());
    }

    @Test
    public void testReturnCompletedTasks() {
        assertEquals(0, createToDo.returnCompletedTasks().size());
    }


    @Test
    public void testContainsCompleted() {
        try {
            assertFalse(createToDo.containsCompleted(testTask));
            createToDo.addTask(testTask);
            createToDo.markCompleted(0);
            assertTrue(createToDo.containsCompleted(testTask));
        } catch (Exception e) {

        }
    }

    @Test
    public void testContainsTask() {
        assertFalse(createToDo.containsTask(testTask));
        createToDo.addTask(testTask);
        assertTrue(createToDo.containsTask(testTask));
    }

}
