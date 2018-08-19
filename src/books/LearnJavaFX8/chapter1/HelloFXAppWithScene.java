package books.LearnJavaFX8.chapter1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloFXAppWithScene extends Application {

    @Override
    public void start(Stage primaryStage) {
        Text message = new Text("Hello JavaFX");
        VBox root = new VBox();
        root.getChildren().add(message);

        Scene scene = new Scene(root, 300, 50);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello JavaFX Application with a Scene");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
