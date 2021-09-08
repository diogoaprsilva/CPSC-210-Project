package ui;

import model.BinarySolver;
import model.CalcProgram;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new ProcrastinatorApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}