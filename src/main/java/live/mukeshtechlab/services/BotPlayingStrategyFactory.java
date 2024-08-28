package live.mukeshtechlab.services;

import live.mukeshtechlab.models.BotDifficultyLevel;
import live.mukeshtechlab.services.strategies.botPlayingStrategy.BotPlayingStrategy;
import live.mukeshtechlab.services.strategies.botPlayingStrategy.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBolPlayingStrategy(BotDifficultyLevel level){
        if(level.equals(BotDifficultyLevel.EASY)){
            return new EasyBotPlayingStrategy();
        }
        else if(level.equals(BotDifficultyLevel.MEDIUM)){
            return null;
        }
        else if(level.equals(BotDifficultyLevel.HARD)){
            return null;
        }
        return null;
    }
}
