package model;

// Converts a binary number of any amount of bits
// Converts the binary number into either decimal or hex number
public class BinarySolver {
    // REQUIRES: String
    // EFFECTS: - returns the base 10 or decimal value of the inputted Binary Number/Inputted String
    public static int binaryToDecimal(String num) {
        return Integer.parseInt(num, 2);
    }

    // REQUIRES: String
    // EFFECTS: - returns the base 15 or hexadecimal value of the inputted Binary Number/Inputted String
    public static String binaryToHexadecimal(String num) {
        int decimal = binaryToDecimal(num);
        return Integer.toString(decimal, 16);
    }
}
