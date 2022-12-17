package ui.project;
import ConsoleUI.Mains;
import BL.Normal;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        if (Mains.count == 1) {
            System.out.println("Normal Mode");

        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("normal.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 960, 463);
            stage.setTitle("[No Name] - VIM");
            Image image = new Image("C:\\Users\\ST\\IdeaProjects\\Project\\src\\main\\java\\images\\heheboi.jpg");
            stage.getIcons().add(image);
            stage.setScene(scene);
            stage.show();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}