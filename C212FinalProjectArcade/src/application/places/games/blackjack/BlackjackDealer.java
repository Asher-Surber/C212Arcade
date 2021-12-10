package application.places.games.blackjack;

import java.util.ArrayList;

public class BlackjackDealer extends BlackjackParticipant {

    private String shownCard;
    private int dealerBest;

    public BlackjackDealer(){
        this.handTotals = new int[2];
        hit();
        hit();
    }

    @Override
    public void hit(){
        String newCard = cards.get(rand.nextInt(cards.size()));
        switch(newCard) {
            case "A":
                handTotals[0] += 1;
                handTotals[1] += 11; break;

            case "K":
            case "Q":
            case "J":
                handTotals[0] += 10;
                handTotals[1] += 10; break;
            default:
                handTotals[0] += Integer.parseInt(newCard);
                handTotals[1] += Integer.parseInt(newCard);
        }
        cards.remove(newCard);
        if(handTotals[0] == 0 && handTotals[1] == 0){
            newCard = this.shownCard;
        }
    }

    @Override
    public int getBestTotal() {
        int diff1 = 21 - handTotals[0];
        int diff2 = 21 - handTotals[1];
        int best = -1;
        if(diff1 >= 0 && diff1 < diff2){
            best = handTotals[0];
            return best;
        }
        else if(diff2 >= 0 && diff2 < diff1){
            best = handTotals[1];
            return best;
        }
        else{
            best  = -1;
            return best;
        }
    }

    public String getPartialHand(){
        return shownCard + " + ???";
    }

    public void play(){
        
    }

}
