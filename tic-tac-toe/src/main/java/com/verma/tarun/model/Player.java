package com.verma.tarun.model;

import com.verma.tarun.model.piece.Piece;

public class Player {
    private Piece piece;
    private String name;

    public Player(Piece piece, String name) {
        this.piece = piece;
        this.name = name;
    }

    public Piece getPiece() {
        return piece;
    }

    public String getName() {
        return name;
    }
}
