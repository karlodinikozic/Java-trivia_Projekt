package sample.SceneControlers;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class Rounds {


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
            System.out.println("Plava");
        }
        else if(categoryAngle<=129 &&categoryAngle>57){
            System.out.println("zelena");
        }
        else if(categoryAngle<=201 &&categoryAngle>129){
            System.out.println("Naranđasta");
        }
        else if(categoryAngle<=273 &&categoryAngle>201){
            System.out.println("Crvena");
        }
        else if(categoryAngle<=345 &&categoryAngle>273){
            System.out.println("Purple");
        }


    }

   @FXML
   public void initialize() {
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
    }
}
