package edu.ucsb.cs56.projects.games.dealer;
import java.util.*;
import java.lang.*;


/**
   This class is used to add cards to the hand.

   @author Antonio Cantor
   @version cs56 W14 2/27/14
*/

public class Hand{
    private ArrayList hand;
    private int handSize;

    /**
     Hand constructor to make hand arraylist be an empty hand
     and the handSize be 0.
     */

    public Hand(){
        hand = new ArrayList();
        handSize=0;
    }

    /**
     This function adds cards to the hand based on the
     user input. After the cards to the hand, it removes
     the cards from the deck that were added to the hand

     @param xCards the number of cards user inputted
     @param D .the Deck deck used in the dealer class
     */

    public void addtoHand(int xCards, Deck D){
        ArrayList copy = new ArrayList(D.getDeck());

		if (xCards>copy.size()){
			xCards=copy.size();}

        for (int i=0;i<xCards;i++){
            hand.add(copy.get(i));
            handSize++;
        }


        for(Iterator<String> iterator = copy.iterator(); iterator.hasNext();) {
            String card = iterator.next();
            if(hand.contains(card)){
                iterator.remove();
            }
        }

        D.setDeck(copy);
    }


    /**
     Overridden toString function to print cards in the hand.

	@return handResult a string of the cards in the hand
     */
	public String toString(){
        String handResult="Your hand:"+"\n";

        if(handSize == 1){
            handResult+=hand.get(0);
        }
        else{
            for (int i = 0; i<handSize; i++){
				if (i%5==0){
					handResult+="\n";
				}
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
