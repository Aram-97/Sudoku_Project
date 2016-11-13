package com.sudoku;

import java.awt.event.ActionEvent;

/**
 * Created by LINHBOB on 11/13/2016.
 */
//Child class of Buttons
public class Clear extends Buttons implements Board{
    private void clearAll(){
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                matrix[row][col] = 0;
                editable[row][col] = true;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clearAll();
        SudokuGUI.update();
    }
}
