/**
 * CardGame
 * This program is a card game between one human player and one computer player.
 * There are 52 cards in the deck. To win the game a player must have 4 cards with
 * the same value. Four cards are given to each player in the beginning. The player
 * will first draw a card or take a card from the discard pile and then remove a
 * card from their hand.Each player will draw and discard cards until one player
 * has four cards that are of the same value. Once one player wins, the program
 * will print out a win statement and the program will end.
 */
package card_game;


import java.util.InputMismatchException;
import java.util.Scanner;

public class BeginCardGame {

    public static void main(String[] args) {
        //Creates a scanner so the program can get input from the user
        Scanner input = new Scanner(System.in);
        //Creates a new game and the human player and computer player
        Game newGame = new Game();
        HumanPlayer player1 = new HumanPlayer();
        ComputerPlayer player2 = new ComputerPlayer();
        //Draws 4 cards for the human player
        player1.drawCard(newGame);
        player1.drawCard(newGame);
        player1.drawCard(newGame);
        player1.drawCard(newGame);
        //Draw 4 cards for the computer player
        player2.drawCard(newGame);
        player2.drawCard(newGame);
        player2.drawCard(newGame);
        player2.drawCard(newGame);
        //displays the current hand of the player after drawing 4 cards
        player1.displayHeld();
        //if the human player has been dealt 4 cards with the same value, the 
        //program will print out "You win!" and the program will end
        if (player1.win()) {
            System.out.println("You win!");
            System.exit(0);
        }
        //if the computer player has been dealt 4 cards with the same value, the 
        //program will print out "I win!" and the program will end
        if (player2.win()) {
            System.out.println("I win!");
            System.exit(0);
        }
        //This program will run until one of the players win and break out of the loop
        while (true) {
            //this if statement will check if the deck is empty and if empty, put all the 
            //discard cards into the deck and shuffle 
            if (newGame.isDeckEmpty()) {
                newGame.changeDecks();
            }
            //this is the player's choice
            int choice1 = 0;
            //If the discard pile is empty the program will automatically draw 
            //a card for the human player and prints out what was drew
            if (newGame.isDiscardPileEmpty()) {
                System.out.println("The discard pile is currently empty -- you must draw a card");
                System.out.println("You drew the " + player1.drawCard(newGame));
                //If the discard pile is not empty, then the player is given a choice to
                //draw a new card or pick up the discarded card
            } else {
                System.out.println("The top card in the discard pile is the " + newGame.checkDiscardedPile());
                System.out.println("Do you want to pick up the " + newGame.checkDiscardedPile() + " (1) or draw a card (2)?");
                choice1 = 0;
                //this loop will check for the correct input by the user. If the user 
                //chooses anything other than 1 or 2 the program will ask to re-enter
                //the choice again
                boolean loop = true;
                while (loop) {
                    try {
                        choice1 = input.nextInt();
                        input.nextLine();
                        while (choice1 < 1 || choice1 > 2) {
                            System.out.println("Incorrect choice.");
                            System.out.println("Please enter your choice again.");
                            choice1 = input.nextInt();
                            input.nextLine();
                        }
                        loop = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect choice.");
                        System.out.println("Please enter your choice again.");
                        input.nextLine();
                    }
                }

            }
            //if the player chooses 2, the player will draw a new card and 
            //print out what card was draw
            if (choice1 == 2) {
                System.out.println("You drew the card the " + player1.drawCard(newGame));
                //if the player chooses 1, the player will take the discarded card
            } else if (choice1 == 1) {
                player1.drawDiscardedCard(newGame);
            }
            //displays the current hand of the player and shows the choices 
            //of the available cards to remove
            player1.displayHeldAfterMove();
            //ask the user which card to discard by choosing 1-5
            System.out.println("Which one do you want to discard?");
            int discardChoice = 0;
            //this loop will check to see if the user entered a correct choice 
            //between 1-5 and will keep on asking for reinput until its correct
            boolean loop = true;
            while (loop) {
                try {
                    discardChoice = input.nextInt();
                    input.nextLine();
                    while (discardChoice > 5 || discardChoice < 1) {
                        System.out.println("Incorrect choice.");
                        System.out.println("Please enter your choice again.");
                        discardChoice = input.nextInt();
                        input.nextLine();
                    }
                    loop = false;
                } catch (InputMismatchException e) {
                    System.out.println("Incorrect choice.");
                    System.out.println("Please enter your choice again.");
                    input.nextLine();
                }
            }
            //After a correct imput was enterted that card is removed with this method
            player1.removeCard(newGame, discardChoice);
            //if the win method returns true the human player wins and "You win!"
            //is printed out and breaks out the loop and the program ends.
            if (player1.win()) {
                System.out.println("You win!");
                break;
            }
            //if the win method returns true the computer player wins and "I win!"
            //is printed out and breaks out the loop and the program end
            player2.computerMove(newGame);
            if (player2.win()) {
                System.out.println("I win!");
                break;
            }
            //redisplays the current hand of the player if no one won
            player1.displayHeld();

        }
    }

}
