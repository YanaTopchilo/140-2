/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package javafxexample2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Color; 
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.*;


/**
 *
 * @author Topchilo
 */
public class MainClass extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        Label welcomLbl = new Label("Welcome");
        welcomLbl.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        AnchorPane.setTopAnchor(welcomLbl, 30.0);
        AnchorPane.setLeftAnchor(welcomLbl, 60.0);
        Label userLbl = new Label("User Name:");
        userLbl.setFont(Font.font(20));
        AnchorPane.setTopAnchor(userLbl, 80.0);
        AnchorPane.setLeftAnchor(userLbl, 60.0);
        
        TextField textUser = new TextField(); 
        AnchorPane.setTopAnchor(textUser, 80.0);
        AnchorPane.setLeftAnchor(textUser, 200.0);
        AnchorPane.setRightAnchor(textUser, 40.0);
        
        Label passLbl = new Label("Password:");
        passLbl.setFont(Font.font(20));
        AnchorPane.setTopAnchor(passLbl, 120.0);
        AnchorPane.setLeftAnchor(passLbl, 60.0);
        
        TextField textPass = new TextField();
        textPass.setPrefColumnCount(20);
        AnchorPane.setTopAnchor(textPass, 120.0);
        AnchorPane.setLeftAnchor(textPass, 200.0);
        AnchorPane.setRightAnchor(textPass, 40.0);
        
        Button btn = new Button();
        btn.setText("Sign in");
        AnchorPane.setTopAnchor(btn, 170.0);
        AnchorPane.setRightAnchor(btn, 40.0);
    
        Label enterLbl = new Label();
        AnchorPane.setTopAnchor(enterLbl, 220.0);
        AnchorPane.setLeftAnchor(enterLbl, 60.0);
        
        btn.setOnAction((ActionEvent) -> {
        String userEnter = textUser.getText();
        String passEnter = textPass.getText(); 
        RepositoryImpl catalogUser = new RepositoryImpl();
         for (int i = 0; i<catalogUser.getUsers().size(); i++){
             if (catalogUser.getUsers().get(i).getName().equals(userEnter) &
             catalogUser.getUsers().get(i).getPassword().equals(passEnter)){
                  new PersonStage().show();
             }
             else { enterLbl.setText("User or password is not correct");
                enterLbl.setTextFill(Color.RED);}
         }

        });
         
        AnchorPane root = new AnchorPane(welcomLbl,userLbl, textUser, passLbl, textPass, btn, enterLbl);
         
        Scene scene = new Scene(root, 400, 300);     
        primaryStage.setTitle("JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }   
  
    public static void main(String[] args) {
        launch(args);
    }
    
}
