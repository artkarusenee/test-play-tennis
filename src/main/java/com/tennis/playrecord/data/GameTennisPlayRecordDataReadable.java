package com.tennis.playrecord.data;

/**
 * Created by art on 7/8/2017.
 */
public interface GameTennisPlayRecordDataReadable {
    GameTennisPlayRecord load(String path) throws Exception;
}
