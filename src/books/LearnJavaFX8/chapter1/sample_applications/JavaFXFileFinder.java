package books.LearnJavaFX8.chapter1.sample_applications;

import books.LearnJavaFX8.HelperClasses.FileFinder;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


// Even though this program is working. It has some issues at run time
// If you run the program and pass in a directory with a 'lot' of contents,
// while searching for a specified file, the program might 'freeze' and not
// be usable for a period of time (this will depend on the search directory of course!).
// And also, the processing feedback message 'Searching file...' is not visible to the
// user, due to the fast nature of the program execution.
//
//      Solution:
//
// One way to solve the problem is by using the ideas of 'Threads'. We create a a new
// thread to run the search, while deactivating the 'search' button and leaving the 'exit'
// button intact. If the users decides to terminate the search, all we need to do is kill
// that thread and then exit the program. The reason for deactivating the 'search' button
// is to prevent the user from searching for a new file, while the previous search is still
// ongoing. To track the end of the search, all we need to do is to keep a boolean variable
// ('stillSearching' for example) that will be set to false when the thread is done. We then
// re-activate the search button and manipulate the results we've obtain to the GUI.

public class JavaFXFileFinder extends Application {




    @Override
    public void start(Stage primaryStage) {
        Text searchResults = new Text();
        searchResults.setStyle("-fx-text-fill: dodgerblue;");
        Text searchProcess = new Text();

        TextField fileNameField = new TextField("Enter file name");
        TextField searchFolderField = new TextField("Enter search origin path");

        Button searchButton = new Button("Search");
        Button exitButton = new Button("Exit program");

        exitButton.setOnAction(event -> Platform.exit());

        searchButton.setOnAction(event -> {

            String fileName = fileNameField.getText();
            if (fileName.trim().length() > 0) {
                if (fileName.indexOf(" ") > 0) {
                    searchResults.setText("No spaces allowed in file name");
                    return;
                }
                String searchFolder = searchFolderField.getText();
                if (searchFolder.trim().length() > 0) {

                    try {
                        Path fileDir = Paths.get(searchFolder);
                        FileFinder finder = new FileFinder(fileName);
                        searchProcess.setText("Searching file ....");
                        Files.walkFileTree(fileDir, finder);

                        ArrayList<Path> foundFile = finder.getFoundPaths();
                        if (foundFile.size() > 0) {
                            StringBuilder filePaths = new StringBuilder();
                            for (Path path: foundFile) {
                                System.out.println("Path found: " + path);
                                filePaths.append(path).append("\n");
                            }
                            searchProcess.setText("");
                            searchResults.setText(filePaths.toString());
                        } else {
                            searchProcess.setText("");
                            searchResults.setText("Ooops! Could'nt find '" + fileName + "'");
                        }
                    }
                    catch (InvalidPathException invalidPath) {
                        searchProcess.setText("");
                        searchResults.setText("Invalid path!");
                    }
                    catch (IOException ioException) {
                        searchProcess.setText("");
                        searchResults.setText("File Exception:  " + ioException.getMessage());
                    }


                } else {
                    searchResults.setText("Please enter the folder to start searching form");
                }
            } else {
                searchResults.setText("Please enter file name to search for");
            }
        });

        VBox root = new VBox();
        root.setSpacing(2);     // set the spacing to 2px
        root.getChildren().addAll(fileNameField, searchFolderField, searchProcess,
                searchButton, exitButton, searchResults);

        Scene scene = new Scene(root, 350, 150);
        primaryStage.setTitle("File Search Program");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
