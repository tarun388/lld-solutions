package com.verma.tarun.tic_tac_toe.model.piece;

public class Piece {
    private PieceType type;

    public Piece(PieceType type) {
        this.type = type;
    }

    public PieceType getType() {
        return type;
    }
}
