package com.example.sl2.View;

import com.example.sl2.Controller.TestController;
import com.example.sl2.Model.TestModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class InputPanel extends Stage {

    TestModel model;
    PieChartPanel second;
    BarChartPanel third;
    VBox x = new VBox();
    Label l;
    Button b;
    TestController controller;
    String labelText;
    public InputPanel( TestController controller){
        this.controller = controller;
        this.labelText = "";
        init();
    }
    public void init(){
        this.l = new Label(labelText.toString());

        this.b = new Button("Press me");
        TextField text = new TextField(this.labelText);
        x.getChildren().addAll(l, b, text);
        this.setScene(new Scene(x, 200, 200));
        x.setAlignment(Pos.CENTER);
        this.setResizable(false);
        this.setX(1050);
        this.setY(400);
        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                controller.changeModel(labelText, labelText.length());
            }
        });
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.changeModel(labelText, 23);
            }
        });
        this.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent windowEvent) {
                second.close();
                third.close();
            }
        });
        this.show();
        this.second = new PieChartPanel(controller);
        this.third = new BarChartPanel();
    }


}