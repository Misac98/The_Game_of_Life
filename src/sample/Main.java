package sample;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage){
        Label label = new Label("Hello JavaFX");
        stage.setTitle("Game of Life");
        MainView mainView = new MainView();
        Scene scene = new Scene(mainView, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public void main(String[] args) {
        launch(args);

    }
}

