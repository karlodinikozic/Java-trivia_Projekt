package sample.SceneControlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class Rounds {
    @FXML
    PieChart wheel;

    ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList(
                    new PieChart.Data("Geography", 25),
                    new PieChart.Data("Science", 25),
                    new PieChart.Data("History", 25),
                    new PieChart.Data("Sport", 10),
                    new PieChart.Data("Crown", 10),


}
