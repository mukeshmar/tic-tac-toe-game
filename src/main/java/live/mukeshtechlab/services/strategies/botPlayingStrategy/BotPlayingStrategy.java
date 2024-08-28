package live.mukeshtechlab.services.strategies.botPlayingStrategy;

import live.mukeshtechlab.models.Board;
import live.mukeshtechlab.models.Cell;

public interface BotPlayingStrategy {
    Cell botPlay(Board board);
}
