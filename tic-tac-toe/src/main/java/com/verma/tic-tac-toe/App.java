package com.verma.tarun;

import com.verma.tarun.engine.Game;
import com.verma.tarun.model.Player;
import com.verma.tarun.model.piece.PieceO;
import com.verma.tarun.model.piece.PieceX;

public class App {
    public static void main(String[] args) {
        Player player1 = new Player(new PieceX(), "player1");
        Player player2 = new Player(new PieceO(), "player2");

        Game game = new Game();
        game.addPlayer(player1);
        game.addPlayer(player2);

        game.start();
    }
}
