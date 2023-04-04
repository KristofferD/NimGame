package NimGame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class playerHandler {

    private ArrayList<player> players;

    public playerHandler(int players, int humans) {
        this.players = new ArrayList<player>();
        for (int i = 1; i <= humans; i++) {
            addHumanPlayer(i);
        }
        int computers = players - humans;
        for (int i = 1; i <= computers; i++) {
            addComputer(i);
        }
    }

    public int getTotalPlayers() {
        return players.size();
    }

    public String currentPlayerName(int turn) {
        int arrayPosition = turn % getTotalPlayers();
        return players.get(arrayPosition).getName();
    }

    public boolean humanPlayer(int turn) {
        int arrayPosition = turn % getTotalPlayers();
        return players.get(arrayPosition).isHumanPlayer();
    }

    private void addHumanPlayer(int var1) {
        Scanner input = new Scanner(System.in);
        System.out.println("Name of player " + var1);
        String name = input.nextLine();
        player tempObj = new humanPlayer(name);
        players.add(tempObj);
    }

    private void addComputer(int i) {
        String name = "PC player " + i;
        player tempObj = new computerPlayer(name);
        players.add(tempObj);
    }

    public void humanPlayerLogic(int turn, int pileSize) {
        Scanner input = new Scanner(System.in);
        int move = 0;
        boolean valid = false;
        while (!valid) {
            System.out.printf("Player %s, how many sticks do you pick from the pile?\n", currentPlayerName(turn));
            move = input.nextInt();
            if (move >= 1 && move <= Math.min(gameHandler.halfPile(pileSize), pileSize)) {
                valid = true;
            } else {
                System.out.printf("Invalid move. Please enter a number between 1 and %d.\n", Math.min(gameHandler.halfPile(pileSize), pileSize));
            }
        }
        validateMove(move);
    }

    public void computerPlayerLogic(int turn, int pileSize) {
        Random rand = new Random();
        int move = rand.nextInt(gameHandler.halfPile(pileSize)) + 1;
        validateMove(move);
    }

    private static boolean validateMove(int reduceSize) {
        if (reduceSize < 1) {
            System.out.println("You can't pick up less than one!");
            return false;
        } else {
            return true;
        }
    }

    public int halfPile(int pileSize) {
        return (pileSize / 2);
    }
}
