/**********************************************
 *  Workshop 6
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-03-20>
 * **********************************************/
package com.example.lab6;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class BMICalculator extends Application {
    double BMI = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //Radio Button
        ToggleGroup groupChooseScale = new ToggleGroup();
        RadioButton btnCmKg = new RadioButton("cm/KG");
        RadioButton btnInchLb = new RadioButton("Inch/Lb");
        btnCmKg.setToggleGroup(groupChooseScale);
        btnInchLb.setToggleGroup(groupChooseScale);
        //CM/KG is selected by default
        btnCmKg.setSelected(true);
        //VBox to contain the radio button and the labels
        VBox btnBox = new VBox(10);
        Text boxTitle = new Text("Choose Scale");
        boxTitle.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        //Color picked for button part
        ColorPicker btnColor = new ColorPicker();
        btnColor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Paint fill = btnColor.getValue();
                BackgroundFill backgroundFill = new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(backgroundFill);
                btnBox.setBackground(background);
            }
        });

        btnBox.getChildren().addAll(boxTitle, btnColor, btnCmKg, btnInchLb);
        btnBox.setPadding(new Insets(20));

        //Data part
        Label heightLabel = new Label("HEIGHT (in Centimeter)");
        Label weightLabel = new Label("WEIGHT (in KiloGram)");

        TextField height = new TextField();
        TextField weight = new TextField();

        HBox ht = new HBox(10);
        HBox wt = new HBox(10);
        ht.getChildren().addAll(heightLabel, height);
        wt.getChildren().addAll(weightLabel, weight);
        //Calculate Button
        Button btnCalculate = new Button("Calculate");
        VBox dataBox = new VBox(10);
        ColorPicker btnData = new ColorPicker();
        btnData.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Paint fill = btnData.getValue();
                BackgroundFill backgroundFill = new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(backgroundFill);
                dataBox.setBackground(background);
            }
        });
        dataBox.getChildren().addAll(btnData, ht, wt, btnCalculate);
        dataBox.setPadding(new Insets(0));
//Left up box
        VBox leftUp = new VBox(10);
        leftUp.getChildren().addAll(btnBox, dataBox);
        leftUp.setPadding(new Insets(0));

//TableView part
        //BMI Column
        TableColumn<BMIStatus, String> BMIColumn = new TableColumn<>("BMI");
        BMIColumn.setMinWidth(200);
        BMIColumn.setCellValueFactory(new PropertyValueFactory<>("BMI"));
        //Status Column`
        TableColumn<BMIStatus, String> statusColumn = new TableColumn<>("Weight Status");
        statusColumn.setMinWidth(200);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableView<BMIStatus> table = new TableView<>();
        table.setItems(getBMIStatus());
        table.getColumns().addAll(BMIColumn, statusColumn);
//Change the color for each row
        table.setRowFactory(row -> new TableRow<BMIStatus>() {
            @Override
            public void updateItem(BMIStatus bmiS, boolean empty) {
                if (bmiS == null) {
                    setStyle("");
                } else if (bmiS.getId() == 1) {
                    setStyle("-fx-background-color: red;");
                } else if (bmiS.getId() == 2) {
                    setStyle("-fx-background-color: yellow;");
                } else if (bmiS.getId() == 3) {
                    setStyle("-fx-background-color: blue;");
                } else if (bmiS.getId() == 4) {
                    setStyle("-fx-background-color: green;");
                }
            }
        });
//Up box
        HBox up = new HBox();
        up.getChildren().addAll(leftUp, table);

        //Slider part
        VBox slideBox = new VBox(10);
        Label sliderHL = new Label("Height");
        Slider sliderHeight = new Slider(0, 200, 0);
        sliderHeight.setShowTickMarks(true);
        sliderHeight.setShowTickLabels(true);
        sliderHeight.setMajorTickUnit(10f);
        sliderHeight.setBlockIncrement(0.1f);

        Label sliderWL = new Label("Weight");
        Slider sliderWeight = new Slider(10, 200, 0);
        sliderWeight.setShowTickMarks(true);
        sliderWeight.setShowTickLabels(true);
        sliderWeight.setMajorTickUnit(20f);
        sliderWeight.setBlockIncrement(5f);

        slideBox.getChildren().addAll(sliderHL, sliderHeight, sliderWL, sliderWeight);

        sliderHeight.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                height.setText(String.valueOf((int) sliderHeight.getValue()));
            }
        });

        sliderWeight.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                weight.setText(String.valueOf((int) sliderWeight.getValue()));
            }
        });

        btnCalculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double heightInt = 0;
                double weightInt = 0;

                heightInt = Integer.parseInt(height.getText());
                weightInt = Integer.parseInt(weight.getText());

                if (btnCmKg.isSelected()) {
                    BMI = weightInt / (heightInt * heightInt) * 10000;
                } else if (btnInchLb.isSelected()) {
                    BMI = weightInt * 703 / (heightInt * heightInt);
                }

                BMI = (double) Math.round(BMI * 100) / 100;

                if ((leftUp.getChildren()).size() > 2) {
                    leftUp.getChildren().remove(2);
                }

                Label msg = new Label();
                msg.setText("Your BMI is " + BMI);
                msg.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                leftUp.getChildren().add(msg);
            }
        });


        VBox root = new VBox(10);
        ColorPicker clrRoot = new ColorPicker();
        clrRoot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Paint fill = clrRoot.getValue();
                BackgroundFill backgroundFill = new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(backgroundFill);
                root.setBackground(background);
            }
        });
        root.getChildren().addAll(up, clrRoot, slideBox);


        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("BMI Calculator");
        primaryStage.setAlwaysOnTop(true);

        primaryStage.show();

    }

    public ObservableList<BMIStatus> getBMIStatus() {
        ObservableList<BMIStatus> status = FXCollections.observableArrayList();
        status.add(new BMIStatus("Below 18.5", "Underweight", 1));
        status.add(new BMIStatus("18.5 - 24.9", "Normal", 2));
        status.add(new BMIStatus("24.9 - 29.9", "Overweight", 3));
        status.add(new BMIStatus("30 and Above", "Obese", 4));
        return status;
    }
}