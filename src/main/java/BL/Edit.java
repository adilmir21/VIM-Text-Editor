package BL;
import java.io.Console;
import java.io.IOException;

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
import ui.project.Controller;
import ui.project.InsertController;

import java.io.IOException;
import java.io.PrintStream;

public class Edit implements UI {
    InsertController insertController = InsertController.InsertControllerObj();
        @FXML
        private TextArea insertArea;
        @FXML
        Button button;
        @FXML
        BorderPane pane;
        @FXML
        Label label;
        @FXML
        Label linenum;
        @FXML
        public void NormalLoader(TextArea insertArea) throws IOException { // loads normal mode page

            insertController.NormalLoader(insertArea);
        }
        @FXML
        public void input(KeyEvent event) throws IOException { // checks if char is escape then exits insert mode
            if(event.getCode() == KeyCode.ESCAPE) {

                insertController.close(pane);
                NormalLoader(insertArea);
            }
        }
        public void SetTextField(String name)
        {
            insertArea.setText(name);
        }
    }
