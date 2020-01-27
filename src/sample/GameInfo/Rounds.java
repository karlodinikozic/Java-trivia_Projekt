package sample.GameInfo;

import java.util.ArrayList;

public class Rounds {


    private static int currentPlayerPoints=0;
    private static int currentRound;

    public static boolean getIs1Player() {
        return is1Player;
    }

    public static void setIs1Player(boolean is1Player) {
        Rounds.is1Player = is1Player;
    }

    private static boolean is1Player = true;
    private static boolean isCrownQuestion = false;




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
            categories.add(Player1.getHasSport());
            categories.add(Player1.getHasHistory());

        }
        else{
            categories.add(Player2.getHasGeography());
            categories.add(Player2.getHasScience());
            categories.add(Player2.getHasHistory());
            categories.add(Player2.getHasSport());
        }
        return categories;
    }


    public static boolean getIsCrownQuestion() {

        return isCrownQuestion;
    }

    public static void setIsCrownQuestion(boolean isCrownQuestion) {
        Rounds.setCurrentPlayerPoints(0);
        Rounds.isCrownQuestion = isCrownQuestion;
    }
}
