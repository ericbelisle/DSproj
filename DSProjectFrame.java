import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DSProjectFrame extends JFrame {

    private JPanel instructPanel, selectPanel, northPanel,
        arrPanel, linkPanel, stackPanel, bstPanel, centerPanel, southPanel;
    private JLabel instruct1, instruct2, instruct3, lblAlgs, lblArr, lblLink, lblStack, lblBST,
        runArr, runLink, runStack, runBST, timeArr, timeLink, timeStack, timeBST;
    private JComboBox boxAlgs;
    private JSlider slider;
    private JButton run, exit;

    private static final String[] algorithms = {"Fast sort", "Merge sort", "Linear search", "Binary search", "Insertion"};

    public DSProjectFrame() {
        super("Data Structures Experiment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setSize(750, 500);

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

        slider = new JSlider();
        // TODO setup slider here

        JPanel format2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        format2.setBackground(Color.WHITE);
        format2.add(slider);

        selectPanel = new JPanel(new BorderLayout());
        selectPanel.setBackground(Color.WHITE);
        selectPanel.add(lblAlgs, BorderLayout.NORTH);
        selectPanel.add(format1, BorderLayout.CENTER);
        selectPanel.add(format2, BorderLayout.SOUTH);

        run = new JButton("Run");
        run.addActionListener(new MultiListener());
        run.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));

        JPanel format3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        format3.setBackground(Color.WHITE);
        format3.add(run);

        northPanel = new JPanel(new BorderLayout());
        northPanel.setBackground(Color.WHITE);
        northPanel.add(instructPanel, BorderLayout.NORTH);
        northPanel.add(selectPanel, BorderLayout.CENTER);
        northPanel.add(format2, BorderLayout.SOUTH);
    }

    private void buildCenter() {
        lblArr = new JLabel("Array", SwingConstants.CENTER);
        lblArr.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        runArr = new JLabel("Running...", SwingConstants.CENTER);
        runArr.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        runArr.setForeground(Color.GREEN);
        runArr.setVisible(false);
        timeArr = new JLabel("", SwingConstants.CENTER);
        timeArr.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        timeArr.setForeground(Color.BLUE);

        arrPanel = new JPanel(new BorderLayout());
        arrPanel.setBackground(Color.WHITE);
        arrPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        arrPanel.add(lblArr, BorderLayout.NORTH);
        arrPanel.add(runArr, BorderLayout.CENTER);
        arrPanel.add(timeArr, BorderLayout.SOUTH);

        lblLink = new JLabel("Linked List", SwingConstants.CENTER);
        lblLink.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        runLink = new JLabel("Running...", SwingConstants.CENTER);
        runLink.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        runLink.setForeground(Color.GREEN);
        runLink.setVisible(false);
        timeLink = new JLabel("", SwingConstants.CENTER);
        timeLink.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        timeLink.setForeground(Color.BLUE);

        linkPanel = new JPanel(new BorderLayout());
        linkPanel.setBackground(Color.WHITE);
        linkPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        linkPanel.add(lblLink, BorderLayout.NORTH);
        linkPanel.add(runLink, BorderLayout.CENTER);
        linkPanel.add(timeLink, BorderLayout.SOUTH);

        lblStack = new JLabel("Stack", SwingConstants.CENTER);
        lblStack.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        runStack = new JLabel("Running...", SwingConstants.CENTER);
        runStack.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        runStack.setForeground(Color.GREEN);
        runStack.setVisible(false);
        timeStack = new JLabel("", SwingConstants.CENTER);
        timeStack.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        timeStack.setForeground(Color.BLUE);

        stackPanel = new JPanel(new BorderLayout());
        stackPanel.setBackground(Color.WHITE);
        stackPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        stackPanel.add(lblStack, BorderLayout.NORTH);
        stackPanel.add(runStack, BorderLayout.CENTER);
        stackPanel.add(timeStack, BorderLayout.SOUTH);

        lblBST = new JLabel("Binary Search Tree", SwingConstants.CENTER);
        lblBST.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        runBST = new JLabel("Running...", SwingConstants.CENTER);
        runBST.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        runBST.setForeground(Color.GREEN);
        runBST.setVisible(false);
        timeBST = new JLabel("", SwingConstants.CENTER);
        timeBST.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        timeBST.setForeground(Color.BLUE);

        bstPanel = new JPanel(new BorderLayout());
        bstPanel.setBackground(Color.WHITE);
        bstPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bstPanel.add(lblBST, BorderLayout.NORTH);
        bstPanel.add(runBST, BorderLayout.CENTER);
        bstPanel.add(timeBST, BorderLayout.SOUTH);

        centerPanel = new JPanel(new GridLayout(1, 4));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(arrPanel);
        centerPanel.add(linkPanel);
        centerPanel.add(stackPanel);
        centerPanel.add(bstPanel);
    }

    private void buildSouth() {
        exit = new JButton("Exit");
        exit.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        exit.addActionListener(new MultiListener());

        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setBackground(Color.WHITE);
        southPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        southPanel.add(exit);
    }

    private class MultiListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == boxAlgs) {
                // TODO
            }
            else if (e.getSource() == run) {
                // TODO
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
