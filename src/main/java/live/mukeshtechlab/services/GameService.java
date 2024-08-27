package live.mukeshtechlab.services;

import live.mukeshtechlab.models.*;
import live.mukeshtechlab.services.strategies.winningStrategy.WinningStrategy;

import java.util.List;

public class GameService {
    private Game game;

    public void startGame(List<Player> players, List<WinningStrategy> winningStrategies) {
        game = Game.builder()
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();

    }

    public void makeMove() {
        // Get the current player based on the next player index
        Player currentPlayer = game.getPlayers().get(game.getNextPlayerIndex());

        // Ask the current player to make a move on the board
        Cell moveCell = currentPlayer.makeMove(game.getBoard());

        // Update Cell state in Board
        int row = moveCell.getRow(); // Get the row of the cell marked by the current player
        int col = moveCell.getCol(); // Get the column of the cell marked by the current player
        Cell currentCell = game.getBoard().getBoard().get(row).get(col); // Get the cell object from the board
        currentCell.setCellState(CellState.FILLED); // Mark the cell as filled
        currentCell.setPlayer(currentPlayer); // Set the player who filled the cell

        // Create a new Move object and add it to the game's move list
        Move finalMove = new Move(currentPlayer, currentCell);
        game.getMoves().add(finalMove);

        // Set the next Player Index
        int nextPlayerIndex = game.getNextPlayerIndex();
        int totalPlayers = game.getPlayers().size();
        nextPlayerIndex = (nextPlayerIndex + 1) % totalPlayers;
        game.setNextPlayerIndex(nextPlayerIndex); // Set the updated next player index
    }

    public GameState getGameState() {
        return game.getGameState();
    }

    public Player getWinner() {
        return game.getWinner();
    }

    public void printBoard() {
        game.getBoard().printBoard();
    }
}
