package live.mukeshtechlab.models;


import live.mukeshtechlab.services.BotPlayingStrategyFactory;
import live.mukeshtechlab.services.strategies.botPlayingStrategy.BotPlayingStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel){
        super(name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Cell makeMove(Board board){
        System.out.println(this.getName() + "'s turn");
        BotPlayingStrategy botPlayingStrategy = BotPlayingStrategyFactory.getBolPlayingStrategy(BotDifficultyLevel.EASY);
        return botPlayingStrategy.botPlay(board);
    }
}
