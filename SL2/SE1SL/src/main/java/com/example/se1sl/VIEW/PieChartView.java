package com.example.se1sl.VIEW;

import com.example.se1sl.Model.Fakultaet;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.List;

public class PieChartView extends Stage {
    private final PieChart pieChart;
    private final List<PieChart.Data> om = new ArrayList<>();
    private double count = 0;
    private final Label caption;

    public PieChartView(List<Fakultaet> om) {
        this.caption = new Label();
        this.setTitle("PieChart Ansicht");
        this.setX(10);
        this.setY(10);

        for(Fakultaet s : om) {
            this.om.add(new PieChart.Data(s.getStudiengang(), s.getBewerber()));
            this.count += s.getBewerber();
        }
        this.pieChart = new PieChart(FXCollections.observableArrayList(this.om));
        this.pieChart.setTitle("Studiengänge und ihre Bewerber");
        add_handler();
        Group root = new Group();
        root.getChildren().addAll(this.pieChart, caption);
        Scene scene = new Scene(root, 500, 400);
        this.setScene(scene);
        this.show();
    }
    public void updatePieChart(List<Fakultaet> ol, int index){
        double old = this.pieChart.getData().get(index).getPieValue();
        this.om.get(index).setName(ol.get(index).getStudiengang());
        this.om.get(index).setPieValue(ol.get(index).getBewerber());
        this.count -= old;
        this.count += this.pieChart.getData().get(index).getPieValue();
    }

    public void add_handler(){
        for(PieChart.Data d: this.pieChart.getData()){
            d.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
                if(e.getButton() == MouseButton.PRIMARY){
                    caption.setTranslateX(e.getSceneX());
                    caption.setTranslateY(e.getSceneY());
                    caption.setText(String.format("%.1f", (d.getPieValue()*100)/count) + "%");
                }

            });
        }
    }
}
