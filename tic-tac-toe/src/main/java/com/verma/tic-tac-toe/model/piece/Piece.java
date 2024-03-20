package com.verma.tarun.model.piece;

public class Piece {
    private com.verma.tarun.model.piece.PieceType type;

    public Piece(com.verma.tarun.model.piece.PieceType type) {
        this.type = type;
    }

    public com.verma.tarun.model.piece.PieceType getType() {
        return type;
    }
}
