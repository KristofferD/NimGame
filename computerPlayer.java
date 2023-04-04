//studentid krda1698 @ Uppsala University
//e-post: k.danbrant@icloud.com

import java.util.Random;
package NimGame;

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

