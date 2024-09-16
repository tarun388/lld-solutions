package com.verma.tarun.sudoku;

import java.util.Arrays;

public class Sudoku {
    int size;
    int[][] board;
    int[][] solution;

    public Sudoku(int size, int[][] board) {
        this.size = size;
        this.board = board;
        this.solution = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
    }

    boolean solve(int i, int j) {
//        System.out.println(i + " " + j);
        boolean solved = false;
        if (board[i][j] != 0) {
            solution[i][j] = board[i][j];
            if (j+1 < size) {
                solved = solved || solve(i, j+1);
            } else if (i+1 < size) {
                solved = solved || solve(i+1, 0);
            } else {
                return true;
            }
        } else {
            solved = false;
            for (int value = 1; value <= 9; value++) {
                if (isValid(i, j, value)) {
                    solution[i][j] = value;
                    if (j+1 < size) {
                        solved = solved || solve(i, j+1);
                    } else if (i+1 < size) {
                        solved = solved || solve(i+1, 0);
                    } else {
                        return true;
                    }
                    if (solved) return true;
                    solution[i][j] = 0;
                }
            }
        }
        return solved;
    }

    boolean isValid(int row, int col, int value) {
        // No cell in row already has value
        for (int i = 0; i < size; i++) {
            if (solution[row][i] == value) return false;
        }

        // No cell in col already has value
        for (int i = 0; i < size; i++) {
            if (solution[i][col] == value) return false;
        }

        // No cell in block/region defined by regionX and regionY already has value
        int regionX = (row / 3) * 3;
        int regionY = (col / 3) * 3;
        for (int i = regionX; i < regionX + 3 ;i++) {
            for (int j = regionY; j < regionY + 3 ;j++) {
                if (solution[i][j] == value) return false;
            }
        }

        return true;
    }

    void display() {
        for (int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }
}
