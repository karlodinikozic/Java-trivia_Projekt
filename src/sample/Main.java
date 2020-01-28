package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.GameInfo.Player1;
import sample.GameInfo.Player2;
import sample.GameInfo.Rounds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Scenes/sample.fxml"));
        root.getStylesheets().add("sample/StyleSheets/styles.css");
        primaryStage.setTitle("Trivia Crack");
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image("sample/Images/apps.43813.13510798886403160.2c032d62-cee7-4a05-84ae-f271ddd24069.fc3296c2-28ed-42c7-bc69-218a01d51b12"));
        primaryStage.show();




    }


    public static void main(String[] args) {

        launch(args);
    }
}
