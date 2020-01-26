package sample.SceneControlers;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class Rounds {
    @FXML
    VBox firstBox;

    @FXML
    PieChart wheel;
    int counter = 1000;
    Timer timer;
    double speed = 4;
    double angle = 345;

    @FXML
    ActionListener spin = new ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            speed -= speed/counter;

            angle += 0.36*speed;
            wheel.setRotate(wheel.getRotate() + 0.36*speed);
            counter--;
            if(counter==0){
                timer.stop();

                counter = 1000;
                whichCategory();
            }
        }
    };


    private void whichCategory(){
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
        System.out.println(category);
        Stage currentStage =  (Stage) firstBox.getScene().getWindow();
        System.out.println(currentStage);
        try{
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/Scenes/Question.fxml"));

            Scene newScene = new Scene(root);
            Question.setCategory(category);

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
        wheel.setRotate(345);
        angle=345;
        counter= ThreadLocalRandom.current().nextInt(1000, 2000 + 1);;
        speed = 4;
        timer = new Timer(1,spin);
        timer.start();
        //TODO disable button
        //whichCategory();
    }
}
