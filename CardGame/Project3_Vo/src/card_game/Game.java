
package card_game;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class Game {

    private Queue<Card> deck;
    private ArrayDeque<Card> discardPile;
    /**
     * This is the constructor for the Game class. This creates a new queue deck and a
     * new stack discard pile. It then adds all the required cards into the deck.
     * And then shuffles the deck.
     * Precondition: A deck and discard pile has been made.
     * Postcondition:A deck and discard pile has been made. 52 cards are added
     * into the deck and shuffled.
     */
    public Game() {
        this.deck = new LinkedList<>();
        this.discardPile = new ArrayDeque<>();
        deck.offer(new Card("Ace", "Clubs"));
        deck.offer(new Card("Two", "Clubs"));
        deck.offer(new Card("Three", "Clubs"));
        deck.offer(new Card("Four", "Clubs"));
        deck.offer(new Card("Five", "Clubs"));
        deck.offer(new Card("Six", "Clubs"));
        deck.offer(new Card("Seven", "Clubs"));
        deck.offer(new Card("Eight", "Clubs"));
        deck.offer(new Card("Nine", "Clubs"));
        deck.offer(new Card("Ten", "Clubs"));
        deck.offer(new Card("Jack", "Clubs"));
        deck.offer(new Card("Queen", "Clubs"));
        deck.offer(new Card("King", "Clubs"));

        deck.offer(new Card("Ace", "Diamonds"));
        deck.offer(new Card("Two", "Diamonds"));
        deck.offer(new Card("Three", "Diamonds"));
        deck.offer(new Card("Four", "Diamonds"));
        deck.offer(new Card("Five", "Diamonds"));
        deck.offer(new Card("Six", "Diamonds"));
        deck.offer(new Card("Seven", "Diamonds"));
        deck.offer(new Card("Eight", "Diamonds"));
        deck.offer(new Card("Nine", "Diamonds"));
        deck.offer(new Card("Ten", "Diamonds"));
        deck.offer(new Card("Jack", "Diamonds"));
        deck.offer(new Card("Queen", "Diamonds"));
        deck.offer(new Card("King", "Diamonds"));

        deck.offer(new Card("Ace", "Hearts"));
        deck.offer(new Card("Two", "Hearts"));
        deck.offer(new Card("Three", "Hearts"));
        deck.offer(new Card("Four", "Hearts"));
        deck.offer(new Card("Five", "Hearts"));
        deck.offer(new Card("Six", "Hearts"));
        deck.offer(new Card("Seven", "Hearts"));
        deck.offer(new Card("Eight", "Hearts"));
        deck.offer(new Card("Nine", "Hearts"));
        deck.offer(new Card("Ten", "Hearts"));
        deck.offer(new Card("Jack", "Hearts"));
        deck.offer(new Card("Queen", "Hearts"));
        deck.offer(new Card("King", "Hearts"));

        deck.offer(new Card("Ace", "Spades"));
        deck.offer(new Card("Two", "Spades"));
        deck.offer(new Card("Three", "Spades"));
        deck.offer(new Card("Four", "Spades"));
        deck.offer(new Card("Five", "Spades"));
        deck.offer(new Card("Six", "Spades"));
        deck.offer(new Card("Seven", "Spades"));
        deck.offer(new Card("Eight", "Spades"));
        deck.offer(new Card("Nine", "Spades"));
        deck.offer(new Card("Ten", "Spades"));
        deck.offer(new Card("Jack", "Spades"));
        deck.offer(new Card("Queen", "Spades"));
        deck.offer(new Card("King", "Spades"));
        Collections.shuffle((LinkedList) deck);
    }
    
    /**
     * This method occurs when the deck is empty. All the cards in the discard pile
     * are then moved into the draw pile and shuffled.
     * Preconditions:The deck must be empty.
     * PostCondition:All the cards in discard are put in the deck and shuffled.
     */
    public void changeDecks() {
        for (Card card : discardPile) {
            deck.offer(discardPile.pop());

        }
        Collections.shuffle((LinkedList) deck);
    }
    /**
     * This method takes a card from the deck and puts it in a player's held pile.
     * Preconditions: The deck has cards and is not empty.
     * Postconditions: A card is taken from the deck and returned.
     * @return A Card object is returned.
     */
    public Card takeCard() {
        return deck.poll();
    }
    
    /**
     * This method takes the top card from the discarded pile and puts it in a player's held pile.
     * Preconditions: The discarded pile is not empty.
     * Postconditions: A card is taken from the discarded pile and returned.
     * @return A card object is returned
     */
    public Card takeDiscardedCard(){
        return discardPile.pop();
    }
    /**
     * This method takes a card that was removed by a player and puts it into 
     * the discarded pile.
     * @param discardedCard A card that the player chooses to remove.
     * Precondition: A card to remove is chosen by the player.
     * Postcondition: A card that was removed from the player's pile is then put
     * into the discarded pile.
     */
    public void discardCard(Card discardedCard) {
        discardPile.push(discardedCard);
    }
    /**
     * This method checks the top card of the discard pile.
     * Precondition:The discard pile is not empty.
     * Postcondition:The top card is then returned.
     * @return A Card object from the discard pile is returned
     */
    public Card checkDiscardedPile(){
        return discardPile.peek();
    }
    /**
     * This method checks if the discard pile is empty.
     * Precondition:The discard pile is either empty or not.
     * Postcondition:If the pile is empty, true is returned. If the pile is not empty
     * false is returned.
     * @return True or false is returned
     */
    public boolean isDiscardPileEmpty(){
        return discardPile.isEmpty();
    }
    /**
     * The method checks if the deck is empty.
     * Precondition:The deck is empty or not.
     * Postcondition:If the deck is empty, true is returned. If its not false is returned.
     * @return Ture or false is returned.
     */
    public boolean isDeckEmpty(){
        return deck.isEmpty();
    }

}
