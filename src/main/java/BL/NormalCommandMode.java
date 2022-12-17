package BL;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import ui.project.NormalMode;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface NormalCommandMode extends NormalMode {
    @FXML
    public void InsertLoader(TextArea textArea) throws IOException;
    @FXML
    public void move(KeyEvent event) throws IOException;
    @FXML
    public void SetTextField(String name);
    @FXML
    public void textfieldinputs() throws IOException;
}
