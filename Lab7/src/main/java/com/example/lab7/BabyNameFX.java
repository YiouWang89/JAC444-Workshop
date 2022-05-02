/**********************************************
 *  Workshop 7
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-03-27>
 * **********************************************/

package com.example.lab7;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class BabyNameFX extends Application implements EventHandler<ActionEvent> {
    Button btnSubmit;
    Button btnExit;
    TextField yearInput;
    TextField genderInput;
    TextField nameInput;
    VBox inputRoot;
    VBox messageBox;
    Label message;
    Scene scene;
    Button yes;
    Button no;
    Label errorMsg;

    @Override
    public void start(Stage stage) throws IOException {
        Label year = new Label("Enter the Year: ");
        yearInput = new TextField();
        HBox yearBox = new HBox(year, yearInput);
        yearBox.setPadding(new Insets(20));

        Label gender = new Label("Enter the Gender: ");
        genderInput = new TextField();
        HBox genderBox = new HBox(gender, genderInput);
        genderBox.setPadding(new Insets(20));

        Label name= new Label("Enter the Name: ");
        nameInput = new TextField();
        HBox nameBox = new HBox(name, nameInput);
        nameBox.setPadding(new Insets(20));

        btnSubmit = new Button("Submit Query");
        btnSubmit.setOnAction(this);
        btnExit = new Button("Exit");
        btnExit.setOnAction(this);
        HBox btnBox = new HBox(btnSubmit, btnExit);
        btnBox.setPadding(new Insets(20, 20, 0, 40));
        btnBox.setSpacing(50);
        inputRoot = new VBox(yearBox, genderBox, nameBox, btnBox);
        inputRoot.setPadding(new Insets(20));

//Scene 2
        message = new Label();
        message.setPadding(new Insets(40, 0, 30, 20));
        Label search = new Label("Do you want to Search for another Name ? ");
        search.setPadding(new Insets(20));
        yes = new Button("Yes");
        yes.setOnAction(this);
        no = new Button("No");
        no.setOnAction(this);
        HBox btnBox2 = new HBox(yes, no);
        btnBox2.setPadding(new Insets(20, 20, 40, 40));
        btnBox2.setSpacing(40);
        messageBox = new VBox(message, search, btnBox2);
        messageBox.setPadding(new Insets(20));


        scene = new Scene(inputRoot);
        stage.setTitle("Search Name Ranking Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void handle(ActionEvent event) {
        String msg = new String();
        if(event.getSource() == btnSubmit){
            File file = new File();
            CheckInfo check = new CheckInfo();
            String name = nameInput.getText();
            String gender = genderInput.getText();

            ArrayList<BabyName> babyNames = file.getName(Integer.parseInt(yearInput.getText()));
            BabyName babyName =  check.checkName(name.toLowerCase(), gender, babyNames);
            String rex = "[f|F|M|m]" ;
            if(inputRoot.getChildren().indexOf(errorMsg) != -1){
                inputRoot.getChildren().remove(2);
            }
            if(!gender.matches(rex)){
               errorMsg =new Label("Please input F(Female) or M(Male)");
                errorMsg.setPadding(new Insets(0, 0, 0, 50));
                inputRoot.getChildren().add(2, errorMsg);
            }else if(babyName != null){
                if(gender.equals("F") | gender.equals("f")){
                    msg = "Girl name " + babyName.getGirlName() + " is ranked #"
                            + babyName.getId() + " in " + yearInput.getText() + " year.";
                    message.setText(msg);
                    scene.setRoot(messageBox);
                }else if(gender.equals("M") | gender.equals("m")){
                    msg = "Boy name " + babyName.getBoyName() + " is ranked #"
                            + babyName.getId() + " in " + yearInput.getText() + " year.";
                    message.setText(msg);
                    scene.setRoot(messageBox);
                }
            }else{
                msg = "Sorry, " + nameInput.getText() + " is not in the checking list";
                message.setText(msg);
                scene.setRoot(messageBox);
            }
        }
        if(event.getSource() == btnExit){
            Platform.exit();
        }
        if(event.getSource() == yes){
            yearInput.setText("");
            genderInput.setText("");
            nameInput.setText("");
            scene.setRoot(inputRoot);
        }
        if(event.getSource() == no){
            Platform.exit();
        }
    }
}