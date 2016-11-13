package com.sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by LINHBOB on 11/12/2016.
 */
//Child class of Buttons.java
public class Solve extends Buttons implements Board{
    private boolean solve(int i, int j, int[][]cell){
        if(i == 9){
            i = 0;
            if(++j == 9)
                return true;
        }
        if(cell[i][j] != 0)
            return solve(i+1,j,cell);

        for(int val = 1;val <= 9;++val){
            if(isValid(i,j,val,cell)){
                cell[i][j] = val;
                if(solve(i+1,j,cell))
                    return true;
            }
        }
        cell[i][j] = 0;

        return false;
    }

    private boolean isValid(int i, int j, int val, int[][]cell){
        for(int k = 0;k < 9;++k)
            if(val == cell[k][j])
                return false;

        for(int k = 0;k < 9;++k)
            if(val == cell[i][k])
                return false;

        int boxRowOffset = (i/3)*3;
        int boxColOffset = (j/3)*3;
        for(int k = 0;k < 3;++k)
            for(int m = 0;m < 3;++m)
                if(val == cell[boxRowOffset+k][boxColOffset+m])
                    return false;

        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(solve(0,0,matrix))
            SudokuGUI.update(); //class method -> no need to instantiated or extended
        else {
            JOptionPane.showMessageDialog(null,"Invalid! Matrix contains duplicated numbers");
        }
    }
}
