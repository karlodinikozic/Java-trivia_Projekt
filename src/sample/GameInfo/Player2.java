package sample.GameInfo;

public class Player2 {


    private static String name;
    private static boolean hasGeography;
    private static boolean hasHistory;

    public static void setHasGeography(boolean hasGeography) {
        Player2.hasGeography = hasGeography;
    }

    public static void setHasHistory(boolean hasHistory) {
        Player2.hasHistory = hasHistory;
    }

    public static void setHasScience(boolean hasScience) {
        Player2.hasScience = hasScience;
    }

    public static void setHasSport(boolean hasSport) {
        Player2.hasSport = hasSport;
    }

    private static boolean hasScience;
    private static boolean hasSport;

    public static boolean getHasGeography() {
        return hasGeography;
    }

    public static boolean getHasHistory() {
        return hasHistory;
    }

    public static boolean getHasScience() {
        return hasScience;
    }

    public static boolean getHasSport() {
        return hasSport;
    }



    public static String getName(){
          return name;
    }
    public static void setName(String name) {
        Player2.name = name;
    }

    public static int countCategorys(){
        int count = 0;
        if(hasGeography){
            count++;
        }
        if(hasHistory){
            count++;
        }
        if(hasScience){
            count++;
        }
        if(hasSport){
            count++;
        }
        return count;
    }



}
