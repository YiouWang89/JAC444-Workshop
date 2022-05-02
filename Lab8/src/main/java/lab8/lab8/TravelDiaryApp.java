/**********************************************
 *  Workshop 8
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-04-03>
 * **********************************************/
package lab8.lab8;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class TravelDiaryApp extends Application {
    ArrayList<Country> countryArrayList=new ArrayList<>();
    ArrayList<Button> countryButton = new ArrayList<>();
    ArrayList<Button> cityButton = new ArrayList<>();
    ChoiceBox<String> countryList;
    ChoiceBox<String> cityList;
    VBox rootAddEntry;
    Label countryErrMsg;
    Label cityErrMsg;
    HBox addCityBox;
    HBox addCountryBox;
    Button addRanking;
    TextField rankingField;
    Scene scene;
    VBox cityRoot;
    VBox homeRoot;
    TextArea descField;
    Button addDesc;
    @Override
    public void start(Stage stage) throws IOException {

        Label welMsg = new Label("Welcome to the Travel Dairy");
        welMsg.setStyle("-fx-text-fill:BLACK; -fx-font-size: 40;");
        Button newEntry = new Button("Create Entry");
        newEntry.setStyle("-fx-text-fill:BLACK; -fx-font-size: 20; ");
        newEntry.setOnAction(e -> scene.setRoot(rootAddEntry));
        Button checkEntry = new Button("Check Entry");
        checkEntry.setStyle("-fx-text-fill:BLACK; -fx-font-size: 20; ");
        checkEntry.setOnAction(e -> countryPage());
        Button exit = new Button("Exit");
        exit.setStyle("-fx-text-fill:BLACK; -fx-font-size: 20; ");
        exit.setOnAction(e -> Platform.exit() );
        homeRoot = new VBox(40);
        homeRoot.setAlignment(Pos.CENTER);
        homeRoot.getChildren().addAll(welMsg, newEntry, checkEntry, exit);


        Label countryName = new Label("Country");
       countryList = new ChoiceBox<>();

        Button addCountry = new Button("Add Country");

        TextField countryField = new TextField();

        Button addCou = new Button("Add");
        addCou.setOnAction(e -> addCountry(countryField));

        Button cancelCou = new Button("Cancel");
        cancelCou.setOnAction(e -> countryField.setText(""));
        addCountryBox = new HBox(20);
        addCountryBox.getChildren().addAll(countryField, addCou, cancelCou);
        addCountryBox.setVisible(false);

        HBox countryBox = new HBox(20);
        countryBox.setPadding(new Insets(20, 20, 40, 20));
        countryBox.getChildren().addAll(countryName, countryList, addCountry,
                addCountryBox);

        addCountry.setOnAction(e -> addCountryBox.setVisible(true));

        Label city = new Label("City");
        cityList = new ChoiceBox<>();

        countryList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                cityList.getItems().clear();
                for(Country selectedC : countryArrayList){
                    if(selectedC.getCountryName().equals(countryList.getValue())){
                        if(selectedC.getCity().size() != 0){
                            for(City c : selectedC.getCity()){
                                cityList.getItems().add(c.getCityName());
                            }
                        }else{
                            cityList.getItems().clear();
                        }
                    }
                }
            }
        });

       Button addCity = new Button("Add City");
       HBox cityBox = new HBox(20);
        cityBox.setPadding(new Insets(20, 20, 0, 20));
        cityBox.getChildren().addAll(city, cityList, addCity);

       TextField cityField = new TextField();
        Label arrive = new Label("Arrive Date");
        DatePicker arriveDate = new DatePicker();
        Label leave = new Label("Leave Date");
        DatePicker leaveDate = new DatePicker();
        Button addCy = new Button("Add");
        addCy.setOnAction(e -> addCy(cityField, arriveDate, leaveDate));
        Button cancelCy = new Button("Cancel");
        cancelCy.setOnAction(e -> {
            cityField.setText("");
            arriveDate.getEditor().clear();
            leaveDate.getEditor().clear();
            addCityBox.setVisible(false);
        });

        addCityBox = new HBox(20);
        addCityBox.setPadding(new Insets(20, 20, 0, 20));
        addCityBox.getChildren().addAll(cityField, arrive, arriveDate, leave,
                leaveDate, addCy, cancelCy );
        addCityBox.setVisible(false);

        VBox cityDate = new VBox(20);
        cityDate.getChildren().addAll(cityBox, addCityBox);
        addCity.setOnAction(e -> addCityBox.setVisible(true));

        Label rankingLabel = new Label("Ranking");
        rankingField = new TextField();
        addRanking = new Button("Add Ranking");
        addRanking.setOnAction(e -> addRank(countryList, cityList, rankingField));
        HBox rankingBox = new HBox(20);
        rankingBox.setPadding(new Insets(20, 20, 40, 20));
        rankingBox.getChildren().addAll(rankingLabel, rankingField, addRanking);

        Label descLabel = new Label("Description");
        descField = new TextArea();
        addDesc = new Button("Add Description");
        addDesc.setOnAction(e -> addDescription(countryList, cityList,descField));
        HBox descBox = new HBox(20);
        descBox.setPadding(new Insets(20, 20, 40, 20));
        descBox.getChildren().addAll(descLabel, descField, addDesc);

        Button submit = new Button("Submit");
        submit.setOnAction(e -> countryPage());
        Button cancel = new Button("Cancel");
        cancel.setOnAction( e -> scene.setRoot(homeRoot));
        submit.setMaxWidth(Double.MAX_VALUE);
        cancel.setMaxWidth(Double.MAX_VALUE);
        HBox submitButtonBox = new HBox(40);
        submitButtonBox.setPadding(new Insets(0, 0, 40, 40));
        submitButtonBox.getChildren().addAll(submit, cancel);


        rootAddEntry = new VBox(20);
        rootAddEntry.getChildren().addAll(countryBox, cityDate, rankingBox, descBox, submitButtonBox);
        rootAddEntry.setStyle("-fx-text-fill:BLACK; -fx-font-size: 15;");

        scene = new Scene(homeRoot);
        stage.setWidth(1300);
        stage.setHeight(600);
        stage.setTitle(" Travel Diary ");
        stage.setScene(scene);
        stage.show();
    }

    private void addDescription(ChoiceBox<String> countryList, ChoiceBox<String> cityList, TextArea descField) {
        for(Country country : countryArrayList){
            if(countryList.getValue().equals(country.getCountryName())){
                for(City city: country.getCity()){
                    if(city.getCityName().equals(cityList.getValue())){
                        city.setDescription(descField.getText());
                    }
                }
            }
        }
        descField.setText("");
    }

    private void countryPage() {
        VBox countryRoot = new VBox(40);
        countryRoot.setAlignment(Pos.CENTER);
        countryRoot.setStyle("-fx-text-fill:BLACK; -fx-font-size: 15;");
        Button homeButton = new Button("Home");
        homeButton.setOnAction( e ->scene.setRoot(homeRoot) );
        scene.setRoot(countryRoot);
        if(countryArrayList.size() == 0){
            Label msg = new Label("There are no travel entry.");
            msg.setStyle("-fx-text-fill:BLACK; -fx-font-size: 30;");
            countryRoot.getChildren().addAll(msg, homeButton);
        }else{
            for(int i=0; i< countryArrayList.size(); i++){
                Button countryEntry = new Button(countryArrayList.get(i).getCountryName());
                int finalI = i;
                countryEntry.setOnAction(e -> cityPage(countryArrayList.get(finalI)));
                countryButton.add(countryEntry);
                countryRoot.getChildren().add(countryEntry);
            }
        }

    }

    private void cityPage(Country country) {
        cityRoot = new VBox(40);
        cityRoot.setAlignment(Pos.CENTER);
        cityRoot.setStyle("-fx-text-fill:BLACK; -fx-font-size: 15;");
        Button homeButton = new Button("Home");
        homeButton.setOnAction( e ->scene.setRoot(homeRoot) );
        scene.setRoot(cityRoot);
        for(int i = 0; i< country.getCity().size(); i++){
            Button cityEntry = new Button(country.getCity().get(i).getCityName());
            int finalI = i;
            cityEntry.setOnAction(e -> travelInfo(country, country.getCity().get(finalI)));
            cityButton.add(cityEntry);
            cityRoot.getChildren().add(cityEntry);
        }
        cityRoot.getChildren().add(homeButton);
    }

    private void travelInfo(Country country, City city) {
        VBox travelInfoRoot = new VBox(40);
        travelInfoRoot.setAlignment(Pos.CENTER);
        scene.setRoot(travelInfoRoot);
        Label countryName = new Label("Country: " + country.getCountryName());
        Label cityName = new Label("City: " + city.getCityName());
        Label arriveLabel = new Label("Arrive Date: " + city.getArriveDate().toString());
        Label leaveLabel = new Label("Leave Date: " + city.getLeaveDate().toString());
        Label rankingLabel = new Label("Ranking: " + Double.toString(city.getRanking()));
        Label descLabel = new Label("Description: " + city.getDescription());
        Button homeButton = new Button("Home");
        homeButton.setOnAction( e ->scene.setRoot(homeRoot) );
        Button previousPage = new Button("Previous Page");
        previousPage.setOnAction(e -> scene.setRoot(cityRoot));
        HBox buttonBox = new HBox(30);
        buttonBox.getChildren().addAll(previousPage, homeButton);
        buttonBox.setAlignment(Pos.CENTER);
        travelInfoRoot.getChildren().addAll(countryName, cityName, arriveLabel, leaveLabel, rankingLabel, descLabel, buttonBox);
        travelInfoRoot.setStyle("-fx-text-fill:BLACK; -fx-font-size: 15;");

    }

    private void addRank(ChoiceBox<String> countryList, ChoiceBox<String> cityList, TextField rankingField) {
        for(Country country : countryArrayList){
            if(countryList.getValue().equals(country.getCountryName())){
                for(City city: country.getCity()){
                    if(city.getCityName().equals(cityList.getValue())){
                        city.setRanking(Double.parseDouble(rankingField.getText()));
                    }
                }
            }
        }
        rankingField.setText("");
    }

    private void addCy(TextField cityField, DatePicker arriveDate, DatePicker leaveDate) {
        String cityName = cityField.getText();
        LocalDate arrive = arriveDate.getValue();
        LocalDate leave = leaveDate.getValue();
        City newCity = new City(cityName, arrive, leave);
        Boolean isExist = false;

        String countryName = countryList.getValue();

        if(rootAddEntry.getChildren().indexOf(cityErrMsg) != -1){
            rootAddEntry.getChildren().remove(2);
        }

        for(Country country : countryArrayList){
            if(country.getCountryName().equals(countryName)){
                if(country.getCity().size() != 0){
                    for(City city : country.getCity()){
                        if(city.getCityName().equals(cityName)){
                            cityField.setText("");
                            arriveDate.getEditor().clear();
                            leaveDate.getEditor().clear();
                            cityErrMsg = new Label(cityName + " is already in the list");
                            rootAddEntry.getChildren().add(2, cityErrMsg);
                            isExist = true;
                    }
                }
                }
                if(!isExist){
                    country.addCity(newCity);
                    cityList.getItems().add(cityName);
                    cityField.setText("");
                    arriveDate.getEditor().clear();
                    leaveDate.getEditor().clear();
                    cityList.setValue(cityName);
                }
                addCityBox.setVisible(false);
            }
        }



    }

    private void addCountry(TextField countryField) {
        String countryName = countryField.getText();
        Boolean isExist = false;

        if(rootAddEntry.getChildren().indexOf(countryErrMsg) != -1){
            rootAddEntry.getChildren().remove(1);
        }

        for(Country newCountry : countryArrayList){
            if(newCountry.getCountryName().equals(countryName)){
                countryField.setText("");
                countryErrMsg = new Label(countryName + " is already in the list");
                rootAddEntry.getChildren().add(1, countryErrMsg);
                isExist = true;
            }
        }
        if(!isExist){
            countryArrayList.add(new Country(countryName));
            countryList.getItems().add(countryName);
            countryField.setText("");
            countryList.setValue(countryName);
        }
        addCountryBox.setVisible(false);
    }

    public static void main(String[] args) {
        launch();
    }
}