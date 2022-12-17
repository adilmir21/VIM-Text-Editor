package ui.project;

import BL.Edit;
import BL.Normal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Insert extends Application {
    private static Insert obj = new Insert(); // design pattern "singleton". Can only make 1 object
    private Insert(){}
    public Insert Insertobj()
    {
        return obj;
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InsertController.class.getResource("insert1.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), 960.0D, 480.0D);
        stage.setTitle(" [No Name] - VIM");
        Image image = new Image("C:\\Users\\ST\\IdeaProjects\\Project\\src\\main\\java\\images\\heheboi.jpg");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
