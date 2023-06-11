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
        this.bar_chart_data.addListener((ListChangeListener<XYChart.Series<String, Number>>) change -> {
            while (change.next()){
                if(change.wasRemoved()){
                    update_view();
                }
            }
        });
        for(XYChart.Series s: this.bar_chart_data){
            System.out.println(s.getData().toString());
        }

        this.xAxis.setCategories(FXCollections.observableArrayList("bewerber"));
        this.xAxis.setLabel("Studiengang");
        this.yAxis.setLabel("Bewerber");
        this.barChart = new BarChart<>(xAxis, yAxis);
        this.barChart.setTitle("Studiengänge und ihre Bewerber");
        this.barChart.getData().addAll(bar_chart_data);
        this.root.getChildren().add(barChart);
    }
    public void init(){
        Scene scene = new Scene(this.root, 530, 400);
        this.setScene(scene);
        this.show();
    }

    private void update_view() {
        this.barChart.getData().clear();
        for(XYChart.Series s: bar_chart_data){
            this.barChart.getData().add(s);
        }
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

    private void update_bewerber(ObservableList<Studiengang> ol, int index){
        int i = 0;
        for(XYChart.Series<String, Number> s: this.barChart.getData()){
            for(XYChart.Data<String, Number> data : s.getData()){
                data.setYValue(ol.get(i).getBewerber().get());
                i++;
            }
        }

    }

    private void update_categorie(ObservableList<Studiengang> ol){
        int i = 0;
        for(XYChart.Series<String, Number> s: this.barChart.getData()){
            s.setName(ol.get(i).getName().get());
            i++;
        }
    }
    public void update_view(boolean changed, ObservableList<Studiengang> ol, int index){
        if(changed){
            update_bewerber(ol, index);
        }else{
            update_categorie(ol);
        }
    }
}
