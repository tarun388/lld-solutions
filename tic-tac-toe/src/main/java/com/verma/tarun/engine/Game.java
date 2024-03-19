package com.verma.tarun.engine;

import com.verma.tarun.model.Move;
import com.verma.tarun.model.Player;
import com.verma.tarun.model.board.Board;
import com.verma.tarun.model.board.BoardView;
import com.verma.tarun.model.board.ConsoleBoardView;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Game {
    private Deque<Player> players;
    private final Board board;
    private BoardView view;
    private GameBoardValidator validator;

    public Game() {
        board = new Board(3);
        validator = new GameBoardValidator(board);
        view = new ConsoleBoardView(board);
        players = new ArrayDeque<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void start() {
        while (true) {
            view.view();
            Move move = nextMove();
            if (validator.isGameEnd(move)) {
                view.view();
                System.out.println("Game ended. Player " + move.getPlayedBy().getName() + " wins");
                break;
            } else if (validator.isTie()) {
                view.view();
                System.out.println("Game ended. Tied.");
                break;
            }
        }
    }

    private Move nextMove() {
        Scanner scanner = new Scanner(System.in);
        Player player = players.getFirst();
        Move move;
        while (true) {
            System.out.println("Enter next move");
            String[] input = scanner.nextLine().split(" ");
            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);
            move = new Move(player.getPiece(), row, col, player);
            if (!validator.isValidMove(move)) {
                System.out.println("Invalid move");
            } else {
                board.addPiece(move);
                break;
            }
        }
        players.pop();
        players.add(player);

        return move;
    }
}
