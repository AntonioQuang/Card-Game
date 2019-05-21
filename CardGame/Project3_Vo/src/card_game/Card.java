

package card_game;


public class Card {
    private String value;
    private String suit;

    /**
     * This is the constructor that takes in the value and the suit for a card.
     * Precondition:The value is either Ace,One,Two,Three,Four,Five,Six,Seven,Eight,
     * Nine,Ten,Jack,Queen,or King. The suit has to be either Spades,Hearts,
     * Diamonds, or Clubs.
     * Postcondition:Creates a Cards object.
     * @param value This is a value for a card.
     * @param suit This is the suit for a card. 
     */
    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }
    /**
     * This method gets the value of a card.
     * Precondition: A value has been set for a card.
     * Postcondition:A value will be returned.
     * @return A string will be returned of a card value
     */
    public String getValue() {
        return value;
    }
    /**
     * This method gets the suit of a card.
     * Precondition: A suit has been set for a card.
     * Postcondition:A suit will be returned.
     * @return A string will be return of a suit value.
     */
    public String getSuit() {
        return suit;
    }
    /**
     * This toString method will display the value and suit of card when displaying
     * the cards.
     * Precondition:A card object has been made.
     * Postcondition:The value and suit of card will be returned and display
     * @return A string that contains the value and suit of card
     */
    @Override
    public String toString(){
        return value + " of " + suit;
    }
     
}
