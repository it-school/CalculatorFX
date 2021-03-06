package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainClass extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(root));
        primaryStage.getScene().getStylesheets().add(getClass().getResource("css/style.css").toExternalForm());  // CSS из внешнего файла
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        root.styleProperty().setValue("-fx-background-color: lightblue; -fx-background-radius: 30px; -fx-border-color: blue; -fx-border-radius: " +
                                              "30px; -fx-border-width: 5px;"); // CSS локально
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
