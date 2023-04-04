//Kristoffer Danbrant
//studentid krda1698 @ Uppsala University
//e-post: k.danbrant@icloud.com

package NimGame;
import java.util.Scanner;
public class Nim {

    public static gameHandler myGame;
    private static Scanner input = new Scanner(System.in);

    private static void gameSetup(String args[]){
        if(args.length > 0){
          System.out.println("Sorry, argument initialization isn't implemented yet.");
          return;
        }
        else{
            Boolean validinput = false;
            int players = 0;
            int humans = 0;
            int startPile = 0;
    
            Scanner input = new Scanner(System.in); // Create a single Scanner object
            while(validinput != true){
            System.out.println("Total number of players?");
            players = input.nextInt();
            validinput = validatePlayerNumber(players);
            }
            validinput = false;
    
            while(validinput != true){
            System.out.println("Total number of human players?");
            humans = input.nextInt();
            validinput = validateHumanPlayers(humans, players);
            };
            validinput = false;
    
            while(validinput != true){
            System.out.println("Starting size of the pile?");
            startPile = input.nextInt();
            validinput = validatePileSize(startPile);
            }
            myGame = new gameHandler(startPile, players, humans);
        }
    }
    
    
    

    private static Boolean validatePileSize(int startPile) {
        if(startPile < 2){
            System.out.println("Need bigger starting pile!");
            return false;
        }
        else{
            return true;
        }
    }

    private static boolean validatePlayerNumber(int players){
        if(players < 2){
            System.out.println("Need at least two players for a game");
            return false;
        }
        if(players > 2){
            System.out.println("More then two players can't generate one winner, only one loser. Still want to play? (y/n)");
            char answer = input.next(".").charAt(0);
            if(answer == 'y' || answer == 'Y'){
                return true;
            }
            else{
                return false;
            }
        }
        return true;
    }

    private static boolean validateHumanPlayers(int humans, int players){
        if(humans > players){
            System.out.println("To many humans for to few player spots, try again!");
            return false;
        }
        else{
            return true;
        }
    }


      public static void main(String args[]){
        gameSetup(args);
        myGame.runGame();

        return;
    }
 }
