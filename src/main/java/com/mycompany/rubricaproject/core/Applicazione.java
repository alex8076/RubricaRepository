/**
 * @file Applicazione.java
 * @brief La classe si occupa di gestire la funzione principale main e la funzione start
 * @see Application
 * 
 * @date 2024-12-7
 */

package com.mycompany.rubricaproject.core;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Applicazione extends Application {
    
     @Override
    public void start(Stage primaryStage) throws Exception {
        
       // Collego la classe Applicazone alla View
       Parent root = FXMLLoader.load(getClass().getResource("rubricaproject/gui/View.fxml"));
               
        Scene scene = new Scene(root);

        primaryStage.setTitle("Rubrica");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}