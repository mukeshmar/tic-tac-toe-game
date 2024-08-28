package live.mukeshtechlab.services.strategies.botPlayingStrategy;

import live.mukeshtechlab.models.Board;
import live.mukeshtechlab.models.Cell;
import live.mukeshtechlab.models.CellState;

import java.util.Random;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Cell botPlay(Board board) {
        int row;
        int col;
        Random randon = new Random();

        do{
            row = randon.nextInt(board.getDimension());
            col = randon.nextInt(board.getDimension());
        } while (board.getBoard().get(row).get(col).getCellState() != CellState.EMPTY);

        return new Cell(row, col);
    }
}
