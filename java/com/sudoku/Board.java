package com.sudoku;

/**
 * Created by LINHBOB on 11/11/2016.
 */

//Interface acts like a data storage
public interface Board {
    //comment this when using Puzzle
    int[][] matrix = new int[9][9];

    boolean[][] editable = {
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

    //Sudoku Puzzle 1
    /*int[][] matrix = {
            {0,8,0,4,0,2,0,6,0},
            {0,3,4,0,0,0,9,1,0},
            {9,6,0,0,0,0,0,8,4},
            {0,0,0,2,1,6,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,3,5,7,0,0,0},
            {8,4,0,0,0,0,0,7,5},
            {0,2,6,0,0,0,1,3,0},
            {0,9,0,7,0,1,0,4,0}
    };*/

    //Sudoku Puzzle 2
    /*int[][] matrix = {
            {0,0,0,0,0,0,0,0,0},
            {0,0,7,5,0,3,1,0,0},
            {0,3,0,0,1,0,0,5,0},
            {0,4,0,3,0,8,0,6,0},
            {0,0,3,0,6,0,2,0,0},
            {0,9,0,7,0,1,0,4,0},
            {0,6,0,0,5,0,0,1,0},
            {0,0,4,9,0,7,8,0,0},
            {0,0,0,0,0,0,0,0,0}
    };*/

}
