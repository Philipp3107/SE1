package com.example.sl2.View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BarChartPanel extends Stage {
    Label x = new Label("BarChartPanel");
    VBox y = new VBox();
    BarChartPanel(){
        y.getChildren().add(x);
        y.setAlignment(Pos.CENTER);
        this.setScene(new Scene(y, 800, 400));
        this.setX(70);
        this.setY(50);
        this.show();
    }
}
