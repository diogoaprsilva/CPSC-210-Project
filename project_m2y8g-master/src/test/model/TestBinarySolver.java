package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestBinarySolver {
    public BinarySolver biSolver;

    @BeforeEach
    public void runBefore(){
        biSolver = new BinarySolver();
    }


    @Test
    public void testBinaryToDecimal(){
        assertEquals(8, biSolver.binaryToDecimal("1000"));
        assertEquals(32, biSolver.binaryToDecimal("100000"));
        assertEquals(15, biSolver.binaryToDecimal("1111"));
    }

    @Test
    public void testBinaryToHex(){
        assertEquals("8", biSolver.binaryToHexadecimal("1000"));
        assertEquals("20", biSolver.binaryToHexadecimal("100000"));
        assertEquals("f", biSolver.binaryToHexadecimal("1111"));
    }
}
