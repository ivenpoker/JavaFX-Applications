package books.LearnJavaFX8.chapter1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

public class FXParamApp extends Application {


    @Override
    public void start(Stage primaryStage) {
        // Get application Params
        Parameters param = this.getParameters();
        Map<String, String> nameParams = param.getNamed();
        List<String> unnamedParams = param.getUnnamed();
        List<String> rawParams = param.getRaw();

        String paramStr = "Named Parameters: " + nameParams + "\n" +
                "Unnamed Parameters: " + unnamedParams + "\n" +
                "Raw Parameters: " + rawParams;

        TextArea textArea = new TextArea(paramStr);
        textArea.setEditable(false);
        Group root = new Group(textArea);
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Application Parameters");
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }

}
