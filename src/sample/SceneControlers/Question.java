package sample.SceneControlers;

import javafx.fxml.FXML;

public class Question {
    public static void setCategory(String category) {
        Question.category = category;
    }

    private  static String category;

    @FXML
    public void initialize() {


        //TODO GET QUESTION
        //TODO SET RIGHT ANSWER


    }

    //TODO ON CLICK button event
        //check if button == RIGHT ANSWER
            //ROUND.POINT++
            //ROUND.is1Player = TOGGLE() AND ROUND.
}
