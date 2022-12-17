package BL;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import ui.project.InsertMode;

import java.io.IOException;

public interface UI extends InsertMode {
    public void NormalLoader(TextArea textArea) throws IOException;
    public void input(KeyEvent event) throws IOException;
}
