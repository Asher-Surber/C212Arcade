package application.places.games.blackjack;

import java.util.ArrayList;

public class BlackjackPlayer extends BlackjackParticipant {

    public BlackjackPlayer(){
        ArrayList<String> deck = cards;
        hit();
        hit();
    }

    public String getCurrentTotalsString(){
        if(handTotals[0] == handTotals[1]){
            return "Total: " + handTotals[0];
        }
        else if(handTotals[0] <= 21 && handTotals[1] <= 21){
            return "Totals: " + handTotals[0] + "|" + handTotals[1];
        }
        return "Something went wrong with BP.getcurrenttotals";
    }

    @Override
    public int getBestTotal() {
        int diff1 = 21 - handTotals[0];
        int diff2 = 21 - handTotals[1];
        if(diff1 >= 0 && diff1 < diff2){
            return handTotals[0];
        }
        else if(diff2 >= 0 && diff2 < diff1){
            return handTotals[1];
        }
        else{
            if(diff1 >= diff2){
                return diff1;
            }
            else{
                return diff2;
            }
        }
    }
}
