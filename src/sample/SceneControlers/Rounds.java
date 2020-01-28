package sample.SceneControlers;



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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.GameInfo.Player1;
import sample.GameInfo.Player2;


import java.util.concurrent.ThreadLocalRandom;

public class Rounds {
    @FXML
    VBox firstBox;

    @FXML
    Button spinbtn;


    @FXML
    Label p1Name;
    @FXML
    Label p1Geo;
    @FXML
    Label p1Sci;
    @FXML
    Label p1Spo;
    @FXML
    Label p1His;

    @FXML
    Label p2Name;
    @FXML
    Label p2Geo;
    @FXML
    Label p2Sci;
    @FXML
    Label p2Spo;
    @FXML
    Label p2His;

    @FXML
    Label cPP;

    @FXML
    Label RoundCounter;

    @FXML
    ImageView p1G;

    @FXML
    ImageView p1S;

    @FXML
    ImageView p1Sp;
    @FXML
    ImageView p1H;


    @FXML
    ImageView p2G;

    @FXML
    ImageView p2S;

    @FXML
    ImageView p2Sp;
    @FXML
    ImageView p2H;




    @FXML
    PieChart wheel;
    int angle = 0;

    RotateTransition rotateTransition = new RotateTransition();



    private void whichCategory(int angle){

        int categoryAngle =  (int)(angle % 360);
        System.out.println("angle is = " + angle);
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

       try{
           Thread.sleep(100);
       }catch (Exception e){

       }

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
       String helpstr = "Round "+sample.GameInfo.Rounds.getCurrentRound()+"";
       System.out.println(helpstr);
       RoundCounter.setText(helpstr);

        //Init categories and names
       //P1
       p1Name.setText(Player1.getName());
       if(Player1.getHasGeography()){p1Geo.setText("Geography");

            p1G.setStyle("-fx-blend-mode: null;");
       }
       if(Player1.getHasScience()){p1Sci.setText("Science");

           p1S.setStyle("-fx-blend-mode: null;");
       }
       if(Player1.getHasSport()){p1Spo.setText("Sport");

           p1Sp.setStyle("-fx-blend-mode: null;");
       }
       if(Player1.getHasHistory()){p1His.setText("History");

           p1H.setStyle("-fx-blend-mode: null;");
       }
       //P2

       p2Name.setText(Player2.getName());
       if(Player2.getHasGeography()){
           p2G.setStyle("-fx-blend-mode: null;");

       }
       if(Player2.getHasScience()){

           p2S.setStyle("-fx-blend-mode: null;");
          }
       if(Player2.getHasSport()){

           p2Sp.setStyle("-fx-blend-mode: null;");
       }
       if(Player2.getHasHistory()){

           p2H.setStyle("-fx-blend-mode: null;");
       }

        if(sample.GameInfo.Rounds.getIs1Player()){
            System.out.println("player has =" +sample.GameInfo.Rounds.getCurrentPlayerPoints());
            cPP.setText(Player1.getName() + " has "
                    + sample.GameInfo.Rounds.getCurrentPlayerPoints() + " /4 points");
        }
        else{
            cPP.setText(Player2.getName() + " has "
                    + sample.GameInfo.Rounds.getCurrentPlayerPoints() + " /4 points");
        }



       ObservableList<PieChart.Data> pieChartData =
               FXCollections.observableArrayList(
                       new PieChart.Data("History", 72),
                       new PieChart.Data("Science", 72),
                       new PieChart.Data("Geography", 72),
                       new PieChart.Data("Crown", 72),
                       new PieChart.Data("Sport", 72));
       wheel.setData(pieChartData);
       wheel.setLegendVisible(false);
       wheel.setLabelLineLength(0);
       wheel.setLabelsVisible(false);
       wheel.setRotate(0);


   }



    public void onSpin(ActionEvent actionEvent) {
        System.out.println("Hey");
        wheel.setRotate(0);

        angle = + ThreadLocalRandom.current().nextInt(5, 360+1);

        rotateTransition.setDuration(Duration.millis(1000));
        rotateTransition.setNode(wheel);
        rotateTransition.setByAngle(360 + angle );
        rotateTransition.setCycleCount(1);
        spinbtn.setDisable(true);
        rotateTransition.setOnFinished(e->{

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException er) {
                    er.printStackTrace();
                }

                whichCategory(angle);
                spinbtn.setDisable(false);


        });
        rotateTransition.play();


    }
}
