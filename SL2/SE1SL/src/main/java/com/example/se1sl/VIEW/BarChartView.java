package com.example.se1sl.VIEW;

import com.example.se1sl.Model.Fakultaet;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class BarChartView extends Stage {

    BarChart<String, Number> barChart;
    Group root = new Group();
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    List<XYChart.Series<String, Number>> bar_chart_data = new ArrayList<>();
    public BarChartView(List<Fakultaet> ol) {
        init();
        setup_chart(ol);
    }

    /**
     *
     * @param ol
     */
    public void setup_chart(List<Fakultaet> ol){

        for(Fakultaet s: ol) {
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName(s.getStudiengang());
            series.getData().add(new XYChart.Data<>("", s.getBewerber()));
            bar_chart_data.add(series);
        }

        this.xAxis.setLabel("Studiengang");
        this.yAxis.setLabel("Bewerber");
        this.barChart = new BarChart<>(xAxis, yAxis, FXCollections.observableArrayList(bar_chart_data));
        this.barChart.setTitle("Studiengänge und ihre Bewerber");
        this.root.getChildren().add(barChart);
    }

    /**
     *
     */
    public void init(){
        Scene scene = new Scene(this.root, 500, 400);
        this.setScene(scene);
        this.setX(10);
        this.setY(500);
        this.setTitle("BarChart Ansicht");
        this.show();
    }

    /**
     *
     * @param ol
     * @param index
     */
    public void updateBarChart(List<Fakultaet> ol, int index){
        this.bar_chart_data.get(index).getData().get(0).setYValue(ol.get(index).getBewerber());
        this.bar_chart_data.get(index).setName(ol.get(index).getStudiengang());
    }
}
