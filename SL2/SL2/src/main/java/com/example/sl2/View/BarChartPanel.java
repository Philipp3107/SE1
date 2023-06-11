package com.example.sl2.View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BarChartPanel extends Stage {

    VBox y = new VBox();
    BarChartPanel(){
        this.setTitle("Balkendiagramm");
        Label x = new Label();
        y.getChildren().add(x);
        y.setAlignment(Pos.CENTER);
        this.setScene(new Scene(y, 800, 400));
        this.setX(70);
        this.setY(50);
        this.show();
    }
}
