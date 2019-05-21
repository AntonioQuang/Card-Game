
package card_game;

import java.util.ArrayList;


public class HumanPlayer extends Player {

    private ArrayList<Card> heldCards;

    /**
     * This is the constructor where an array list is made to hold the player's 
     * card.
     * Precondition: Card objects are made for the array list to hold.
     * Postcondition:An array list is made to hold cards.
     */
    public HumanPlayer() {
        heldCards = new ArrayList<>();
    }
    
    /**
     * This method takes a card from the deck and then adds that card to the
     * player's held cards.
     * Preconditions: The player chooses the option to draw a card, and the deck
     * is not empty.
     * Postconditions:A card is taken from the deck and then added to the player's
     * held pile.
     * @param newGame The Game object so this class can access the deck and discard pile.
     * @return The Card object that was taken from the deck.
     */
    @Override
    public Card drawCard(Game newGame) {
        Card takenCard = newGame.takeCard();
        heldCards.add(takenCard);
        return takenCard;
        
    }
    /**
     * This method removes a card from the player's hand and puts the removed card
     * into the discard pile.
     * Precondition: The player chooses which card to remove. A number between a
     * 1 and 5 inclusive. 
     * Postcondition: A card is taken from the player's hand and puts it 
     * into the discard pile.
     * @param newGame The Game object so this class can access the decks and discard pile.
     * @param i The number the player chooses to remove a card.
     */
    @Override
    public void removeCard(Game newGame, int i) {
        Card cardRemoved = heldCards.remove(i - 1);
        newGame.discardCard(cardRemoved);

    }

    /**
     * This method displays all the current cards in a deck.
     * Preconditions: The held pile has cards and is not empty.
     * Postconditions: The current cards the player holds is printed.
     */
    public void displayHeld() {
        System.out.println("Your cards are:");
        for(Card cards : heldCards){
            System.out.println("\t" + cards);
        }
    }
    /**
     * This method displays all the current cards in a deck. The player could choose
     * what card to remove by the numbers shown next to it.
     * Preconditions: The held pile has cards and is not empty.
     * Postconditions:The current cards the player holds is printed.
     */
    public void displayHeldAfterMove(){
        System.out.println("Now your cards are:");
        int count = 1;
        for(Card cards : heldCards){
            System.out.println("\t" + count + ". " + cards);
            count++;
        }
    }
    /**
     * This method checks if the player has 4 cards that have the same value.
     * Precondition: The player has 4 cards in their held pile.
     * Postcondition: If the player has 4 cards of the same value, it returns true.
     * Otherwise it returns false.
     * @return True or false
     */
    @Override
    public boolean win() {
        if (heldCards.get(0).getValue().equals(heldCards.get(1).getValue())
                && heldCards.get(0).getValue().equals(heldCards.get(2).getValue())
                && heldCards.get(0).getValue().equals(heldCards.get(3).getValue())) {
            return true;
        }
        return false;
    }
    /**
     * This method adds a card from the discard pile to the player's held pile 
     * Precondition:The discard pile is not empty.
     * Postcondition: A card is removed from the discard pile and added in into the player's hand.
     * @param newGame The Game object so this class can access the decks and discard pile.
     */
    @Override
    public void drawDiscardedCard(Game newGame) {
        heldCards.add(newGame.takeDiscardedCard());
    }

}
