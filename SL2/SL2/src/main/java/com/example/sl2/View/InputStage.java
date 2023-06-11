package com.example.sl2.View;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class InputStage extends Stage {
    Label l;
    VBox vb;
    Scene scene;
    Stage second;
    Stage third;

    public InputStage() {

    }

    public void init(){
        this.l = new Label("InputStage");
        this.vb = new VBox();
        vb.getChildren().add(l);
        this.scene = new Scene(vb, 200, 200);
        this.setResizable(false);
        this.setX(1050);
        this.setY(400);
        this.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                second.close();
                third.close();
            }
        });
        this.show();
        this.second = new InputStage();
        this.third = new InputStage();
    }
}
