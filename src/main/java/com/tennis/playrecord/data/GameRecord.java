package com.tennis.playrecord.data;

import java.util.List;

/**
 * Created by art on 7/8/2017.
 */
public class GameRecord {
    private List<PlayRecord> plays;

    public List<PlayRecord> getPlays() {
        return plays;
    }

    public void setPlays(List<PlayRecord> plays) {
        this.plays = plays;
    }
}
