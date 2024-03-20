package com.verma.tarun.model;

import com.verma.tarun.model.piece.Piece;

public class Move {
    private Piece piece;
    private int row;
    private int col;
    private com.verma.tarun.model.Player playedBy;

    public Move(Piece piece, int row, int col, com.verma.tarun.model.Player playedBy) {
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

    public com.verma.tarun.model.Player getPlayedBy() {
        return playedBy;
    }
}
