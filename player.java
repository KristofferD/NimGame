package NimGame;

import java.util.Random;
import java.util.Scanner;

class player{

    private String playerName;
    private boolean humanPlayer;

    public player(String playerName, boolean human) {
        this.playerName = playerName;
        this.humanPlayer = human;
    }

    public String getName(){
        return playerName;
    }

    public boolean isHumanPlayer(){
        return humanPlayer;
    }
}
