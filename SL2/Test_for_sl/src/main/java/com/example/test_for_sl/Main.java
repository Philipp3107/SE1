package com.example.test_for_sl;

import com.example.test_for_sl.View.InputView;
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