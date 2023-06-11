package com.example.sl2;

import com.example.sl2.Controller.TestController;
import com.example.sl2.Model.TestModel;
import com.example.sl2.View.InputPanel;
import com.example.sl2.View.InputStage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //new InputPanel(new TestController(new TestModel()));
        new InputStage();
    }

    public static void main(String[] args) {
        launch();
    }
}