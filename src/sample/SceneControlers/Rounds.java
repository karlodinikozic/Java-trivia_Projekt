package sample.SceneControlers;


import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.concurrent.ThreadLocalRandom;

public class Rounds {
    @FXML
    VBox firstBox;

    @FXML
    Button spinbtn;

    @FXML
    PieChart wheel;
    int angle = 1000;

    RotateTransition rotateTransition = new RotateTransition();



    private void whichCategory(int angle){
        System.out.println(Math.ceil(angle%360));
        int categoryAngle =  (int)(angle % 360);
        if(categoryAngle<=57 || categoryAngle>345){
            NewQuestion("Crown");
        }
        else if(categoryAngle<=129 &&categoryAngle>57){
            NewQuestion("Geography");
        }
        else if(categoryAngle<=201 &&categoryAngle>129){
            NewQuestion("Science");
        }
        else if(categoryAngle<=273 &&categoryAngle>201){
            NewQuestion("History");
        }
        else if(categoryAngle<=345 &&categoryAngle>273){
            NewQuestion("Sport");
        }


    }

    private  void NewQuestion (String category){
        //TODO IF CATEGORY CROWN
        //CATEGORY CHOOSER
        Stage currentStage =  (Stage) firstBox.getScene().getWindow();
        Question.setCategory(category);

       

        System.out.println(category);

        if(category.equalsIgnoreCase("Crown")){
            
            try{
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/Scenes/CategoryPicker.fxml"));
                root.getStylesheets().add("sample/StyleSheets/styles.css");
                Scene newScene = new Scene(root);
                

                currentStage.setScene(newScene);
            }catch (Exception err){
                System.out.println(err);
            }
            return;
        }



        try{
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/Scenes/Question.fxml"));
            root.getStylesheets().add("sample/StyleSheets/styles.css");
            Scene newScene = new Scene(root);


            currentStage.setScene(newScene);
        }catch (Exception err){
            System.out.println(err);
        }
    }

   @FXML
   public void initialize() {
       sample.GameInfo.Rounds.setCurrentRound(
               sample.GameInfo.Rounds.getCurrentRound()+1
       );
       sample.GameInfo.Rounds.setIsCrownQuestion(false);


       ObservableList<PieChart.Data> pieChartData =
               FXCollections.observableArrayList(
                       new PieChart.Data("", 72),
                       new PieChart.Data("", 72),
                       new PieChart.Data("", 72),
                       new PieChart.Data("", 72),
                       new PieChart.Data("", 72));
       wheel.setData(pieChartData);
       wheel.setLegendVisible(false);
       wheel.setLabelLineLength(0);
       wheel.setLabelsVisible(false);



   }



    public void onSpin(ActionEvent actionEvent) {
        angle = + ThreadLocalRandom.current().nextInt(1, 360+1);
        rotateTransition.setDuration(Duration.millis(1000));
        rotateTransition.setNode(wheel);
        rotateTransition.setByAngle(360 + angle );
        rotateTransition.setCycleCount(1);
        spinbtn.setDisable(true);
        rotateTransition.play();
        rotateTransition.statusProperty().isEqualTo(Animation.Status.STOPPED).addListener(observable -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinbtn.setDisable(false);
            whichCategory(angle);
        });


    }
}
