package com.contirossini.graphicalswissqrbillgenerator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SwissQRBillGenerator extends Application {
    static Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SwissQRBillGenerator.class.getResource("chbillgen-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1024, 600);
        stage.setTitle("SwissQRBillGenerator by Sergio Conti Rossini");
        stage.setScene(scene);
        stage.show();
    }

    static Scene getScene(){
        return scene;
    }

    public static void main(String[] args) {
        launch();
    }
}