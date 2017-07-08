package com.tennis.playrecord.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by art on 7/8/2017.
 */
public class DefaultGameTennisPlayRecordDataReader implements GameTennisPlayRecordDataReadable {

    public GameTennisPlayRecord load(String path) throws Exception {
        GameTennisPlayRecord records = null;
        try {

            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;

            while((line = reader.readLine()) != null){

                if(line.matches("^GAME\\d:( (A|B))+")){
                       String[] tmp = line.split(":");
                       String game = tmp[0];
                       String[] plays = tmp[1].split(" ");



                }
                else{
                    throw new Exception("file invalid format");
                }

            }

            records = new GameTennisPlayRecord();
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
