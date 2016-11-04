package edu.ucsb.cs56.projects.games.dealer;
import java.util.*;
import java.lang.*;


/**
   This class is used to add cards to the hand.

   @author Antonio Cantor
   @version cs56 W14 3/13/14
*/

public class Hand{
    private ArrayList<Card> hand;
    private int handSize;

    /**
     Hand constructor to make hand arraylist be an empty hand
     and the handSize be 0.
     */

    public Hand() {
        hand = new ArrayList<Card>();
        handSize=0;
    }

    /**
     This function adds cards to the hand based on the
     user input. After the cards to the hand, it removes
     the cards from the deck that were added to the hand
	 by calling the removeCard function in the Deck class

     @param numCards the number of cards user inputted
     @param d the Deck deck used in the dealer class
     */

    public void addtoHand(int numCards, Deck d){
	d.draw(numCards, this);
	handSize += numCards;
    }

    public ArrayList<Card> getHand() {
	return hand;
    }

    /**
     Overridden toString function to print cards in the hand.

	@return handResult a string of the cards in the hand
     */

	public String toString(){
        String handResult="Your hand:"+"\n";
		//One card in hand
        if(handSize == 1){
            handResult+=hand.get(0);
        }
        else{
            for (int i = 0; i<handSize; i++){
				//5 cards per line
		/*	if (i%5==0){
					handResult+="\n";
					}*/
				//No comma added to the last card in string
                if(i == handSize-1){
                    handResult+=hand.get(i);
                }
                else{
                    handResult+=hand.get(i) + ", ";
                }
            }
        }
		return handResult;
    }



}
