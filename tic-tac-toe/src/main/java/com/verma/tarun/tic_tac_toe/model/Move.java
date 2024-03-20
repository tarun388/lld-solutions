package com.verma.tarun.tic_tac_toe.model;

import com.verma.tarun.tic_tac_toe.model.piece.Piece;

public class Move {
    private Piece piece;
    private int row;
    private int col;
    private Player playedBy;

    public Move(Piece piece, int row, int col, Player playedBy) {
        this.piece = piece;
        this.row = row;
        this.col = col;
        this.playedBy = playedBy;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Player getPlayedBy() {
        return playedBy;
    }
}
