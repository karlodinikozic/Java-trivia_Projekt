package sample.SceneControlers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Question {

    public static void setCategory(String category) {
        Question.category = category;
    }
    private  static String category;

    ArrayList<String> questions;

    @FXML
    TextArea TextQuestion;
    @FXML
    Label nameCategory;

    @FXML
    public void initialize()  {
        String fileName="";
        questions=new ArrayList<>();
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
                questions.add(line);
                System.out.println(line);
            }
            fr.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        String helptext = questions.get(1).split(",")[0];
        System.out.println("\n"+helptext);
        TextQuestion.setText(helptext);



            //TODO GET QUESTION
        //TODO SET RIGHT ANSWER


    }

    //TODO ON CLICK button event
        //check if button == RIGHT ANSWER
            //ROUND.POINT++
            //ROUND.is1Player = TOGGLE() AND ROUND.
}
