package com.jtmjinfo.crudestudantes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Principal.class.getResource("telas/estudante.fxml"));

        Scene cenaPrincipal = new Scene(fxmlLoader.load());

        primaryStage.setScene(cenaPrincipal);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch();
    }
}

