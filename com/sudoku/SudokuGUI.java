package com.sudoku;

/**
 * Created by LINHBOB on 11/6/2016.
 */

import javax.swing.*;
import java.awt.*;

public class SudokuGUI extends JFrame {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JPanel[] grid;
    private JTextField[][] cell;
    private Color PANEL_COLOR = Color.white;
    private Color CELL_COLOR = new Color(51, 51, 51);
    private Color TEXT_COLOR = new Color(255, 255, 56);
    private Font TEXT_FONT = new Font("Cursive", Font.BOLD, 35);
    private GridLayout PANEL_LAYOUT = new GridLayout(3, 3, 5, 5);
    private FlowLayout BUTTON_LAYOUT = new FlowLayout(FlowLayout.CENTER,0,15);

    private int[][] demo = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    private boolean[][] cover = {
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true}
    };

    public SudokuGUI() {
        mainFrame = new JFrame("Sudoku Algorithm Demo - Group 1");
        mainFrame.setLayout(new BorderLayout());

        //Panel for the Sudoku map Display
        mainPanel = new JPanel(PANEL_LAYOUT);
        mainPanel.setBackground(PANEL_COLOR);
        mainPanel.setPreferredSize(new Dimension(600, 600));

        //Panel for the Buttons
        buttonPanel = new JPanel(BUTTON_LAYOUT);
        buttonPanel.add(new JButton("Solve"));
        buttonPanel.add(new JLabel("                    "));
        buttonPanel.add(new JButton("Randomize"));

        //create 9 3x3 Grids
        grid = new JPanel[9];
        for (int i = 0; i < grid.length; i++) {
            grid[i] = new JPanel(new GridLayout(3, 3));
            mainPanel.add(grid[i]);
        }

        //cover all the Grids with a 9x9 Text Field
        cell = new JTextField[9][9];
        for (int aux = 0; aux < 9; aux = aux + 3) {
            for (int row = aux; row < (aux + 3); row++) {
                for (int col = 0; col < 9; col++) {
                    cell[row][col] = new JTextField();
                    cell[row][col].setEditable(false);
                    if (col < 3) {
                        grid[aux].add(cell[row][col]);
                    } else if (col < 6) {
                        grid[aux + 1].add(cell[row][col]);
                    } else {
                        grid[aux + 2].add(cell[row][col]);
                    }
                    cell[row][col].setBackground(CELL_COLOR);
                    cell[row][col].setForeground(TEXT_COLOR);
                    cell[row][col].setHorizontalAlignment(JTextField.CENTER);
                    cell[row][col].setFont(TEXT_FONT);
                }
            }
        }

        //add everything to the main Window
        mainFrame.add(new JLabel(" "), BorderLayout.NORTH);
        mainFrame.add(new JLabel("     "), BorderLayout.EAST);
        mainFrame.add(new JLabel("     "), BorderLayout.WEST);
        mainFrame.add(mainPanel, BorderLayout.CENTER);
        mainFrame.add(buttonPanel, BorderLayout.SOUTH);

        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public void displayNumbers() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (cover[row][col]) {
                    cell[row][col].setText(demo[row][col] + "");
                } else {
                    cell[row][col].setText("");
                }
            }
        }
    }

    public void randomize(){
        try {
            while (true) {
                for (int row = 0; row < 9; row++) {
                    for (int col = 0; col < 9; col++) {
                        if (cover[row][col]) {
                            demo[row][col] = (int) (Math.random() * 10 + 1);
                            Thread.sleep(50);
                            cell[row][col].setText(demo[row][col] + "");
                        } else {
                            cell[row][col].setText("");
                        }
                    }
                }
            }
        } catch (InterruptedException e){}
    }
}
