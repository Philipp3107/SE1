package com.example.mvcsl2se1;

import Controller.AppController;
import View.InputView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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