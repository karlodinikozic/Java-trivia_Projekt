package sample.SceneControlers;

import com.sun.media.jfxmediaimpl.platform.Platform;
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
    @FXML
    VBox backgoundImage;



    public void onStart(ActionEvent e) {
        Stage currentStage =  (Stage) firstBox.getScene().getWindow();

        try{
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/Scenes/PlayersEnter.fxml"));
            root.getStylesheets().add("sample/StyleSheets/styles.css");
            Scene newScene = new Scene(root);
            currentStage.setScene(newScene);
        }catch (Exception err){
            System.out.println(err);
        }


        currentStage.show();

    }

    public void quitApp(ActionEvent actionEvent) {
        System.exit(0);
    }
}
