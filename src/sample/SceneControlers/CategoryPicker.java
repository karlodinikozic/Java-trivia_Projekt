package sample.SceneControlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.GameInfo.Rounds;

import java.util.ArrayList;


public class CategoryPicker {

    @FXML
    VBox firstBox;

    @FXML
    Button GeoBtn;
    @FXML
    Button SciBtn;
    @FXML
    Button SpoBtn;
    @FXML
    Button HisBtn;

    @FXML
    public void initialize() {

        ArrayList<Boolean> category = Rounds.getCurrentPlayerCategories();


        GeoBtn.setDisable(category.get(0));
        SciBtn.setDisable(category.get(1));
        SpoBtn.setDisable(category.get(2));
        HisBtn.setDisable(category.get(3));

        Rounds.setCurrentPlayerPoints(0);


    }

    public void choseCategory(ActionEvent actionEvent) {
        String button_text = ((Button) actionEvent.getTarget()).getText();
        Question.setCategory(button_text);
        Rounds.setIsCrownQuestion(true);

        Stage currentStage =  (Stage) firstBox.getScene().getWindow();
        try{

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/Scenes/Question.fxml"));
            Scene newScene = new Scene(root);
            newScene.getStylesheets().add("sample/StyleSheets/styles.css");
            currentStage.setScene(newScene);

        }catch (Exception err){
                System.out.println(err);
        }



    }
}
