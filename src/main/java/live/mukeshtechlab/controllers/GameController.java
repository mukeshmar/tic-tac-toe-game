package live.mukeshtechlab.controllers;

import live.mukeshtechlab.models.Game;
import live.mukeshtechlab.models.GameState;
import live.mukeshtechlab.models.Player;
import live.mukeshtechlab.services.GameService;
import live.mukeshtechlab.services.strategies.winningStrategy.WinningStrategy;

import java.util.List;

public class GameController {

    private GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    public void startGame(List<Player> players, List<WinningStrategy> winningStrategies) {
        gameService.startGame(players, winningStrategies);
    }

    public void makeMove() {
        gameService.makeMove();
    }

    public GameState getGameState() {
        return gameService.getGameState();
    }

    public Player getWinner() {
        return gameService.getWinner();
    }

    public void printBoard() {
        gameService.printBoard();
    }

}
