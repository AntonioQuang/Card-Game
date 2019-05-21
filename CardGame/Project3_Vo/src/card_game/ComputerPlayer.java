
package card_game;

import java.util.ArrayList;


public class ComputerPlayer extends Player {

    private ArrayList<Card> heldCards;

    /**
     * This is the constructor where an array list is made to hold the computer player's 
     * card.
     * Precondition: Card objects are made for the array list to hold.
     * Postcondition:An array list is made to hold cards.
     */
    public ComputerPlayer() {
        heldCards = new ArrayList<>();
    }
    
    /**
     * This method is the computer's strategy to choosing cards. This method goes
     * through the computer's held card to check and checks to see if there any cards
     * that have the same value. If there are 2 or more cards that have the same value
     * the mostCardValue is set to the value the player holds the most. If there's card 
     * that is the same value as the mostCardValue in the discard pile the computer
     * player will take it. If there's no similar value card in the discard pile the 
     * computer player will draw a new card. The computer player will then only discard 
     * cards that don't have the same value as the mostCardValue or it won't discard any cards
     * that are similar to the card it just drew.
     * Precondition:Its the computer players turn.
     * Postcondition:The computer player will draw a card or take a card from the discard pile.
     * Then remove one of the cards from its hand.
     * @param newGame The Game object so this class can access the deck and discard pile.
     */
    public void computerMove(Game newGame) {
        int[] valueList = new int[13];
        String mostCardValue = null;
        for (Card cards : heldCards) {
            if (cards.getValue().equals("Ace")) {
                valueList[0]++;
            } else if (cards.getValue().equals("Two")) {
                valueList[1]++;
            } else if (cards.getValue().equals("Three")) {
                valueList[2]++;
            } else if (cards.getValue().equals("Four")) {
                valueList[3]++;
            } else if (cards.getValue().equals("Five")) {
                valueList[4]++;
            } else if (cards.getValue().equals("Six")) {
                valueList[5]++;
            } else if (cards.getValue().equals("Seven")) {
                valueList[6]++;
            } else if (cards.getValue().equals("Eight")) {
                valueList[7]++;
            } else if (cards.getValue().equals("Nine")) {
                valueList[8]++;
            } else if (cards.getValue().equals("Ten")) {
                valueList[9]++;
            } else if (cards.getValue().equals("Jack")) {
                valueList[10]++;
            } else if (cards.getValue().equals("Queen")) {
                valueList[11]++;
            } else if (cards.getValue().equals("King")) {
                valueList[12]++;
            }
        }
        int highestValue = 0;
        int highestValueIndex = 0;
        for (int i = 0; i < valueList.length; i++) {
            if (valueList[i] > highestValue) {
                highestValue = valueList[i];
                highestValueIndex = i;
            }
        }
        if (highestValue == 1) {
            String cardValue = null;
            for (Card cards : heldCards) {
                if (!(newGame.isDiscardPileEmpty())) {
                    if (newGame.checkDiscardedPile().getValue().equals(cards.getValue())) {
                        cardValue = newGame.checkDiscardedPile().getValue();
                        System.out.println("I will pick up the " + newGame.checkDiscardedPile() + ".");
                        this.drawDiscardedCard(newGame);
                        break;

                    }
                }
            }
            if (cardValue != null) {
                for (Card cards : heldCards) {
                    if (!(cards.getValue().equals(cardValue))) {
                        this.removeCard(newGame, heldCards.indexOf(cards) + 1);
                        break;
                    }
                }
            } else {
                System.out.println("I will draw a new card.");
                String cardValue1 = this.drawCard(newGame).getValue();
                for (Card cards : heldCards) {
                    if (!(cards.getValue().equals(cardValue1))) {
                        this.removeCard(newGame, heldCards.indexOf(cards) + 1);
                        break;
                    }
                }
            }
        } else if (highestValueIndex == 0) {
            mostCardValue = "Ace";
        } else if (highestValueIndex == 1) {
            mostCardValue = "Two";
        } else if (highestValueIndex == 2) {
            mostCardValue = "Three";
        } else if (highestValueIndex == 3) {
            mostCardValue = "Four";
        } else if (highestValueIndex == 4) {
            mostCardValue = "Five";
        } else if (highestValueIndex == 5) {
            mostCardValue = "Six";
        } else if (highestValueIndex == 6) {
            mostCardValue = "Seven";
        } else if (highestValueIndex == 7) {
            mostCardValue = "Eight";
        } else if (highestValueIndex == 8) {
            mostCardValue = "Nine";
        } else if (highestValueIndex == 9) {
            mostCardValue = "Ten";
        } else if (highestValueIndex == 10) {
            mostCardValue = "Jack";
        } else if (highestValueIndex == 11) {
            mostCardValue = "Queen";
        } else if (highestValueIndex == 12) {
            mostCardValue = "King";
        }
        boolean didNotTakeDiscardedCard = true;
        if (mostCardValue != null) {
            for (Card cards : heldCards) {
                if (!(newGame.isDiscardPileEmpty())) {
                    if (cards.getValue().equals(mostCardValue) && mostCardValue.equals(newGame.checkDiscardedPile().getValue())) {
                        System.out.println("I will pick up the " + newGame.checkDiscardedPile() + ".");
                        this.drawDiscardedCard(newGame);
                        didNotTakeDiscardedCard = false;
                        break;
                    }
                }
            }
            if (didNotTakeDiscardedCard) {
                System.out.println("I will draw a new card.");
                this.drawCard(newGame);
            }
            for (Card cards : heldCards) {
                if (!(cards.getValue().equals(mostCardValue))) {
                    this.removeCard(newGame, heldCards.indexOf(cards) + 1);
                    break;
                }
            }
        }

    }
    
    /**
     * This method takes a card from the deck and then adds that card to the
     * computer player's held cards.
     * Preconditions: The computerMove method chooses to draw a card.
     * Postconditions:A card is taken from the deck and then added to the computer player's
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
     * This method removes a card from the computer player's hand and puts the removed card
     * into the discard pile. This also prints out what card was removed.
     * Precondition: The computer player chooses which card to remove. A number between a
     * 1 and 5 inclusive. 
     * Postcondition: A card is taken from the computer player's hand and puts it 
     * into the discard pile.
     * @param newGame The Game object so this class can access the decks and discard pile.
     * @param i The number the computer player chooses to remove a card.
     */
    @Override
    public void removeCard(Game newGame, int i) {
        Card cardRemoved = heldCards.remove(i - 1);
        System.out.println("I will discard the " + cardRemoved + ".");
        newGame.discardCard(cardRemoved);
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
     * This method adds a card from the discard pile to the computer player's held pile 
     * Precondition:The discard pile is not empty. And the computerMove chooses to
     * take the discarded card.
     * Postcondition: A card is removed from the discard pile and added in into the computer player's hand.
     * @param newGame The Game object so this class can access the decks and discard pile.
     */
    @Override
    public void drawDiscardedCard(Game newGame) {
        heldCards.add(newGame.takeDiscardedCard());
    }


    

}
