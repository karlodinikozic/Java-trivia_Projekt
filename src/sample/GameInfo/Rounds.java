package sample.GameInfo;

import java.util.ArrayList;

public class Rounds {


    private int currentPlayerPoints=0;
    private int currentRound;
    private boolean is1Player;



    public Rounds(Object player) {
        if(player.getClass()== Player1.class ){
            is1Player=true;
        }else {
            is1Player=false;
        }
    }

    public int getCurrentPlayerPoints() {
        return currentPlayerPoints;
    }

    public void setCurrentPlayerPoints(int currentPlayerPoints) {
        this.currentPlayerPoints = currentPlayerPoints;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    public ArrayList getCurrentPlayerCategories(){
        ArrayList<Boolean> categories = new ArrayList<Boolean>();
        if(is1Player){
            categories.add(Player1.getHasGeography());
            categories.add(Player1.getHasScience());
            categories.add(Player1.getHasHistory());
            categories.add(Player1.getHasSport());

        }
        else{
            categories.add(Player2.getHasGeography());
            categories.add(Player2.getHasScience());
            categories.add(Player2.getHasHistory());
            categories.add(Player2.getHasSport());
        }
        return categories;
    }


}
