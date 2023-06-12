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
    private PieChart pieChart;
    private List<PieChart.Data> om = new ArrayList<>();
    private Group root = new Group();
    private double count = 0;
    private Label caption;

    public PieChartView(List<Fakultaet> om) {
        this.caption = new Label();
        caption.setStyle("-fx-font: 24 arial;");
        this.setTitle("Studiengänge und ihre Bewerber");
        this.setX(10);
        this.setY(10);

        for(Fakultaet s : om) {
            this.om.add(new PieChart.Data(s.getStudiengang().get(), s.getBewerber().get()));
            this.count += s.getBewerber().get();
        }
        this.pieChart = new PieChart(FXCollections.observableArrayList(this.om));
        this.pieChart.setTitle("Studiengänge und ihre Bewerber");
        add_handler();
        this.root.getChildren().addAll(this.pieChart, caption);
        Scene scene = new Scene(root, 500, 500);
        this.setScene(scene);
        this.show();
    }
    public void updatePieChart(int index, List<Fakultaet> ol){
        double old = this.pieChart.getData().get(index).getPieValue();
        this.om.get(index).setName(ol.get(index).getStudiengang().get());
        this.om.get(index).setPieValue(ol.get(index).getBewerber().get());
        this.count -= old;
        this.count += this.pieChart.getData().get(index).getPieValue();
    }

    public void add_handler(){
        for(PieChart.Data d: this.pieChart.getData()){
            d.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    if(e.getButton() == MouseButton.PRIMARY){
                        caption.setTranslateX(e.getSceneX());
                        caption.setTranslateY(e.getSceneY());
                        caption.setText(String.format("%.1f", (d.getPieValue()*100)/count) + "%");
                    }

                }
            });
        }
    }
}
