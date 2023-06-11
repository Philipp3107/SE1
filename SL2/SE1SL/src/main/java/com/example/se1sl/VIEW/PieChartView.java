package com.example.se1sl.VIEW;

import com.example.se1sl.Model.Studiengang;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.List;

public class PieChartView extends Stage {
    private PieChart pieChart;
    private ObservableList<PieChart.Data> om;
    private Group root = new Group();

    public PieChartView(ObservableList<Studiengang> om) {

        this.setTitle("Studiengänge und ihre Bewerber");
        this.setX(10);
        this.setY(10);
        List<PieChart.Data> data = new ArrayList<>();
        for(Studiengang s : om) {
            data.add(new PieChart.Data(s.getName().get(), s.getBewerber().get()));
        }
        this.om = FXCollections.observableArrayList(data);
        this.pieChart = new PieChart(this.om);
        this.pieChart.setTitle("Studiengänge und ihre Bewerber");
        this.root.getChildren().add(this.pieChart);
        Scene scene = new Scene(root, 500, 500);
        this.setScene(scene);
        this.show();
    }
    public void updatePieChart(int index, ObservableList<Studiengang> ol){
        this.om.add(index, new PieChart.Data(ol.get(index).getName().get(), ol.get(index).getBewerber().get()));
        this.om.remove(index+1);
    }
}
