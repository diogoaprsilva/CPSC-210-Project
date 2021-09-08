package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalcProgram {
    public CalcProgram calculator;

    @BeforeEach
    public void runBefore () {
        calculator = new CalcProgram();
    }

    @Test
    public void testAddition() {
        assertEquals(10+10, calculator.addition(10, 10));
        assertEquals(-10+-10, calculator.addition(-10, -10));
        assertEquals(1000, calculator.addition(750, 250));
        assertEquals(100+100, calculator.calculation(100, "+", 100));
    }

    @Test
    public void testSubtraction() {
        assertEquals(10-10, calculator.subtract(10, 10));
        assertEquals(-10 - -10, calculator.subtract(-10, -10));
        assertEquals(1000, calculator.subtract(750, -250));
        assertEquals(100-300, calculator.calculation(100, "-", 300));
    }

    @Test
    public void testDivision() {
        assertEquals(100/2, calculator.division(100, 2));
        assertEquals(250/1000, calculator.division(250, 1000));
        assertEquals(1/1, calculator.division(1, 1));
        assertEquals(25/5, calculator.calculation(25, "/", 5));
    }

    @Test
    public void testMultiplication() {
        assertEquals(100*2, calculator.multiplication(100, 2));
        assertEquals(250*1000, calculator.multiplication(250, 1000));
        assertEquals(0*0, calculator.multiplication(0, 0));
        assertEquals(25*5, calculator.calculation(25, "*", 5));
    }

    @Test
    public void testCalculation() {
        assertEquals(2, calculator.calculation(1, "+", 1));
        assertEquals(1, calculator.calculation(1, "*", 1));
        assertEquals(0, calculator.calculation(1, "-", 1));
        assertEquals(2, calculator.calculation(4, "/", 2));
        assertEquals(0, calculator.calculation(0, "A", 0));
    }

}