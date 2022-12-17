package ui.project;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public interface InsertMode {
    public void NormalLoader(TextArea textArea) throws IOException;
    public void input(KeyEvent event) throws IOException;
}
