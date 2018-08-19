package books.LearnJavaFX8.chapter1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloFXAppWithScene extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label nameLabel     = new Label("Enter your name: ");
        TextField nameField = new TextField();

        Label message = new Label();
        message.setStyle("-fx-text-fill: blue;");

        // Create button
        Button sayHelloBtn = new Button("Say hello");
        Button exitBtn     = new Button("Exit");

        // Add the event handler for the say hello button
        sayHelloBtn.setOnAction(event -> {
            String name = nameField.getText();
            if (name.trim().length() > 0) {
                message.setText("Hello " + name);
            } else {
                message.setText("Hello there");
            }
        });

        // Add the event handler for the Exit button
        exitBtn.setOnAction(event -> Platform.exit());


        VBox root = new VBox(); // Create the root node
        root.setSpacing(5);     // Set the vertical Spacing between children to 5px
        root.getChildren().addAll(nameLabel, nameField, message, sayHelloBtn, exitBtn);

        Scene scene = new Scene(root, 350, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Improved Hello JavaFX Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
