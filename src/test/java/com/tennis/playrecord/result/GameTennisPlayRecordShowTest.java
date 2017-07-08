package com.tennis.playrecord.result;

import com.tennis.playrecord.data.GameRecord;
import com.tennis.playrecord.data.GameTennisPlayRecord;
import com.tennis.playrecord.data.PlayRecord;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by art on 7/8/2017.
 */
public class GameTennisPlayRecordShowTest {

    GameTennisPlayRecordShowable showing;

    public GameTennisPlayRecordShowTest(){
        showing = new DefaultGameTennisPlayRecordShow();
    }

    @Test
    public void testShowNormal(){
        GameTennisPlayRecord record = new GameTennisPlayRecord();
        GameRecord game1 = new GameRecord();
        List<PlayRecord> plays1 = new ArrayList<PlayRecord>();
        plays1.add(new PlayRecord("A"));
        plays1.add(new PlayRecord("A"));
        plays1.add(new PlayRecord("A"));
        plays1.add(new PlayRecord("A"));
        game1.setPlays(plays1);

        GameRecord game2 = new GameRecord();
        List<PlayRecord> plays2 = new ArrayList<PlayRecord>();
        plays2.add(new PlayRecord("A"));
        plays2.add(new PlayRecord("B"));
        plays2.add(new PlayRecord("A"));
        plays2.add(new PlayRecord("B"));
        plays2.add(new PlayRecord("A"));
        plays2.add(new PlayRecord("A"));
        game2.setPlays(plays2);

        List<GameRecord> games = new ArrayList<GameRecord>();
        games.add(game1);
        games.add(game2);

        record.setGames(games);

        showing.show(record);

    }

    @Test
    public void testShowWithDUCE(){
        GameTennisPlayRecord record = new GameTennisPlayRecord();

        GameRecord game3 = new GameRecord();
        List<PlayRecord> plays3 = new ArrayList<PlayRecord>();
        plays3.add(new PlayRecord("B"));
        plays3.add(new PlayRecord("B"));
        plays3.add(new PlayRecord("A"));
        plays3.add(new PlayRecord("A"));
        plays3.add(new PlayRecord("A"));
        plays3.add(new PlayRecord("B"));
        plays3.add(new PlayRecord("A"));
        plays3.add(new PlayRecord("B"));
        plays3.add(new PlayRecord("B"));
        plays3.add(new PlayRecord("B"));
        game3.setPlays(plays3);

        List<GameRecord> games = new ArrayList<GameRecord>();
        games.add(game3);

        record.setGames(games);

        showing.show(record);

    }

}
