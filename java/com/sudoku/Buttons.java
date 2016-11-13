package com.sudoku;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by LINHBOB on 11/12/2016.
 */
//Parent class of Solve.java & userInput.java
//Is an abstract class
public abstract class Buttons implements ActionListener {
    public JButton BUTTON;
    public abstract void actionPerformed(ActionEvent e);
}
