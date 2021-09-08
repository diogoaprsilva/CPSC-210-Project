package ui;

import model.BinarySolver;
import model.Tamagotchi;
import model.Task;
import model.ToDoList;
import org.jfugue.player.Player;
import persistence.JsonReader;
import persistence.JsonWriter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainGUI implements ActionListener {
    private static Tamagotchi tamagotchi;
    private static final String JSON_STORE = "./data/tamagotchi.json";
    private static JFrame frame;
    private static JPanel panel;
    private static int count = -1;
    private static int countcompleted = -1;
    private static JLabel inputLabel;
    private static JTextField inputTask;
    private static JButton cb1;
    private static JButton cb2;
    private static JButton loadButton = new JButton("Load Button");
    private static JButton saveButton = new JButton("Save Button");
    private static JButton b1 = new JButton("<");
    private static JButton b2 = new JButton(">");
    private static JButton taskb1 = new JButton("<");
    private static JButton taskb2 = new JButton(">");
    private static JLabel taskLabel;
    private static JLabel taskLabelCompleted;
    private static JLabel task;
    private static JLabel completedtask = new JLabel();
    private static JButton submit;
    private static ToDoList toDO;
    private static Player player;
    private static JButton markasComplete;
    private static JTextField input;
    private static JCheckBox cb1BinarySolver;
    private static JCheckBox cb2BinarySolver;
    private static JLabel answerLabel;
    private static JLabel answer;
    private static JLabel inputBox;
    private static JsonReader jsonReader = new JsonReader(JSON_STORE);
    private static JsonWriter jsonWriter = new JsonWriter(JSON_STORE);

    // REQUIRES: String
    // MODIFIES: this
    // EFFECTS: Intializes the main screen where the user can pick to access either
    // BinarySolver application or the ToDoList Application
    public static void main(String[] args) {
        player = new Player();
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(100,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        frame.setTitle("PROCRASTINATOR APP");
        b1 = new JButton("To Do List");
        b2 = new JButton("BinarySolver");
        b1.setBounds(100, 55, 100, 100);
        b2.setBounds(200, 55, 100, 100);
        loadButton.setBounds(100, 155, 100, 100);
        saveButton.setBounds(200, 155, 100, 100);
        panel.add(b1);
        panel.add(b2);
        panel.add(loadButton);
        panel.add(saveButton);
        nextScreenBinarySolver();
        nextScreenToDoList();
        loadButtonAction();
        saveButtonAction();
        frame.add(panel);
        frame.setVisible(true);
    }

    private static void loadButtonAction() {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadTamagotchi();
            }
        });

    }

    private static void saveButtonAction() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTamagotchi();
            }
        });

    }

    // EFFECTS: if the toDoList button is pressed then ToDoList screen is started
    private static void nextScreenToDoList() {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toDoList();
            }
        });

    }

    // EFFECTS: if the binarySolver button is pressed then binarySolver screen is started
    private static void nextScreenBinarySolver() {
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                binarySolver();
            }
        });

    }

    // MODIFIES: this
    // EFFECTS: Intializes the elements needed for the ToDoListGUI
    private static void intializeToDoList() {
        frame = new JFrame();
        frame.setSize(350,200);
        panel = new JPanel();
        toDO = new ToDoList();
        inputLabel = new JLabel("Input a task:");
        inputTask = new JTextField();
        submit = new JButton("Add Task");
        taskLabel = new JLabel("CURRENT TASK:");
        taskLabelCompleted = new JLabel("COMPLETED TASKS:");
        task = new JLabel();
        cb1 = new JButton("<");
        cb2 = new JButton(">");
        markasComplete = new JButton("MARK AS COMPLETE");
        loadButton = new JButton("LOAD");
        saveButton = new JButton("SAVE");
        addToPanelToDoList();
        frame.add(panel);
    }

    // MODIFIES: this
    // EFFECTS: adds all the elements to the panel
    private static void addToPanelToDoList() {
        panel.add(cb1);
        panel.add(cb2);
        panel.add(taskb1);
        panel.add(taskb2);
        panel.add(task);
        panel.add(taskLabel);
        panel.add(submit);
        panel.add(inputTask);
        panel.add(inputLabel);
        panel.add(markasComplete);
        panel.add(completedtask);
        panel.add(taskLabelCompleted);
    }


    // MODIFIES: this
    // EFFECTS: Intializes the toDoList application where a user can add new tasks, view their tasks
    // and mark as completed
    public static void toDoList() {
        intializeToDoList();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        frame.setTitle("To Do List");
        inputLabel.setBounds(100, 20, 100, 25);
        inputTask.setBounds(185, 20, 100, 25);
        submit.setBounds(275, 20, 100, 25);
        markasComplete.setBounds(360, 20, 170, 25);
        markAsComplet();
        actionForSubmitButton();
        taskLabel.setBounds(180, 40, 100, 25);
        taskLabelCompleted.setBounds(180, 75, 150, 25);
        actionForNextTask();
        actionForPreviousTask();
        actionForNextCompletedTask();
        actionForPrevCompletedTask();
        cb1.setBounds(100, 55, 20, 25);
        cb2.setBounds(375, 55, 20, 25);
        taskb1.setBounds(100, 80, 20, 25);
        taskb2.setBounds(375, 80, 20, 25);
        task.setBounds(120,55,200,25);
        completedtask.setBounds(120, 80, 200, 25);
        frame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: used for the ActionListener that is used by the markasCompleted Button
    private static void markAsComplet() {
        markasComplete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toDO.returnUserTasks().size() > -1) {
                    try {
                        toDO.markCompleted(count);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    taskLabelCompleted.setText(toDO.getCompletedTask(toDO.returnCompletedTasks().size() - 1));
                    task.setText("MARKED AS COMPLETE");
                    count = count - 1;
                    player.play("C");
                    SwingUtilities.updateComponentTreeUI(frame);
                }
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: used to show the next completed task on the ToDoList
    private static void actionForNextCompletedTask() {
        cb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toDO.returnCompletedTasks().size() == 0) {
                    task.setText(toDO.getCompletedTask(toDO.returnCompletedTasks().size()));
                } else {
                    task.setText(toDO.getCompletedTask(count + 1));
                    player.play("E");
                    countcompleted = countcompleted + 1;
                }
            }
        });

    }

    // MODIFIES: this
    // EFFECTS: used to show the prev completed task on the ToDoList
    private static void actionForPrevCompletedTask() {
        cb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toDO.returnCompletedTasks().size() == 0) {
                    task.setText(toDO.getCompletedTask(toDO.returnCompletedTasks().size()));
                } else {
                    task.setText(toDO.getCompletedTask(count - 1));
                    player.play("E");
                    countcompleted = countcompleted - 1;
                }
            }
        });

    }

    // MODIFIES: this
    // EFFECTS: used to show the next task on the ToDoList
    private static void actionForNextTask() {
        cb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toDO.returnUserTasks().size() == 0) {
                    task.setText(toDO.getTask(toDO.returnUserTasks().size()));
                } else {
                    task.setText(toDO.getTask(count + 1));
                    player.play("E");
                    count = count + 1;
                }
            }
        });

    }

    // MODIFIES: this
    // EFFECTS: used to show the previous task on the ToDoList
    private static void actionForPreviousTask() {
        cb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toDO.returnUserTasks().size() == 0) {
                    task.setText(toDO.getTask(toDO.returnUserTasks().size()));
                } else {
                    task.setText(toDO.getTask(count - 1));
                    player.play("Dm");
                    count = count - 1;
                }
            }
        });

    }

    // MODIFIES: this
    // EFFECTS: used to submit to get the answer for the user input on BinarySolver
    private static void actionForSubmitButton()  {
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newTask = inputTask.getText();
                Task newtask = new Task("-" + newTask);
                toDO.addTask(newtask);
                task.setText(toDO.getTask(toDO.returnUserTasks().size() - 1));
                SwingUtilities.updateComponentTreeUI(frame);
                player.play("F");
                count = count + 1;
                inputTask.setText("");
            }
        });
    }

   // MODIFIES: this
   // EFFECTS: Intializes the elements needed for the BinarySolverGUI
    private static void intializeBinarySolver() {
        frame = new JFrame();
        panel = new JPanel();
        inputBox = new JLabel("Input Binary Number:");
        input = new JTextField();
        answer = new JLabel();
        answerLabel = new JLabel("Answer:");
        cb1BinarySolver = new JCheckBox("Binary To Decimal");
        cb2BinarySolver = new JCheckBox("Binary to Hexadecimal");
    }


    // MODIFIES: this
    // EFFECTS: Intializes the binarySolver application where the user can convert binary to hexadecimal
    // or to decimal
    public static void binarySolver() {
        intializeBinarySolver();
        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        frame.setTitle("Binary Solver");
        inputBox.setBounds(100, 20, 165, 25);
        panel.add(inputBox);
        input.setBounds(250, 20, 165, 25);
        panel.add(input);
        JButton submitButton = new JButton("Submit Answer");
        submitButton.addActionListener(new BinarySolverGUI());
        submitButton.setBounds(150, 80, 300,30);
        cb1BinarySolver.setBounds(100,120,150,20);
        cb2BinarySolver.setBounds(100,150,200,20);
        panel.add(cb1BinarySolver);
        panel.add(cb2BinarySolver);
        answerLabel.setBounds(300,120,60,25);
        panel.add(answerLabel);
        answer.setBounds(370,120,300,25);
        panel.add(submitButton);
        panel.add(answer);
        frame.setVisible(true);
    }


    // EFFECTS: this is used for the actions to be performed in BinarySolver when the submit button is pressed
    // if cb1BinarySolver then it will convert binaryToDecimal
    // if cb2BinarySolver then it will convert binaryToHexadecimal
    @Override
    public void actionPerformed(ActionEvent e) {
        String binaryNumber = input.getText();
        if (cb1BinarySolver.isSelected()) {
            answer.setText(String.valueOf(BinarySolver.binaryToDecimal(binaryNumber)));
        }
        if (cb2BinarySolver.isSelected()) {
            answer.setText(BinarySolver.binaryToHexadecimal(binaryNumber));
        }

    }

    // MODIFIES: this
    // EFFECTS: loads Tamagotchi from file
    public static void loadTamagotchi() {
        try {
            tamagotchi = jsonReader.read();
            System.out.println("Loaded " + tamagotchi.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file:" + JSON_STORE);
        }

    }

    // EFFECTS: saves Tamagotchi to file
    public static void saveTamagotchi() {
        try {
            jsonWriter.open();
            jsonWriter.write(tamagotchi);
            jsonWriter.close();
            System.out.println("Saved" + tamagotchi.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

}