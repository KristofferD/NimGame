package NimGame;

import java.util.Scanner;

public class humanPlayer extends player {
    public humanPlayer(String name) {
        super(name, true);
    }

    public int getMove(int pileSize) {
        Scanner input = new Scanner(System.in);
        int move = 0;
        boolean valid = false;
        while (!valid) {
            System.out.printf("Player %s, how many sticks do you pick from the pile?\n", getName());
            move = input.nextInt();
            if (move >= 1 && move <= Math.min(gameHandler.halfPile(pileSize), pileSize)) {
                valid = true;
            } else {
                System.out.printf("Invalid move. Please enter a number between 1 and %d.\n", Math.min(gameHandler.halfPile(pileSize), pileSize));
            }
        }
        return move;
    }
}
