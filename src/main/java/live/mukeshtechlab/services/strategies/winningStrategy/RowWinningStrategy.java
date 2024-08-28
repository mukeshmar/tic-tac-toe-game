package live.mukeshtechlab.services.strategies.winningStrategy;

import live.mukeshtechlab.models.Board;
import live.mukeshtechlab.models.Cell;
import live.mukeshtechlab.models.Move;
import live.mukeshtechlab.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {

    // Map to store Symbol count in every row
    private Map<Integer, Map<Symbol, Integer>> rowSymbolCountMap;

    public RowWinningStrategy() {
        rowSymbolCountMap = new HashMap<>();
    }

    @Override
    public boolean isWinning(Board board, Move move) {

        Symbol symbol = move.getPlayer().getSymbol();
        int row = move.getCell().getRow();

        if (!rowSymbolCountMap.containsKey(row)) {
            rowSymbolCountMap.put(row, new HashMap<>());
        }

        Map<Symbol, Integer> rowSymbolCount = rowSymbolCountMap.get(row);
        int countSymbol = rowSymbolCount.getOrDefault(symbol, 0) + 1;
        rowSymbolCount.put(symbol, countSymbol);

        return countSymbol == board.getDimension();

    }
}
