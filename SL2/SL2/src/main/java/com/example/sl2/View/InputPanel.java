package com.example.sl2.View;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class InputPanel extends Stage {
    Boolean opened = false;
    PieChartPanel second;
    BarChartPanel third;
    HBox x = new HBox();
    public InputPanel(){

        Label l = new Label("Inputpanel");
        for(int i = 0; i < 5; i++){

        }
        //openOther.setAlignment(Pos.CENTER);
        x.getChildren().add(l);
        this.setScene(new Scene(x, 200, 200));
        x.setAlignment(Pos.CENTER);
        this.setResizable(false);
        this.setX(1050);
        this.setY(400);
        this.setOnCloseRequest(new EventHandler<WindowEvent>(){

            @Override
            public void handle(WindowEvent windowEvent) {
                second.close();
                third.close();
            }
        });
        this.show();
        this.second = new PieChartPanel();
        this.third = new BarChartPanel();

    }
}