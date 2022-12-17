package ui.project;

import BL.Normal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class InsertController implements InsertMode{ // whole class implemented in BL
    private static InsertController obj = new InsertController(); // design pattern "singleton". Can only make 1 object
    private InsertController(){}
    public static InsertController InsertControllerObj()
    {
        return obj;
    }
    @FXML
    private TextArea insertArea;
    @FXML
    Button button;
    @FXML
    BorderPane pane;
    @FXML
    Label label;
    @FXML
    public void NormalLoader(TextArea insertArea) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("normal.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), 960.0D, 480.0D);
        Normal controller = fxmlLoader.getController();
        controller.SetTextField(insertArea.getText());
        insertArea.setWrapText(true);
        Stage stage = new Stage();
        stage.setTitle("[No Name] - VIM");
        Image image = new Image("C:\\Users\\ST\\IdeaProjects\\Project\\src\\main\\java\\images\\heheboi.jpg");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void input(KeyEvent event)
    {

    }
    public void close(BorderPane pane1)
    {
        Stage stage = (Stage) pane1.getScene().getWindow();
        stage.close();
    }
}
