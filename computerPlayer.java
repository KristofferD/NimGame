package NimGame;

import java.util.Random;

public class computerPlayer extends player {
    public computerPlayer(String name) {
        super(name, false);
    }

    public int getMove(int pileSize) {
        Random rand = new Random();
        int move = rand.nextInt(gameHandler.halfPile(pileSize)) + 1;
        return move;
    }
}

