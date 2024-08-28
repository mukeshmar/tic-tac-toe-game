package live.mukeshtechlab.services.strategies.winningStrategy;

import live.mukeshtechlab.models.Board;
import live.mukeshtechlab.models.Move;

public interface WinningStrategy {
    boolean isWinning(Board board, Move move);
}
