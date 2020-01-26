package sample.SceneControlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller {

    @FXML
    VBox firstBox;



    public void onStart(ActionEvent e) {
        Stage currentStage =  (Stage) firstBox.getScene().getWindow();
        try{
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/Scenes/PlayersEnter.fxml"));
            Scene newScene = new Scene(root);
            currentStage.setScene(newScene);
        }catch (Exception err){
            System.out.println(err);
        }


        currentStage.show();

    }
}
