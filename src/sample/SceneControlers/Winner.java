package sample.SceneControlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import sample.GameInfo.Player1;
import sample.GameInfo.Player2;
import sample.GameInfo.Rounds;

public class Winner {
    @FXML
    Label winnerName;

    @FXML
    Label p1Name;

    @FXML
    Label p2Name;

    @FXML
    Label p1Points;

    @FXML
    Label p2Points;





    @FXML
    public void initialize() {

        if(Rounds.getIs1Player()){
            winnerName.setText(Player1.getName()+" has won.");
        }
        else{
            winnerName.setText(Player2.getName()+" has won.");
        }

        p1Name.setText(Player1.getName());
        p2Name.setText(Player2.getName());
        p1Points.setText(Player1.countCategorys()+"");
        p2Points.setText(Player2.countCategorys()+"");



    }

}
