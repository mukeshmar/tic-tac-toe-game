package live.mukeshtechlab;

import live.mukeshtechlab.controllers.GameController;
import live.mukeshtechlab.models.*;
import live.mukeshtechlab.services.strategies.winningStrategy.ColumnWinningStrategy;
import live.mukeshtechlab.services.strategies.winningStrategy.DiagonalWinningStrategy;
import live.mukeshtechlab.services.strategies.winningStrategy.RowWinningStrategy;
import live.mukeshtechlab.services.strategies.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        System.out.println("Let's Play Tic Tac Toe!");

        List<Player> players = new ArrayList<>();
        players.add(new Player("Mukesh", new Symbol('M'), PlayerType.HUMAN));
//        players.add(new Player("Saumya", new Symbol('S'), PlayerType.HUMAN));
        players.add(new Bot("Saumya", new Symbol('S'), BotDifficultyLevel.EASY));

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        GameController gameController = new GameController();
        gameController.startGame(players, winningStrategies);

        while (gameController.getGameState() == GameState.IN_PROGRESS) {
            gameController.printBoard();
            gameController.makeMove();
        }

        // Game Over
        System.out.println("Game Over");
        gameController.printBoard();

        if (gameController.getGameState() == GameState.ENDED) {
            System.out.println("Winner is: " + gameController.getWinner().getName());
        } else if (gameController.getGameState() == GameState.DRAW) {
            System.out.println("It's a draw!");
        }

    }
}
