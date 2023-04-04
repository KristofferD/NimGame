//studentid krda1698 @ Uppsala University
//e-post: k.danbrant@icloud.com

package NimGame;

public class gameHandler {
    private int pileSize;
    private playerHandler gamesPlayerHandler;
    private int turnNumber;

    public gameHandler(int pileStartSize, int players, int human) {
        this.turnNumber = 0;
        this.pileSize = pileStartSize;
        gamesPlayerHandler = new playerHandler(players, human);
    }

    public int getPileSize() {
        return this.pileSize;
    }

    public void decreasePile(int reduceSize) {
        if (validateMove(reduceSize)) {
            pileSize = pileSize - reduceSize;
        }
    }

    private void turn() {
        String activePlayer = gamesPlayerHandler.currentPlayerName(turnNumber);
        System.out.printf("Current player is %s and the pilesize is %d\n", activePlayer, pileSize);
        if (gamesPlayerHandler.humanPlayer(turnNumber)) {
            gamesPlayerHandler.humanPlayerLogic(turnNumber, pileSize);
        } else {
            gamesPlayerHandler.computerPlayerLogic(turnNumber, pileSize);
        }
        turnNumber++;
        setPlayer(turnNumber);
    }

    public boolean gameOverCheck() {
        if (pileSize == 1) {
            System.out.println("Game over!");
            String activePlayer = gamesPlayerHandler.currentPlayerName(turnNumber - 1);
            System.out.println("Winner is: " + activePlayer);
            return true;
        } else {
            return false;
        }
    }

    private boolean validateMove(int reduceSize) {
        if (reduceSize <= 0) {
            System.out.println("Invalid move: you must remove at least one stick.");
            return false;
        } else if (reduceSize > halfPile()) {
            System.out.println("Invalid move: you cannot remove more than half of the remaining sticks.");
            return false;
        } else if (reduceSize > pileSize) {
            System.out.println("Invalid move: there are only " + pileSize + " sticks remaining.");
            return false;
        } else {
            return true;
        }
    }

    public int halfPile() {
        return (getPileSize() / 2);
    }

    private void setPlayer(int turnNumber) {
        gamesPlayerHandler.setCurrentPlayer((turnNumber % gamesPlayerHandler.getNumberOfPlayers()));
    }

    public void runGame() {
        while (!gameOverCheck()) {
            turn();
        }
    }
}
