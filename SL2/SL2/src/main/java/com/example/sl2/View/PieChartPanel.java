package com.example.sl2.View;

import com.example.sl2.Controller.TestController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Map;

public class PieChartPanel extends Stage {

    VBox y = new VBox();
    TestController controller;
    PieChartPanel(TestController controller){
        this.controller = controller;
        for(PiePart p: controller.getValues()){
            HBox x = new HBox();
            Label l1 = new Label(p.getKey());
            Label l2 = new Label("" + p.getValue());
            x.getChildren().addAll(l1, l2);
            y.getChildren().add(x);
        }
        Label x = new Label("PieChartPanel");
        this.setTitle("Tortendiagramm");
        y.getChildren().add(x);
        y.setAlignment(Pos.CENTER);
        this.setScene(new Scene(y, 800, 400));
        this.setX(70);
        this.setY(530);
        this.show();
    }
}