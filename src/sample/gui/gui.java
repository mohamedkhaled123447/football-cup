package sample.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class gui extends Application {
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(loader.load());
      /*  String css = this.getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);*/
        stage.setScene(scene);
        stage.setTitle("footboll cup");
        stage.show();
    }
}
