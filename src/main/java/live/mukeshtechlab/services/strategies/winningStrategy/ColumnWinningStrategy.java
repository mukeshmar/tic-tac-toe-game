package live.mukeshtechlab.services.strategies.winningStrategy;

import live.mukeshtechlab.models.*;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy {
    private Map<Integer, Map<Symbol, Integer>> colSymbolCount;

    public ColumnWinningStrategy() {
        this.colSymbolCount = new HashMap<>();
    }

    @Override
    public boolean isWinning(Board board, Move move) {

        Symbol symbol = move.getPlayer().getSymbol();
        int column = move.getCell().getCol();

        // Initialize the column map if it doesn't exist
        if (!colSymbolCount.containsKey(column)) {
            colSymbolCount.put(column, new HashMap<>());
        }

        // Get the symbol count map for the current column
        Map<Symbol, Integer> countSymbolColumn = colSymbolCount.get(column);

        // Increment the symbol count
        int countSymbol = countSymbolColumn.getOrDefault(symbol, 0) + 1;
        countSymbolColumn.put(symbol, countSymbol);

        // Check if the symbol count equals the board dimension
        return countSymbol == board.getDimension();

    }
}
