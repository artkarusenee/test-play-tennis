package com.tennis.playrecord.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by art on 7/8/2017.
 */
public class DefaultGameTennisPlayRecordDataReader implements GameTennisPlayRecordDataReadable {

    public GameTennisPlayRecord load(String path) throws Exception {
        GameTennisPlayRecord records;
        try {

            BufferedReader reader = new BufferedReader(new FileReader(path));

            String line;
            List<GameRecord> games = new ArrayList<GameRecord>();

            while((line = reader.readLine()) != null){

                if(line.matches("^GAME\\d:( (A|B))+")){
                       String[] tmp = line.split(": ");

                       GameRecord game = new GameRecord();
                       List<PlayRecord> plays = new ArrayList<PlayRecord>();

                       for (String play:
                               tmp[1].split(" ")) {
                           plays.add(new PlayRecord(play));
                       }

                       game.setPlays(plays);
                       games.add(game);
                }
                else{
                    throw new Exception("file invalid format");
                }

            }

            if(games.size() > 0){
                records = new GameTennisPlayRecord();
                records.setGames(games);
            }
            else{
                throw new Exception("Must play at least one game");
            }

        }
        catch (FileNotFoundException ex){
            throw new Exception("file not found");
        }
        catch (Exception ex){
            throw ex;
        }

        return records;
    }
}
