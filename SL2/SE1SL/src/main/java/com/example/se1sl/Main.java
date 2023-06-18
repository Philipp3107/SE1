package com.example.se1sl;

import com.example.se1sl.View.InputView;
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