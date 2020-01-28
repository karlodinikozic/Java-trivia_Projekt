package sample.SceneControlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.GameInfo.Player1;
import sample.GameInfo.Player2;
import sample.GameInfo.Rounds;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Question {

    public static void setCategory(String category) {
        Question.category = category;
    }
    private  static String category;

    private String correctAnswer;

    ArrayList<String[]> questions;

    @FXML
    VBox firstBox;
    @FXML
    TextArea TextQuestion;
    @FXML
    Button TextAnswer1;
    @FXML
    Button TextAnswer2;
    @FXML
    Button TextAnswer3;
    @FXML
    Button TextAnswer4;
    @FXML
    Label nameCategory;

    @FXML
    public void initialize()  {



        String fileName="";
        questions=new ArrayList<String[]>();
        nameCategory.setText(category);
        switch (category.toLowerCase()){
            case "geography":
                fileName="GeographyQuestions.txt";
                firstBox.setStyle("-fx-background-color: rgba(42,179,255,0.5)");

                break;
            case "science":
                fileName="ScienceQuestions.txt";
                firstBox.setStyle("-fx-background-color: rgba(22,255,65,0.5)");

                break;
            case "sport":
                fileName="SportQuestions.txt";
                firstBox.setStyle("-fx-background-color: rgba(255,143,23,0.5);");

                break;
            case "history":
                fileName="HistoryQuestions.txt";
                firstBox.setStyle("-fx-background-color: rgba(255,235,89,0.5);");
                break;
        }

        try
        {
            File file=new File("../Questions/GeographyQuestions.txt");    //creates a new file instance
            String[] arry =file.getAbsolutePath().toString().split("\\.");

            String str = arry[0]+"Questions/"+fileName;
            File fileTrue =new File(str);
            FileReader fr=new FileReader(fileTrue);
            BufferedReader br=new BufferedReader(fr);

            String line;
            while((line=br.readLine())!=null)
            {
                questions.add(line.split("#"));

            }
            fr.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try{
           Thread.sleep(200);
        }
        catch (Exception e){

        }
        int rand = ThreadLocalRandom.current().nextInt(0, questions.size()-1);


        String[] question  = questions.get(rand);
        TextQuestion.setText(question[0]);
        correctAnswer = question[1];

        ArrayList<String> answer = new ArrayList<>();
        answer.add(question[1]);
        answer.add(question[2]);
        answer.add(question[3]);
        answer.add(question[4]);

        Collections.shuffle(answer);



        TextAnswer1.setText(answer.get(0).toString());
        TextAnswer2.setText(answer.get(1).toString());
        TextAnswer3.setText(answer.get(2).toString());
        TextAnswer4.setText(answer.get(3).toString());


    }

    public void checkIsRightAnswer(ActionEvent actionEvent) {
        String answer = ((Button)(actionEvent.getTarget())).getText();

        if(answer.equals(correctAnswer)){
            int help  = Rounds.getCurrentPlayerPoints()+1;
            Rounds.setCurrentPlayerPoints(help);

            ((Button)(actionEvent.getTarget()))
                   .setStyle("-fx-background-color: rgba(0,255,0,0.1);-fx-border-color: green");

        } else{

            Rounds.setCurrentPlayerPoints(0);
            Rounds.setIs1Player(!Rounds.getIs1Player());
            ((Button)(actionEvent.getTarget()))
                    .setStyle("-fx-background-color: rgba(255,0,0,0.1);-fx-border-color: red");
        }
        if(Rounds.getCurrentPlayerPoints()==4){

            Stage currentStage =  (Stage) firstBox.getScene().getWindow();


                try{
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/Scenes/CategoryPicker.fxml"));
                    Scene newScene = new Scene(root);
                    newScene.getStylesheets().add("sample/StyleSheets/styles.css");
                    currentStage.setScene(newScene);

                }catch (Exception err){
                    System.out.println(err);
                }

        }


        if(Rounds.getIsCrownQuestion() ) {

            Rounds.setCurrentPlayerPoints(0);
            Rounds.setIsCrownQuestion(false);


            if (Rounds.getIs1Player()) {

                switch (category.toLowerCase()) {
                    case "geography":
                        Player1.setHasGeography(true);
                        break;
                    case "science":
                        Player1.setHasScience(true);
                        break;
                    case "sport":
                        Player1.setHasSport(true);
                        break;
                    case "history":
                        Player1.setHasHistory(true);
                        break;
                }
            }
            else {

                switch (category.toLowerCase()) {

                    case "geography":
                        Player2.setHasGeography(true);
                        break;
                    case "science":
                        Player2.setHasScience(true);
                        break;
                    case "sport":
                        Player2.setHasSport(true);
                        break;
                    case "history":
                        Player2.setHasHistory(true);
                        break;
                }
            }
        }

            //endgame clause
            List<Boolean> helparray = (List<Boolean>) Rounds.getCurrentPlayerCategories().stream()
                    .filter(val -> val.equals(true))
                    .collect(Collectors.toList());


            if(helparray.size() == 4) {
                Stage currentStage =  (Stage) firstBox.getScene().getWindow();
               try{

                   Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/Scenes/Winner.fxml"));

                   Scene newScene = new Scene(root);
                   newScene.getStylesheets().add("sample/StyleSheets/styles.css");

                   currentStage.setScene(newScene);

               }catch (Exception err){
                   System.out.println(err);
               }
            }


        Stage currentStage =  (Stage) firstBox.getScene().getWindow();
            try{
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/Scenes/Rounds.fxml"));
                Scene newScene = new Scene(root);
                newScene.getStylesheets().add("sample/StyleSheets/styles.css");
                currentStage.setScene(newScene);

            }catch (Exception err){
                    System.out.println(err);
            }
    }



}
