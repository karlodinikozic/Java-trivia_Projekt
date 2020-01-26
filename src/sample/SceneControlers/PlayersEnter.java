package sample.SceneControlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.GameInfo.Player1;
import sample.GameInfo.Player2;


public class PlayersEnter {
    @FXML
    Label errorLab;

    @FXML
    TextField player1;

    @FXML
    TextField player2;

    public void onPlay(ActionEvent actionEvent) {

        player1.setStyle("-fx-border-color: none");
        player2.setStyle("-fx-border-color: none");
        errorLab.setText("");


       if(player1.getText().length()==0){
           player1.setStyle("-fx-border-color: red;-fx-background-color: rgba(255,0,0,0.1)");
           errorLab.setText("Please enter Player 1 name");

       }
        else if(player2.getText().length()==0){
            player2.setStyle("-fx-border-color: red;-fx-background-color: rgba(255,0,0,0.1)");
            errorLab.setText("Please enter Player 2 name");

        }




    }
}
