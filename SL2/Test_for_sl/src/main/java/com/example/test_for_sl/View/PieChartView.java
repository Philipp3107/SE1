package com.example.test_for_sl.View;

import com.example.test_for_sl.Model.Fakultaet;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class PieChartView extends Stage {
    private final PieChart pieChart = new PieChart();
    private double count = 0;
    private final Label caption;

    public PieChartView(List<Fakultaet> om) {
        this.caption = new Label();
        build_chart(om);
        setup_screen();
    }

    /**
     * Baut die Elemente des PieChart auf basis der Liste aus dem AppController.
     * @param list<Fakulteat>
     */
    public void build_chart(List<Fakultaet> list){
        List<PieChart.Data> data = new ArrayList<>();
        for(Fakultaet fakultaet: list){
            data.add(new PieChart.Data(fakultaet.getStudiengang(), fakultaet.getBewerber()));
            this.count += fakultaet.getBewerber();
        }
        this.pieChart.setData(FXCollections.observableArrayList(data));
        this.pieChart.setTitle("Studiengänge und ihre Bewerber");
    }

    /**
     * Fügt die Elemente zur Scene hinzu und setzt BIldschirmposition, größe und Titel des Fensters fest.
     */
    public void setup_screen(){
        this.setTitle("PieChart Ansicht");
        add_handler();
        Group root = new Group();
        root.getChildren().addAll(this.pieChart, caption);

        //Größe und Platz des Fensters auf dem Bildschirm
        Scene scene = new Scene(root, 500, 400);
        this.setX(10);
        this.setY(10);

        this.setScene(scene);
        this.show();
    }

    /**
     * Ändert die bearbeiteten Elemente vom AppController im PieChart.
     * @param list  Liste aus Fakultaets objekten
     * @param index index des geänderten Objektes
     */
    public void updatePieChart(List<Fakultaet> list, int index){
        double old = this.pieChart.getData().get(index).getPieValue();
        this.pieChart.getData().get(index).setName(list.get(index).getStudiengang());
        this.pieChart.getData().get(index).setPieValue(list.get(index).getBewerber());
        this.count -= old;
        this.count += this.pieChart.getData().get(index).getPieValue();
    }

    /**
     * Fügt zum Piechart und den einzelnen PieParts das PRESSED MouseEvent bei linksklick hinzu und zeigt die einzelnen Prozente an.
     */
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
