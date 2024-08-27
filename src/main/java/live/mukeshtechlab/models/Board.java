package live.mukeshtechlab.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    private int dimension;
    private List<List<Cell>> board;

    public Board(int dimension){
        this.dimension = dimension;
        this.board = new ArrayList<>();
        for(int i = 0; i<dimension; i++){
            List<Cell> row = new ArrayList<>();
            for(int j = 0; j<dimension; j++){
                row.add(new Cell(i, j));
            }
            this.board.add(row);
        }
    }

    public void printBoard(){
        for(List<Cell> row : this.board){
            for(Cell cell : row){
                if(cell.getCellState() == CellState.EMPTY){
                    System.out.println("| |");
                }
                else {
                    System.out.println("| " + cell.getPlayer().getSymbol().getSymbol() + " |");
                }
            }
        }
    }

}
