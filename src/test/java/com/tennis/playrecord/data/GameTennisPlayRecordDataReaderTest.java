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
        Assert.assertNotNull(dataReader.load(inputPath.getPath()));
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
}
