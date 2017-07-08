package com.tennis.playrecord.data;

import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.net.URL;

/**
 * Created by art on 7/8/2017.
 */
public class GameTennisPlayRecordDataReaderTest {

    GameTennisPlayRecordDataReadable dataReader;

    public GameTennisPlayRecordDataReaderTest(){
        dataReader = new DefaultGameTennisPlayRecordDataReader();
    }

    @Test
    public void testLoadSuccess() throws Exception{
        URL inputPath = this.getClass().getResource("/inputfiles/correct_input.txt");

        GameTennisPlayRecord record = dataReader.load(inputPath.getPath());

        Assert.assertNotNull(record);
        Assert.assertTrue(record.getGames().size() == 3);
        Assert.assertTrue(record.getGames().get(0).getPlays().size() == 4);
        Assert.assertTrue(record.getGames().get(1).getPlays().size() == 6);

        Assert.assertTrue("A".equals(record.getGames().get(0).getPlays().get(0).getPlayerWin()));
        Assert.assertTrue("A".equals(record.getGames().get(0).getPlays().get(1).getPlayerWin()));
        Assert.assertTrue("A".equals(record.getGames().get(1).getPlays().get(0).getPlayerWin()));
        Assert.assertTrue("B".equals(record.getGames().get(1).getPlays().get(1).getPlayerWin()));

    }

    @Test(expected = Exception.class)
    public void testLoadMissingFile() throws Exception{
        dataReader.load("");
    }

    @Test(expected = Exception.class)
    public void testLoadInvalidFile() throws Exception{
        URL inputPath = this.getClass().getResource("/inputfiles/invalid_input.txt");
        dataReader.load((inputPath).getPath());
    }

    @Test(expected = Exception.class)
    public void testLoadZeroGameData() throws  Exception{
        URL inputPath = this.getClass().getResource("/inputfiles/zero_game.txt");
        dataReader.load((inputPath).getPath());
    }
}
