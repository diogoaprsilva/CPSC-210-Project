package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// The ProcrastinatorApp that contains:
// Tools:
// Calculator, Binary Solver, To-Do List
// Games:
// Personal Tamagotchi, Simon Says, Math Game
public class ProcrastinatorApp {
    private static final String JSON_STORE = "./data/tamagotchi.json";
    private Scanner input;
    private ToDoList toDO;
    private BinarySolver biSolver;
    private CalcProgram calculator;
    private Tamagotchi tamagotchi;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private Boolean isLoaded;
    private Boolean isSaved;
    private Boolean changes;

    // EFFECTS: initiates the runProcrastinator Object
    public ProcrastinatorApp() throws Exception {
        runProcrastinator();
    }

    // EFFECTS: - calls init to initiate Scanner, ToDoList, BinarySolver, CalcProgram
    //          - initiates the displayMenu and keeps track of the user input
    //          - while the user does not press the key "q" on their keyboard the program keeps running
    //          - if the user presses "q" it closes the program and prints "Goodbye".
    private void runProcrastinator() throws Exception {
        boolean keepGoing = true;
        String command = null;
        init();
        while (keepGoing) {
            displayMenu();
            command = input.next();
            command.toLowerCase();
            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: - Initiates Scanner, ToDoList, BinarySolver, CalcProgram
    private void init() {
        input = new Scanner(System.in);
        toDO = new ToDoList();
        biSolver = new BinarySolver();
        calculator = new CalcProgram();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        this.isSaved = false;
        this.isLoaded = false;
        this.changes = false;
    }

    // EFFECTS: - outputs the various different programs available for the user to utilize
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("b -> BinarySolver");
        System.out.println("c -> Calculator");
        System.out.println("tl -> ToDoList");
        System.out.println("t -> Tamagotchi");
        System.out.println("q -> Quit");
    }

    // REQUIRES: String command
    // EFFECTS: processes the user input
    //          - if command is b then BinarySolver program will start
    //          - if command is c then Calculator program will start
    //          - if command is tl then ToDoList program will start
    private void processCommand(String command) throws Exception {
        if (command.equals("b")) {
            binarySolver();
        } else if (command.equals("c")) {
            calculatorProgram();
        } else if (command.equals("tl")) {
            toDoListProgram();
        } else if (command.equals("t")) {
            runTamagotchi();
        }
    }

    // EFFECTS: Run's the Tamagotchi application
    //        - The application will run until the user presses the q key on the keyboard.
    private void runTamagotchi() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);
        tamagotchiIntialLoader();
        while (keepGoing) {
            changes = false;
            displayMenuTamagotchi();
            command = input.next();
            command = command.toLowerCase();
            if (command.equals("q")) {
                checkSaved();
                keepGoing = false;
            } else {
                processCommandTamagotchi(command);
            }
        }
    }

    // REQUIRES: isLoaded
    // MODIFIES: this
    // EFFECTS: - If isLoaded == False. Then, it asks the user if they would like to load a file before program starts
    //          -Else: do nothing
    private void tamagotchiIntialLoader() {
        String command = null;
        if (isLoaded == false) {
            System.out.println("Would you like to load the file?");
            System.out.println("Press y to load file | Press n to not load file");
            command = input.next();
            command = command.toLowerCase();
            if (command.equals("y")) {
                loadTamagotchi();
                isLoaded = true;
            }
        }
    }

    // REQUIRES: isSaved
    // MODIFIES: this
    // EFFECTS: - If isSaved == False. Then, it warns the user to save the file before they close it.
    //          -Else: do nothing
    private void checkSaved() {
        String command = null;
        if (isSaved == false && changes == true) {
            System.out.println("Would you like to save?");
            System.out.println("y -> yes | n -> no");
            command = input.next();
            command = command.toLowerCase();
            if (command.equals("y")) {
                isSaved = true;
                System.out.println("Saving...");
                saveTamagotchi();
                System.out.println("Saved");
            }
        }
    }

    // EFFECTS: - outputs the various different programs available for the user to utilize
    private void displayMenuTamagotchi() {
        System.out.println("\nSelect from;");
        System.out.println("\tn -> new tamagotchi");
        System.out.println("\ts -> save tamagotchi to file");
        System.out.println("\tl -> load tamagotchi from file");
        System.out.println("\tc -> see the tamagotchi name");
        System.out.println("\tq -> quit");
    }

    // REQUIRES: String command
    // EFFECTS: processes the user input
    //          - if command is n then newTamagotchi will start
    //          - if command is s then saveTamagotchi will start
    //          - if command is l then loadTamagotchi  will start
    //          - if command is c then getName  will start
    private void processCommandTamagotchi(String command) {
        if (command.equals("n")) {
            newTamagotchi();
        } else if (command.equals("s")) {
            saveTamagotchi();
        } else if (command.equals("l")) {
            loadTamagotchi();
        } else if (command.equals("c")) {
            getName();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: if the program file has been loaded
    //          - then output the Tamagotchi name
    //         else: Warn user to load a file or create a new Tamagotchi
    private void getName() {
        if (isLoaded == true) {
            String name = tamagotchi.getName();
            System.out.println(name);
        } else {
            System.out.println("Please load a file or create a New Tamagotchi");
        }
    }

    // MODIFIES: this
    // EFFECTS: creates new Tamagotchi based on the user input
    private void newTamagotchi() {
        System.out.println("WARNING: PREVIOUS DATA WILL BE OVERWRITTEN");
        System.out.println("Please enter name of Tamagotchi: ");
        String name = input.next();
        tamagotchi = new Tamagotchi(name);
        changes = true;
    }

    // EFFECTS: saves Tamagotchi to file
    public void saveTamagotchi() {
        try {
            jsonWriter.open();
            jsonWriter.write(tamagotchi);
            jsonWriter.close();
            System.out.println("Saved" + tamagotchi.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    public String tamagotchiName() {
        return tamagotchi.getName();
    }

    // MODIFIES: this
    // EFFECTS: loads Tamagotchi from file
    public void loadTamagotchi() {
        try {
            tamagotchi = jsonReader.read();
            System.out.println("Loaded " + tamagotchi.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file:" + JSON_STORE);
        }

    }


    // EFFECTS: - asks user to input a binary number
    //          - then asks user if they would like to find the Decimal or Hex of the binary number
    //          - if user chooses Decimal, the decimal value of the binary number will return
    //          - if user chooses Hex, the hexadecimal value of the binary number will return
    private void binarySolver() {
        System.out.println("Enter binary Number");
        String binary = input.next();
        String selection = "";
        while (!(selection.equals("d") || selection.equals("h"))) {
            System.out.println("d for decimal");
            System.out.println("h for hex");
            selection = input.next();
        }
        if (selection.equals("d")) {
            System.out.println(biSolver.binaryToDecimal(binary));
        } else {
            System.out.println(biSolver.binaryToHexadecimal(binary));
        }
    }

    // EFFECTS: - asks user to 2 numbers and a operand
    //          - calls CalcProgram to calculate the sum of number1 operand number,
    //          - for example lets say number1 and number2 = 1 and operand = +
    //          - return will be 1 + 1 which is 2
    private void calculatorProgram() {
        System.out.println("Enter First Number:");
        Integer number1 = input.nextInt();
        System.out.println("Enter Second Number:");
        Integer number2 = input.nextInt();
        System.out.println("Enter the operand:");
        String ope = input.next();
        System.out.println(calculator.calculation(number1, ope, number2));
    }

    // MODIFIES: this
    // EFFECTS: - asks user if they would like to add a task, view tasks, or view completed tasks
    //          - if user chooses to add task then the user will be asked to input a task and
    //            this task will be added to the toDoList
    //          - if user chooses to view tasks, returnTask will be called and executed
    //          - if user chooses to view completedTasks, returnCompletedTask will be called and executed
    private void toDoListProgram() throws Exception {
        String selection = "";
        String command = null;
        boolean keepGoing = true;
        while (keepGoing) {
            displayMenuTasks();
            command = input.next();
            command = command.toLowerCase();
            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processComandTasks(command);
            }
        }
    }

    // REQUIRES: String command
    // EFFECTS: processes the user input
    //          - if command is a then Write a Task will start
    //          - if command is t then returnTask will start
    //          - if command is c then returnCompletedTask program will start
    private void processComandTasks(String command) throws Exception {
        if (command.equals("a")) {
            String task = "";
            System.out.println("Write the Task:");
            task = input.next();
            Task newTask = new Task(task);
            toDO.addTask(newTask);
            System.out.println("Added Task");
        } else if (command.equals("t")) {
            returnTask();
        } else if (command.equals("c")) {
            returnCompletedTask();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: - outputs the various different programs available for the user to utilize
    private void displayMenuTasks() {
        System.out.println("\nSelect from;");
        System.out.println("\ta -> Add Task");
        System.out.println("\tt -> View Tasks");
        System.out.println("\tc -> View Comleted Tasks");
        System.out.println("\tq -> quit");
    }

    // EFFECTS: returns all of the tasks that are included in the userTasks array
    private void returnTask() throws Exception {
        int i;
        for (i = 0; i < toDO.returnUserTasks().size(); i++) {
            System.out.print(i + 1);
            System.out.print(") ");
            System.out.println(toDO.getTask(i));
        }
        String selection = "";
        Integer select = 0;
        System.out.println("any key -> return");
        System.out.println("c -> Add to Completed Task");
        selection = input.next();
        if (selection.equals("c")) {
            System.out.println("Insert the task number:");
            select = input.nextInt();
            toDO.markCompleted(select - 1);
        }
    }

    // EFFECTS: returns all of the tasks that are included in the completedTasks array
    private void returnCompletedTask() {
        int i;
        for (i = 0; i < toDO.returnCompletedTasks().size(); i++) {
            System.out.println(toDO.getCompletedTask(i));
        }
    }

}