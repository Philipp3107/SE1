package com.example.slfinnaly;

import com.example.slfinnaly.View.InputView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        new InputView();
    }

    public static void main(String[] args) {
        launch();
    }
}