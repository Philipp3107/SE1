package com.example.se1sl.VIEW;

import com.example.se1sl.Model.Studiengang;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class BarChartView extends Stage {

    VBox vb = new VBox();
    BarChart<String, Number> barChart;
    Group root = new Group();
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();

    List<String> sg_name_list = new ArrayList<>();
    ObservableList<XYChart.Series<String, Number>> bar_chart_data;
    public BarChartView(ObservableList<Studiengang> ol) {
        init();
        setup_chart(ol);
        setup_list(ol);
    }
    public void setup_chart(ObservableList<Studiengang> ol){
        for(Studiengang s: ol){
            sg_name_list.add(s.getName().get());
        }
        List<XYChart.Series<String, Number>> series_list= new ArrayList<>();

        for(Studiengang s: ol) {
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName(s.getName().get());
            series.getData().add(new XYChart.Data<>("bewerber", s.getBewerber().get()));
            series_list.add(series);

        }
        this.bar_chart_data = FXCollections.observableArrayList(series_list);
        for(XYChart.Series s: this.bar_chart_data){
            System.out.println(s.getData().toString());
        }

        this.xAxis.setCategories(FXCollections.observableArrayList("bewerber"));
        this.xAxis.setLabel("Studiengang");
        this.yAxis.setLabel("Bewerber");
        this.barChart = new BarChart<>(xAxis, yAxis, bar_chart_data);
        this.barChart.setTitle("Studiengänge und ihre Bewerber");
        this.root.getChildren().add(barChart);
    }
    public void init(){
        Scene scene = new Scene(this.root, 530, 400);
        this.setScene(scene);
        this.show();
    }
    public void setup_list(ObservableList<Studiengang> ol){
        System.out.println("setting up list");
        int i = 0;
        for(Studiengang s: ol){
            HBox hb = new HBox();
            Label l1 = new Label(s.getName().get());
            Label l2 = new Label(String.valueOf(s.getBewerber().get()));
            hb.getChildren().addAll(l1, l2);
            this.vb.getChildren().add( i, hb);
            i++;
        }
    }
    public void updateBarChart(boolean changed, ObservableList<Studiengang> ol, int index){
//        XYChart.Series<String, Number> series = new XYChart.Series<>();
//        series.setName(ol.get(index).getName().get());
//        series.getData().add(new XYChart.Data<>("bewerber", ol.get(index).getBewerber().get()));
        this.bar_chart_data.get(index).getData().get(0).setYValue(ol.get(index).getBewerber().get());
    }
}
