package live.mukeshtechlab.services.strategies.winningStrategy;

import live.mukeshtechlab.models.*;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy {

    private Map<Symbol, Integer> leftDiagonal;
    private Map<Symbol, Integer> rightDiagonal;

    public DiagonalWinningStrategy() {
        leftDiagonal = new HashMap<>();
        rightDiagonal = new HashMap<>();
    }

    @Override
    public boolean isWinning(Board board, Move move) {
        Symbol symbol = move.getPlayer().getSymbol();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        // If left diagonal
        if (row == col) {
            leftDiagonal.put(symbol, leftDiagonal.getOrDefault(symbol, 0) + 1);
            return leftDiagonal.get(symbol) == board.getDimension();
        }

        // if right diagonal
        if (row + col == board.getDimension() - 1) {
            rightDiagonal.put(symbol, rightDiagonal.getOrDefault(symbol, 0) + 1);
            return rightDiagonal.get(symbol) == board.getDimension();
        }

        return false;

    }

}

