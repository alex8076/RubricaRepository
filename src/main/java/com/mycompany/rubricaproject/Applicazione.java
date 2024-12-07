/**
 * @file Applicazione.java
 * @brief La classe si occupa di gestire la funzione principale main e la funzione start
 * @see Application
 * 
 * @date 2024-12-7
 */

package com.mycompany.rubricaproject;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Applicazione extends Application {
     @Override
    public void start(Stage primaryStage) {
  
        Button btn = new Button("Cliccami!");
        btn.setOnAction(e -> System.out.println("Hai cliccato il pulsante!"));

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Progetto JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}