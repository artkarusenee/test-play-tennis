package com.tennis.playrecord.result;

import com.tennis.playrecord.data.GameRecord;
import com.tennis.playrecord.data.GameTennisPlayRecord;
import com.tennis.playrecord.data.PlayRecord;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by art on 7/8/2017.
 */
public class DefaultGameTennisPlayRecordShow implements GameTennisPlayRecordShowable {

    static String[] MASTER_SCORES = {"","15", "30", "40", "WIN"};
    static String[] ADV_SCORES = {"DUCE","ADV","WIN"};

    public void show(GameTennisPlayRecord record) {
        int gameCount = 1;
        for (GameRecord game:
             record.getGames()) {

            Map<String,Integer> scores = initScore();

            System.out.println("GAME" + gameCount);

            for (PlayRecord play:
                 game.getPlays()) {

                scores.put(play.getPlayerWin(), scores.get(play.getPlayerWin()) + 1);

                if(scores.get("A") >= 3 && scores.get("B") >= 3){

                    showAdvScore(play, scores);
                }
                else{
                    showNormalScore(play, scores);                }

            }
            System.out.println();
            gameCount++;
        }
    }

    private Map<String, Integer> initScore(){
        Map<String,Integer> scores = new HashMap<String,Integer>();
        scores.put("A",0);
        scores.put("B",0);

        return scores;
    }

    private void showNormalScore(PlayRecord play, Map<String,Integer> scores){
        System.out.println(play.getPlayerWin() + ":" + MASTER_SCORES[scores.get(play.getPlayerWin())]);
    }

    private void showAdvScore(PlayRecord play, Map<String,Integer> scores){
        int advFlag = 0;
        if((scores.get("A") == scores.get("B") + 2) ||
                (scores.get("B") == scores.get("A") + 2)){
            advFlag = 2;
        }
        else if((scores.get("A") == scores.get("B") + 1) ||
                (scores.get("B") == scores.get("A") + 1)){
            advFlag = 1;
        }
        else{
            advFlag = 0;
        }

        System.out.println(advFlag == 0? ADV_SCORES[advFlag] : play.getPlayerWin() + ":" + ADV_SCORES[advFlag]);

    }

}
