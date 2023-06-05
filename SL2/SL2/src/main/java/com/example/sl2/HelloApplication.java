package com.example.sl2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new FirstStage();
    }

    public static void main(String[] args) {
        launch();
    }
}

 class FirstStage extends Stage {
    Boolean opened = false;
    HBox x = new HBox();
    FirstStage(){
        Label l = new Label("Hier kommen die Angaben hin");
        x.setAlignment(Pos.CENTER);
        //openOther.setAlignment(Pos.CENTER);
        x.getChildren().add(l);

        this.setScene(new Scene(x, 200, 200));
        this.setResizable(false);
        this.setX(1050);
        this.setY(400);
        this.show();
        open_stages();

    }

    public void open_stages(){
        new SecondStage();
        new ThirdStage();
    }
}

class SecondStage extends Stage{
    Label x = new Label("Hier das Balkendiagramm");
    VBox y = new VBox();
    SecondStage(){
        y.getChildren().add(x);
        y.setAlignment(Pos.CENTER);
        this.setScene(new Scene(y, 800, 400));
        this.setX(70);
        this.setY(50);
        this.show();
    }
}

class ThirdStage extends Stage{
    Label x = new Label("Hier das Tortendiagramm");
    VBox y = new VBox();
    ThirdStage(){
        y.getChildren().add(x);
        y.setAlignment(Pos.CENTER);
        this.setScene(new Scene(y, 800, 400));
        this.setX(70);
        this.setY(530);
        this.show();
    }
}