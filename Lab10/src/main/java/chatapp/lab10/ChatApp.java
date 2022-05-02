/**********************************************
 *  Workshop 10
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-04-17>
 * **********************************************/
package chatapp.lab10;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Date;

public class ChatApp extends Application{
    Server server;
    Group serverGroup;
    TextField clientName;
    TextField message;
    Stage clientStage;
    Label nameLabel;
    Group clientGroup;
    Client client;
    VBox serverMsgGroup;
    VBox chatMessage;
    String messageFromClient;

    @Override
    public void start(Stage stage) throws Exception {
        server = new Server();
        server.start();
        Label serverMsg = new Label("MultiThreadServer started at " + LocalDateTime.now());
        serverMsg.setLayoutX(10);

        Button newConnection = new Button("Connection");
        newConnection.setPrefWidth(450);
        newConnection.setLayoutX(25);
        newConnection.setLayoutY(430);
        newConnection.setOnAction(e -> clientConnect());

        serverMsgGroup = new VBox(10);
        serverMsgGroup.getChildren().add(serverMsg);
        serverMsgGroup.setStyle("-fx-background-color:yellow;");

        serverGroup = new Group();
        serverGroup.getChildren().addAll(serverMsgGroup, newConnection);
        serverGroup.setStyle("-fx-text-fill:BLACK; -fx-font-size: 15;");

        Scene scene = new Scene(serverGroup);
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setTitle("Multi-Threaded Server");
        stage.setScene(scene);
        stage.show();

    }

    private void clientConnect() {
        client = new Client();
        client.send("Connection is Establish");
        Label ms1 = new Label("Address " + server.getSocket().getInetAddress() + "Port " + server.getSocket().getPort());
        serverMsgGroup.getChildren().add(ms1);

        clientStage = new Stage();

        Label nameLabel = new Label("Name: ");
        clientName = new TextField();
        HBox nameBox = new HBox(30);
        nameBox.getChildren().addAll(nameLabel, clientName);
        nameBox.setLayoutX(20);
        nameBox.setLayoutY(400);

        Label msgLabel = new Label("Message: ");
        message = new TextField();
        Button send = new Button("Send");
        send.setOnAction(e -> sendMsg());
        Button endConnection = new Button("End Connection");
        endConnection.setOnAction(e -> endConnect());

        HBox messageBox = new HBox(10);
        messageBox.getChildren().addAll(msgLabel, message, send, endConnection);
        messageBox.setLayoutX(20);
        messageBox.setLayoutY(430);

        chatMessage = new VBox(10);

       clientGroup = new Group(chatMessage, nameBox, messageBox);
        clientGroup.setStyle("-fx-text-fill:BLACK; -fx-font-size: 15;");

        Scene clientScene = new Scene(clientGroup);
        clientStage.setWidth(500);
        clientStage.setHeight(500);
        clientStage.setTitle("Client");
        clientStage.setScene(clientScene);
        clientStage.show();
    }

    private void endConnect() {
        client.close();
        Platform.exit();
    }

    private void sendMsg() {
        client.setUserName(clientName.getText());
        clientStage.setTitle(clientName.getText());
        String msg = client.getUserName() + ": " + message.getText();
        client.send(msg);
        Label newMsg = new Label(msg);
        Label newMsg2 = new Label(msg);
        serverMsgGroup.getChildren().add(newMsg2);
        chatMessage.getChildren().add(newMsg);
        message.setText("");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
