package com.tennis;

import com.tennis.playrecord.data.DefaultGameTennisPlayRecordDataReader;
import com.tennis.playrecord.data.GameTennisPlayRecord;
import com.tennis.playrecord.data.GameTennisPlayRecordDataReadable;
import com.tennis.playrecord.result.DefaultGameTennisPlayRecordShow;
import com.tennis.playrecord.result.GameTennisPlayRecordShowable;

/**
 * App for running Game Tennis
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        if(args.length ==  0) {
            System.out.println("Please specify input file path");
            System.exit(1);
        }

        String path = args[0];

        if(path != null){

            try {
                GameTennisPlayRecordDataReadable reader = new DefaultGameTennisPlayRecordDataReader();
                GameTennisPlayRecord record = reader.load(path);

                GameTennisPlayRecordShowable showing = new DefaultGameTennisPlayRecordShow();
                showing.show(record);

            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }

    }
}
