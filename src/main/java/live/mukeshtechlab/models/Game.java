package live.mukeshtechlab.models;

import live.mukeshtechlab.services.strategies.winningStrategy.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Game {
    private List<Player> players;
    private Board board;
    private Player winner;
    private List<Move> moves;
    private GameState gameState;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(List<Player> players, List<WinningStrategy> winningStrategies){
        this.players = players;
        this.board = new Board(players.size() + 1);
        this.winningStrategies = winningStrategies;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;

        // Random player turn for the first time, then it will be sequential.
        Random random = new Random();
        this.nextPlayerIndex = random.nextInt(players.size());
    }

    // Builder
    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies){
            this.winningStrategies = winningStrategies; 
            return this; 
        }
        
        public Game build(){
            validate();
            return new Game(players, winningStrategies); 
        }

        private void validate() {
            if(players == null || players.size() > 2){
                throw new IllegalArgumentException("At least 2 players are required to start the game");
            }
            if(winningStrategies == null || winningStrategies.isEmpty()){
                throw new IllegalArgumentException("At least 1 winning strategy is required to start the game");
            }

            // We can add more validations here
        }
    }
}
