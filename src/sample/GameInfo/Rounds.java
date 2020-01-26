package sample.GameInfo;

import java.util.ArrayList;

public class Rounds {


    private static int currentPlayerPoints=0;
    private static int currentRound;
    private static boolean is1Player = true;





    public static int  getCurrentPlayerPoints() {
        return currentPlayerPoints;
    }

    public static void setCurrentPlayerPoints(int currentPlayerPoints) {
        currentPlayerPoints = currentPlayerPoints;
    }

    public static int getCurrentRound() {
        return currentRound;
    }

    public static  void setCurrentRound(int currentRound) {
        currentRound = currentRound;
    }

    public static ArrayList getCurrentPlayerCategories(){
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
