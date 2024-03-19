package com.verma.tarun.model.board;

import com.verma.tarun.model.piece.Piece;

public class ConsoleBoardView implements BoardView {
    private Board board;

    public ConsoleBoardView(Board board) {
        this.board = board;
    }

    @Override
    public void view() {
        int size = board.getSize();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Piece piece = board.getPieceAt(row, col);
                String p = piece == null ? " " : piece.getType().toString();
                System.out.print(p);
                if (col < size - 1) {
                    System.out.print(" |");
                }
            }
            System.out.println();
            if (row < size - 1) {
                System.out.println("________");
            }
        }
    }
}
