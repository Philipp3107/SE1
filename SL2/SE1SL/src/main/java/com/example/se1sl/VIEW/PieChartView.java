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

    public PieChartView(ObservableList<Studiengang> om) {
        Scene scene = new Scene(new Group());
        this.setTitle("Studiengänge und ihre Bewerber");
        this.setWidth(500);
        this.setHeight(500);
        this.setX(10);
        this.setY(10);
        List<PieChart.Data> data = new ArrayList<>();
        for(Studiengang s : om) {
            data.add(new PieChart.Data(s.getName().get(), s.getBewerber().get()));
        }
        this.om = FXCollections.observableArrayList(data);
        this.pieChart = new PieChart(this.om);
        this.om.addListener((ListChangeListener<PieChart.Data>)change -> {
            while (change.next()) {
                if(change.wasRemoved()) {
                    this.pieChart.getData().clear();
                    for(PieChart.Data d : this.om) {
                        this.pieChart.getData().add(d);
                    }
                }
            }
        });
        this.pieChart.setTitle("Studiengänge und ihre Bewerber");

        ((Group) scene.getRoot()).getChildren().add(this.pieChart);
        this.setScene(scene);
        this.show();
    }
    public void updatePieChart(int index, ObservableList<Studiengang> ol){
        this.om.add(index, new PieChart.Data(ol.get(index).getName().get(), ol.get(index).getBewerber().get()));
        this.om.remove(index+1);
    }
}
