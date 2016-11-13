/**
 * Created by LINHBOB on 11/6/2016.
 */
import com.sudoku.*;

import javax.swing.*;

public class Sudoku implements Board{
    public static void main(String[] args) {
        SudokuGUI gui = new SudokuGUI();

        //Polymorphism
        Buttons[] button = new Buttons[3];
        button[0] = new Solve();
        button[1] = new userInput();
        button[2] = new Clear();

        gui.buttonPanel.add(button[0].BUTTON = new JButton("Solve"));
        gui.buttonPanel.add(button[1].BUTTON = new JButton("Input"));
        gui.buttonPanel.add(button[2].BUTTON = new JButton("Clear"));


        //uncomment this when using the example
        /*for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (matrix[row][col] != 0)
                    editable[row][col] = false;
            }
        }*/

        gui.update();

        button[0].BUTTON.addActionListener(button[0]);
        button[1].BUTTON.addActionListener(button[1]);
        button[2].BUTTON.addActionListener(button[2]);
    }
}
