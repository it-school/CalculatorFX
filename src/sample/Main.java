package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(root));
        primaryStage.getScene().getStylesheets().add((getClass().getResource("css/style.css")).toExternalForm());  // CSS из внешнего файла
        root.styleProperty().setValue("-fx-background-color: lightblue; -fx-background-radius: 10px; -fx-border-color: blue; -fx-border-radius: 10px; -fx-border-width: 10px;"); // CSS локально
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
