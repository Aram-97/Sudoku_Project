package com.sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by LINHBOB on 11/12/2016.
 */
//Child class of Buttons
public class userInput extends Buttons implements Board{
    private JPanel panel;
    private JPanel label;
    private JPanel field;

    public void input(){
        panel = new JPanel(new BorderLayout(5,5));
        label = new JPanel(new GridLayout(0,1,5,5));
        field = new JPanel(new GridLayout(0,1,5,5));

        label.add(new JLabel("Row index"));
        label.add(new JLabel("Column index"));
        label.add(new JLabel("Cell value"));

        JTextField rowInput = new JTextField();
        JTextField colInput = new JTextField();
        JTextField valInput = new JTextField();
        field.add(rowInput);
        field.add(colInput);
        field.add(valInput);

        panel.add(label,BorderLayout.WEST);
        panel.add(field,BorderLayout.CENTER);

        int option = JOptionPane.showConfirmDialog(null,panel,"Enter coordinates and value",JOptionPane.OK_CANCEL_OPTION);
        if(option == JOptionPane.OK_OPTION){
            int row = Integer.parseInt(rowInput.getText());
            int col = Integer.parseInt(colInput.getText());
            int val = Integer.parseInt(valInput.getText());
            matrix[row][col] = val;
            editable[row][col] = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        input();
        SudokuGUI.update(); //class method -> no need to instantiated or extended
    }
}
