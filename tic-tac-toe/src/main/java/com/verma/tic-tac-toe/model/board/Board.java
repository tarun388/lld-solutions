package com.verma.tarun.model.board;

import com.verma.tarun.model.Move;
import com.verma.tarun.model.piece.Piece;

public class Board {
    private int size;
    private Piece[][] board;

    public Board(int size) {
        this.size = size;
        board = new Piece[size][size];
    }

    public void addPiece(Move move) {
        board[move.getRow()][move.getCol()] = move.getPiece();
    }

    public int getSize() {
        return size;
    }

    public Piece getPieceAt(int row, int col) {
        return board[row][col];
    }

}
