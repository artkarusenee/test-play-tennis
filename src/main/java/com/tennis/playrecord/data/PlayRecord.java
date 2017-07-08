package com.tennis.playrecord.data;

/**
 * Created by art on 7/8/2017.
 */
public class PlayRecord {

    private String playerWin;

    public PlayRecord(String playerWin){
        this.playerWin = playerWin;
    }

    public String getPlayerWin() {
        return playerWin;
    }

    public void setPlayerWin(String playerWin) {
        this.playerWin = playerWin;
    }
}
