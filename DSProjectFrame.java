/*
* Authors: Eric Belisle and Sara Hakkoum
* Date: 04/29/2015
* 
* Framingham State University - Spring 2015
* CSCI 271 - Data Structures Final Project
* Professor David Keil
*
* DSProjectFrame.java
* 
* This class describes a JFrame object that gives the user options such as
* the algorithm to test and the desired size of the data structures to test them on.
* It then displays the running time of the algorithm for each of the data structures
* by starting a timer before running the appropriate method from the Methods class,
* and calculating the time elapsed after the method returns.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.Stack;
import java.util.HashMap;
import java.util.Random;

public class DSProjectFrame extends JFrame {

    private JPanel instructPanel, selectPanel, northPanel,
        arrPanel, linkPanel, stackPanel, hashPanel, centerPanel, southPanel;
    private JLabel instruct1, instruct2, instruct3, lblAlgs, lblArr, lblLink, lblStack, lblHash,
        timeArr, timeLink, timeStack, timeHash, bubbleWarning;
    private JComboBox boxAlgs;
    private JSlider slider;
    private JButton run, exit;

    private static final String[] algorithms = {"Insertion at end", "Deletion at beginning", "Bubble sort", "Linear search"};

    public DSProjectFrame() {
        super("Data Structures Experiment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setSize(800, 500);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setLocation(screenWidth/4, screenHeight/4);

        buildFrame();

        setVisible(true);
    }

    private void buildFrame() {
        buildNorth();
        buildCenter();
        buildSouth();

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    private void buildNorth() {
        instruct1 = new JLabel("Select an algorithm, data structure,", SwingConstants.CENTER);
        instruct1.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
        instruct2 = new JLabel("and amount of data to test on,", SwingConstants.CENTER);
        instruct2.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
        instruct3 = new JLabel("then click Run to obtain time results.", SwingConstants.CENTER);
        instruct3.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));

        instructPanel = new JPanel(new BorderLayout());
        instructPanel.setBackground(Color.WHITE);
        instructPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        instructPanel.add(instruct1, BorderLayout.NORTH);
        instructPanel.add(instruct2, BorderLayout.CENTER);
        instructPanel.add(instruct3, BorderLayout.SOUTH);

        lblAlgs = new JLabel("Algorithm:", SwingConstants.CENTER);
        lblAlgs.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));

        boxAlgs = new JComboBox(algorithms);
        boxAlgs.addActionListener(new MultiListener());

        JPanel format1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        format1.setBackground(Color.WHITE);
        format1.add(boxAlgs);

        slider = new JSlider(JSlider.HORIZONTAL, 2, 10000, 2);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(1000);
        slider.setMinorTickSpacing(250);
        slider.setPreferredSize(new Dimension(500, 50));

        JPanel format2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        format2.setBackground(Color.WHITE);
        format2.add(slider);

        selectPanel = new JPanel(new BorderLayout());
        selectPanel.setBackground(Color.WHITE);
        selectPanel.add(lblAlgs, BorderLayout.NORTH);
        selectPanel.add(format1, BorderLayout.CENTER);
        selectPanel.add(format2, BorderLayout.SOUTH);

        bubbleWarning = new JLabel("WARNING: Bubble sort is VERY SLOW. Choose a small size!",
            SwingConstants.CENTER);
        bubbleWarning.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
        bubbleWarning.setForeground(Color.RED);
        bubbleWarning.setVisible(false);

        run = new JButton("Run");
        run.addActionListener(new MultiListener());
        run.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));

        JPanel format3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        format3.setBackground(Color.WHITE);
        format3.add(run);

        JPanel runPanel = new JPanel(new BorderLayout());
        runPanel.setBackground(Color.WHITE);
        runPanel.add(bubbleWarning, BorderLayout.NORTH);
        runPanel.add(format3, BorderLayout.CENTER);

        northPanel = new JPanel(new BorderLayout());
        northPanel.setBackground(Color.WHITE);
        northPanel.add(instructPanel, BorderLayout.NORTH);
        northPanel.add(selectPanel, BorderLayout.CENTER);
        northPanel.add(runPanel, BorderLayout.SOUTH);
    }

    private void buildCenter() {
        lblArr = new JLabel("Array", SwingConstants.CENTER);
        lblArr.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        timeArr = new JLabel("", SwingConstants.CENTER);
        timeArr.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        timeArr.setForeground(Color.BLUE);

        arrPanel = new JPanel(new BorderLayout());
        arrPanel.setBackground(Color.WHITE);
        arrPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        arrPanel.add(lblArr, BorderLayout.NORTH);
        arrPanel.add(timeArr, BorderLayout.CENTER);

        lblLink = new JLabel("Linked List", SwingConstants.CENTER);
        lblLink.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        timeLink = new JLabel("", SwingConstants.CENTER);
        timeLink.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        timeLink.setForeground(Color.BLUE);

        linkPanel = new JPanel(new BorderLayout());
        linkPanel.setBackground(Color.WHITE);
        linkPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        linkPanel.add(lblLink, BorderLayout.NORTH);
        linkPanel.add(timeLink, BorderLayout.CENTER);

        lblStack = new JLabel("Stack", SwingConstants.CENTER);
        lblStack.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        timeStack = new JLabel("", SwingConstants.CENTER);
        timeStack.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        timeStack.setForeground(Color.BLUE);

        stackPanel = new JPanel(new BorderLayout());
        stackPanel.setBackground(Color.WHITE);
        stackPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        stackPanel.add(lblStack, BorderLayout.NORTH);
        stackPanel.add(timeStack, BorderLayout.CENTER);

        lblHash = new JLabel("Hash Map", SwingConstants.CENTER);
        lblHash.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        timeHash = new JLabel("", SwingConstants.CENTER);
        timeHash.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        timeHash.setForeground(Color.BLUE);

        hashPanel = new JPanel(new BorderLayout());
        hashPanel.setBackground(Color.WHITE);
        hashPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        hashPanel.add(lblHash, BorderLayout.NORTH);
        hashPanel.add(timeHash, BorderLayout.CENTER);

        centerPanel = new JPanel(new GridLayout(1, 4));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(arrPanel);
        centerPanel.add(linkPanel);
        centerPanel.add(stackPanel);
        centerPanel.add(hashPanel);
    }

    private void buildSouth() {
        exit = new JButton("Exit");
        exit.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        exit.addActionListener(new MultiListener());

        southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        southPanel.setBackground(Color.WHITE);
        southPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        southPanel.add(exit);
    }

    private class MultiListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == boxAlgs) {
                if (boxAlgs.getSelectedIndex() == 2) {
                    bubbleWarning.setVisible(true);
                }
                else {
                    bubbleWarning.setVisible(false);
                }
            }
            else if (e.getSource() == run) {
                timeArr.setText("");
                timeLink.setText("");
                timeStack.setText("");
                timeHash.setText("");
                lblStack.setForeground(Color.BLACK);
                lblHash.setForeground(Color.BLACK);

                int selection = boxAlgs.getSelectedIndex();
                int size = slider.getValue();

                switch (selection) {

                    // Insertion at end
                    case 0: {
                        int[] arr = Methods.populateArray(size);
                        LinkedList link = Methods.populateLinkedList(size);
                        Stack stack = Methods.populateStack(size);
                        HashMap hash = Methods.populateHashMap(size);

                        // Array
                        long startTime = System.nanoTime();

                        Methods.insertInArray(arr);

                        long endTime = System.nanoTime();
                        timeArr.setText(endTime - startTime + " nanoseconds");

                        //Linked List
                        startTime = System.nanoTime();

                        Methods.insertInLinkedList(link);

                        endTime = System.nanoTime();
                        timeLink.setText(endTime - startTime + " nanoseconds");

                        // Stack
                        startTime = System.nanoTime();

                        Methods.insertInStack(stack);

                        endTime = System.nanoTime();
                        timeStack.setText(endTime - startTime + " nanoseconds");

                        // Hash Map
                        startTime = System.nanoTime();

                        Methods.insertInHashMap(hash);

                        endTime = System.nanoTime();
                        timeHash.setText(endTime - startTime + " nanoseconds");

                        break;
                    }

                    // Deletion at beginning
                    case 1: {
                        int[] arr = Methods.populateArray(size);
                        LinkedList link = Methods.populateLinkedList(size);
                        Stack stack = Methods.populateStack(size);
                        HashMap hash = Methods.populateHashMap(size);

                        // Array
                        long startTime = System.nanoTime();

                        Methods.deleteFromArray(arr);

                        long endTime = System.nanoTime();
                        timeArr.setText(endTime - startTime + " nanoseconds");

                        //Linked List
                        startTime = System.nanoTime();

                        Methods.deleteFromLinkedList(link);

                        endTime = System.nanoTime();
                        timeLink.setText(endTime - startTime + " nanoseconds");

                        // Stack
                        startTime = System.nanoTime();

                        Methods.deleteFromStack(stack);

                        endTime = System.nanoTime();
                        timeStack.setText(endTime - startTime + " nanoseconds");

                        // Hash Map
                        startTime = System.nanoTime();

                        Methods.deleteFromHashMap(hash);

                        endTime = System.nanoTime();
                        timeHash.setText(endTime - startTime + " nanoseconds");

                        break;
                    }

                    // Bubble sort
                    case 2: {
                        lblStack.setForeground(Color.GRAY);
                        lblHash.setForeground(Color.GRAY);

                        int[] arr = Methods.populateArray(size);
                        LinkedList link = Methods.populateLinkedList(size);

                        // Array
                        long startTime = System.nanoTime();

                        Methods.bubbleSortArray(arr);

                        long endTime = System.nanoTime();
                        timeArr.setText(endTime - startTime + " nanoseconds");

                        //Linked List
                        startTime = System.nanoTime();

                        Methods.bubbleSortLinkedList(link);

                        endTime = System.nanoTime();
                        timeLink.setText(endTime - startTime + " nanoseconds");

                        break;
                    }

                    // Linear search
                    case 3: {
                        int[] arr = Methods.populateArray(size);
                        LinkedList link = Methods.populateLinkedList(size);
                        Stack stack = Methods.populateStack(size);
                        HashMap hash = Methods.populateHashMap(size);

                        Random random = new Random();
                        int randomInt = random.nextInt();

                        // Array
                        long startTime = System.nanoTime();

                        Methods.linearSearchArray(arr, randomInt);

                        long endTime = System.nanoTime();
                        timeArr.setText(endTime - startTime + " nanoseconds");

                        //Linked List
                        startTime = System.nanoTime();

                        Methods.linearSearchLinkedList(link, randomInt);

                        endTime = System.nanoTime();
                        timeLink.setText(endTime - startTime + " nanoseconds");

                        // Stack
                        startTime = System.nanoTime();

                        Methods.linearSearchStack(stack, randomInt);

                        endTime = System.nanoTime();
                        timeStack.setText(endTime - startTime + " nanoseconds");

                        // Hash Map
                        startTime = System.nanoTime();

                        Methods.linearSearchHashMap(hash, randomInt);

                        endTime = System.nanoTime();
                        timeHash.setText(endTime - startTime + " nanoseconds");

                        break;
                    }
                }
            }
            else if (e.getSource() == exit) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        DSProjectFrame project = new DSProjectFrame();
    }
}
