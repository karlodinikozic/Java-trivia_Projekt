package sample.SceneControlers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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
    VBox firstBox;





    @FXML
    public void initialize() {

        if(Rounds.getIs1Player()){
            winnerName.setText(Player1.getName()+" HAS WON.");

        }
        else{
            winnerName.setText(Player2.getName()+" HAS WON.");
        }

        p1Name.setText(Player1.getName());
        p2Name.setText(Player2.getName());
        p1Points.setText(Player1.countCategorys()+"");
        p2Points.setText(Player2.countCategorys()+"");



    }

    public void playagain(ActionEvent actionEvent) {


        System.exit(0);
        /*Rounds.setCurrentPlayerPoints(0);
        Rounds.setIs1Player(true);
        Player1.setHasScience(false);
        Player1.setName(null);
        Player1.setHasSport(false);
        Player1.setHasGeography(false);
        Player1.setHasHistory(false);
        Player2.setHasScience(false);
        Player2.setName(null);
        Player2.setHasSport(false);
        Player2.setHasGeography(false);
        Player2.setHasHistory(false);*/
        //Stage currentStage =  (Stage) firstBox.getScene().getWindow();
       /*try{
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/Scenes/sample.fxml"));
            root.getStylesheets().add("sample/StyleSheets/styles.css");
            Scene newScene = new Scene(root);


            currentStage.setScene(newScene);
        }catch (Exception err){
            System.out.println(err);
        }*/
    }
}
