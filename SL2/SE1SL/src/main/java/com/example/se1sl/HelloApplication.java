package com.example.se1sl;

import com.example.se1sl.VIEW.InputView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new InputView();
    }

    public static void main(String[] args) {
        launch();
    }
}