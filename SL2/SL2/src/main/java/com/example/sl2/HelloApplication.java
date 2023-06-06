package com.example.sl2;

import com.example.sl2.View.InputPanel;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new InputPanel();

    }

    public static void main(String[] args) {
        launch();
    }
}
