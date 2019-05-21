
package card_game;


public abstract class Player {


    public Player() {
    }
    /**
     * This is an abstract method where the HumanPlayer and the ComputerPlayer
     * will implement.Takes a card from the deck.
     * Precondition: A Game object has been made.
     * Postconditions: If a card was taken from the deck, it would be returned.
     * @param newGame The Game object where the player classes can access the 
     * deck and discard pile.
     * @return A card that was taken is returned.
     */
    public abstract Card drawCard(Game newGame);
    
    /**
     * This is an abstract method where the HumanPlayer and the ComputerPlayer
     * will implement. Takes a card from the discard pile.
     * Precondition: A Game object has been made.
     * Postcondition: A card is taken from discard pile and added to the player's
     * pile.
     * @param newGame The Game object where the player classes can access the 
     * deck and discard pile.
     * 
     */
    public abstract void drawDiscardedCard(Game newGame);
    
    /**
     * This is an abstract method where the HumanPlayer and the ComputerPlayer
     * will implement. Removes a card from the player's hand.
     * Precondition: A Game object has been made. 
     * Postcondition: A card is removed from the player's hand and put into 
     * the discard pile.
     * @param newGame The Game object where the player classes can access the 
     * @param i The number of the card they want to remove
     */
    public abstract void removeCard(Game newGame, int i);
    
    /**
     * This an abstract method where the HumanPlayer and the ComputerPlayer will 
     * implement.Checks if the player has won.
     * Precondition:The player has all 4 cards of the same value.
     * Postcondition:If all 4 cards are of the same value, it will return true.
     * If not it returns false.
     * @return True or false
     */
    public abstract boolean win();
}
