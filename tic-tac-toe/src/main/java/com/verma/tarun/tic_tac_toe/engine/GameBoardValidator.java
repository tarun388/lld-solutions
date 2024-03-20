package com.verma.tarun.tic_tac_toe.engine;

import com.verma.tarun.tic_tac_toe.model.Move;
import com.verma.tarun.tic_tac_toe.model.board.Board;
import com.verma.tarun.tic_tac_toe.model.piece.Piece;

public class GameBoardValidator {
    private Board board;

    public GameBoardValidator(Board board) {
        this.board = board;
    }

    public boolean isGameEnd(Move move) {
        int size = board.getSize();
        boolean isEnd = true;
        // row check
        for (int col = 0; col < size; col++) {
            isEnd = isEnd && board.getPieceAt(move.getRow(), col) == move.getPiece();
        }
        if (isEnd) return isEnd;

        // col check
        isEnd = true;
        for (int row = 0; row < size; row++) {
            isEnd = isEnd && board.getPieceAt(row, move.getCol()) == move.getPiece();
        }
        if (isEnd) return isEnd;

        // left diagonal
        isEnd = true;
        for (int row = 0; row < size; row++) {
            isEnd = isEnd && board.getPieceAt(row, row) == move.getPiece();
        }
        if (isEnd) return isEnd;

        // right diagonal
        isEnd = true;
        for (int row = 0; row < size; row++) {
            isEnd = isEnd && board.getPieceAt(row, size - 1 - row) == move.getPiece();
        }

        return isEnd;
    }

    public boolean isTie() {
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.getPieceAt(i, j) == null) return false;
            }
        }
        return true;
    }

    public boolean isValidMove(Move move) {
        int size = board.getSize();
        int row = move.getRow();
        int col = move.getCol();
        Piece piece = move.getPiece();
        return !(row < 0 || row >= size || col < 0 || col >= size || board.getPieceAt(row, col) != null);
    }
}
