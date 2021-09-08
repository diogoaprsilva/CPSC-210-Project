package ui;

import model.BinarySolver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinarySolverGUI implements ActionListener {
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel inputBox;
    private static JLabel answer;
    private static JTextField input;
    private static JCheckBox cb1;
    private static JCheckBox cb2;
    private static JLabel answerLabel;

    private static void intialize() {
        frame = new JFrame();
        panel = new JPanel();
        inputBox = new JLabel("Input Binary Number:");
        input = new JTextField();
        answer = new JLabel();
        answerLabel = new JLabel("Answer:");
        cb1 = new JCheckBox("Binary To Decimal");
        cb2 = new JCheckBox("Binary to Hexadecimal");
    }

    public static void main(String[] args) {
        intialize();
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
        cb1.setBounds(100,120,150,20);
        cb2.setBounds(100,150,200,20);
        panel.add(cb1);
        panel.add(cb2);
        answerLabel.setBounds(300,120,60,25);
        panel.add(answerLabel);
        answer.setBounds(370,120,300,25);
        panel.add(submitButton);
        panel.add(answer);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String binaryNumber = input.getText();
        if (cb1.isSelected()) {
            answer.setText(String.valueOf(BinarySolver.binaryToDecimal(binaryNumber)));
        }
        if (cb2.isSelected()) {
            answer.setText(String.valueOf(BinarySolver.binaryToHexadecimal(binaryNumber)));
        }
    }
}
