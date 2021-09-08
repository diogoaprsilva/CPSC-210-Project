package model;

// Takes two numbers and operand
// Calculates the sum of number1 operand number2
public class CalcProgram {
    private static int sum;

    // REQUIRES: n1 > 0 / integer, String, n2 > 0 / integer
    // MODIFIES: this
    // EFFECTS: - If operand = "+" then returns the sum of n1 + n2
    //          - If operand = "-" then returns the sum of n1 - n2
    //          - If operand = "*" then returns the sum of n1 * n2
    //          - If operand = "/" then returns the sum of n1 / n2
    //          - else returns 0
    public static int calculation(Integer n1, String operand, Integer n2) {
        sum = 0;
        if (operand == "+") {
            addition(n1, n2);
        } else if (operand == "-") {
            subtract(n1, n2);
        } else if (operand == "*") {
            multiplication(n1, n2);
        } else if (operand == "/") {
            division(n1, n2);
        }
        return sum;
    }

    // REQUIRES: n1 > 0 / integer, n2 > 0 / integer
    // MODIFIES: this
    // EFFECTS: returns the sum of n1 + n2
    public static int addition(Integer n1, Integer n2) {
        sum = n1 + n2;
        return sum;
    }

    // REQUIRES: n1 > 0 / integer, n2 > 0 / integer
    // MODIFIES: this
    // EFFECTS: returns the sum of n1 - n2
    public static int subtract(Integer n1, Integer n2) {
        sum = n1 - n2;
        return sum;
    }

    // REQUIRES: n1 > 0 / integer, n2 > 0 / integer
    // MODIFIES: this
    // EFFECTS: returns the sum of n1 / n2
    public static int division(Integer n1, Integer n2) {
        sum = n1 / n2;
        return sum;
    }

    // REQUIRES: n1 > 0 / integer, n2 > 0 / integer
    // MODIFIES: this
    // EFFECTS: returns the sum of n1 * n2
    public static int multiplication(Integer n1, Integer n2) {
        sum = n1 * n2;
        return sum;
    }

}

