package com.chicha.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Clock extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("clock-view.fxml")));

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Mechanical Clock");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}