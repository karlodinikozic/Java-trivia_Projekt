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
import java.util.concurrent.ThreadLocalRandom;

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
                break;
            case "science":
                fileName="ScienceQuestions.txt";
                break;
            case "sport":
                fileName="SportQuestions.txt";
                break;
            case "history":
                fileName="HistoryQuestions.txt";
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
                questions.add(line.split(","));
                System.out.println(questions.size());
            }
            fr.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        int rand = ThreadLocalRandom.current().nextInt(0, questions.size()-1);

       // setQuestion(rand);

        String[] question  = questions.get(rand);
        TextQuestion.setText(question[0]);
        correctAnswer = question[1];

        ArrayList<String> answer = new ArrayList<>();
        answer.add(question[1]);
        answer.add(question[2]);
        answer.add(question[3]);
        answer.add(question[4]);

        Collections.shuffle(answer);


        for(String i : answer){
            System.out.println(i);
        }

        TextAnswer1.setText(answer.get(0).toString());
        TextAnswer2.setText(answer.get(1).toString());
        TextAnswer3.setText(answer.get(2).toString());
        TextAnswer4.setText(answer.get(3).toString());


    }

    public void checkIsRightAnswer(ActionEvent actionEvent) {
        String answer = ((Button)(actionEvent.getTarget())).getText();

        if(answer.equals(correctAnswer)){
            Rounds.setCurrentPlayerPoints(Rounds.getCurrentPlayerPoints()+1);
            System.out.println("hey");
            ((Button)(actionEvent.getTarget()))
                   .setStyle("-fx-background-color: rgba(0,255,0,0.1);-fx-border-color: green");

        }
        else{
            Rounds.setCurrentPlayerPoints(0);
            Rounds.setIs1Player(!Rounds.getIs1Player());
            ((Button)(actionEvent.getTarget()))
                    .setStyle("-fx-background-color: rgba(255,0,0,0.1);-fx-border-color: red");
        }

       /* if(Rounds.getIsCrownQuestion() || Rounds.getCurrentPlayerPoints()==4) {
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
        }*/

            //endgame clause
           /* if (Rounds.getCurrentPlayerCategories().size() == 4) {
                //TODO WINNER
            }*/


            Stage currentStage =  (Stage) firstBox.getScene().getWindow();
            try{
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/Scenes/Rounds.fxml"));
                Scene newScene = new Scene(root);

                currentStage.setScene(newScene);

            }catch (Exception err){
                    System.out.println(err);
            }


    }


    //TODO ON CLICK button event
        //check if button == RIGHT ANSWER
            //ROUND.POINT++
            //ROUND.is1Player = TOGGLE() AND ROUND.
}
