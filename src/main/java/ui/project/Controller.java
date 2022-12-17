package ui.project;

import BL.Edit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.input.KeyCombination.keyCombination;

public class Controller implements NormalMode { // Whole class implemented in BL
    private static Controller obj = new Controller(); // design pattern "singleton". Can only make 1 object
    private Controller(){}
    public static Controller ControllerObj()
    {
        return obj;
    }
    @FXML
    public TextArea textArea;
    @FXML
    public TextField normalTextField;
    @FXML
    public BorderPane pane;
    public String command;
    @FXML
    public Label label;
    public KeyCode prev = KeyCode.C;
    @FXML
    public void InsertLoader(TextArea textArea) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Insert.class.getResource("insert1.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load(), 960.0D, 480.0D);
        Edit controller = fxmlLoader.getController();

        controller.SetTextField(textArea.getText());
        Stage stage = new Stage();
        stage.setTitle("[No Name] - VIM");
        Image image = new Image("C:\\Users\\ST\\IdeaProjects\\Project\\src\\main\\java\\images\\heheboi.jpg");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void move(KeyEvent event){}
    @FXML
    public void SetTextField(String name){}

    @FXML
    public void textfieldinputs(){}
    public void setLabel(Label linenum, String z, String t,int pos )
    {
        linenum.setText(" Pos : " + z + " Char : " + t.charAt(pos));
        linenum.setVisible(true);
    }
    public void close(BorderPane pane1)
    {
        Stage stage = (Stage) pane1.getScene().getWindow();
        stage.close();
    }
    public void setTitle(BorderPane pane1,String command1)
    {
        Stage stage = (Stage) pane1.getScene().getWindow();
        stage.setTitle(command1);
    }

}
