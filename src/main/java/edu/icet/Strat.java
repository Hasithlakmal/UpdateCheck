package edu.icet;

import edu.icet.Services.AppUpdater;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Strat extends Application {

    public static void main (String [] args){

        AppUpdater.config();
        launch();

    }

    @Override
    public void start(Stage stage) throws Exception {


        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/Viwe/log.fxml"))));
        stage.show();

    }
}
