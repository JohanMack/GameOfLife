package com.johan.gameOfLife.gol;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class GameOfLifeApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MainView mainView = new MainView();
        Scene scene = new Scene(new StackPane(mainView), 640, 480);
        stage.setScene(scene);
        stage.show();
        mainView.draw();
    }

    public static void main(String[] args) {
        launch();
    }
}
