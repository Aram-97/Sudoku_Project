package com.sudoku;

/**
 * Created by LINHBOB on 11/6/2016.
 */

import javax.swing.*;
import java.awt.*;

public class SudokuGUI implements Board{
    static JFrame mainFrame;
    private JPanel mainPanel;
    public static JPanel buttonPanel;
    private JPanel[] grid;
    private static JTextField[][] cell;
    private Color PANEL_COLOR = Color.white;
    private Color CELL_COLOR = new Color(51, 51, 51);
    private static Color TEXT_COLOR_1 = new Color(255, 255, 56);
    private static Color TEXT_COLOR_2 = new Color(100,51,255);
    private Font TEXT_FONT = new Font("Cursive", Font.BOLD, 35);
    private GridLayout PANEL_LAYOUT = new GridLayout(3, 3, 5, 5);
    private FlowLayout BUTTON_LAYOUT = new FlowLayout(FlowLayout.CENTER,60,15);

    public SudokuGUI() {
        mainFrame = new JFrame("Sudoku Solver - Group 1");
        mainFrame.setLayout(new BorderLayout());

        //Panel for the Sudoku map Display
        mainPanel = new JPanel(PANEL_LAYOUT);
        mainPanel.setBackground(PANEL_COLOR);
        mainPanel.setPreferredSize(new Dimension(600, 600));

        //Panel for the Buttons
        buttonPanel = new JPanel(BUTTON_LAYOUT);

        //create 9 3x3 Grids
        grid = new JPanel[9];
        for (int i = 0; i < grid.length; i++) {
            grid[i] = new JPanel(new GridLayout(3, 3));
            mainPanel.add(grid[i]);
        }

        //cover all the Grids with a 9x9 Text Field row by row
        cell = new JTextField[9][9];
        for (int aux = 0; aux < 9; aux = aux + 3) {
            for (int row = aux; row < (aux + 3); row++) {
                for (int col = 0; col < 9; col++) {
                    cell[row][col] = new JTextField();
                    if (col < 3) {
                        grid[aux].add(cell[row][col]);
                    } else if (col < 6) {
                        grid[aux + 1].add(cell[row][col]);
                    } else {
                        grid[aux + 2].add(cell[row][col]);
                    }
                    cell[row][col].setEditable(false);
                    cell[row][col].setBackground(CELL_COLOR);
                    cell[row][col].setHorizontalAlignment(JTextField.CENTER);
                    cell[row][col].setFont(TEXT_FONT);
                }
            }
        }

        //add everything to the main Window
        mainFrame.add(new JLabel(" "),BorderLayout.NORTH);
        mainFrame.add(new JLabel("     "),BorderLayout.WEST);
        mainFrame.add(new JLabel("     "),BorderLayout.EAST);
        mainFrame.add(mainPanel,BorderLayout.CENTER);
        mainFrame.add(buttonPanel,BorderLayout.SOUTH);

        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    //Class method to update the GUI
    public static void update(){
        buttonPanel.revalidate();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if(matrix[row][col] == 0)
                    cell[row][col].setText("");
                else
                    cell[row][col].setText(matrix[row][col] + "");

                if(editable[row][col]){
                    cell[row][col].setForeground(TEXT_COLOR_1);
                } else {
                    cell[row][col].setForeground(TEXT_COLOR_2);
                }
            }
        }
    }
}
