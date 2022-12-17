package BL;

import javafx.scene.control.TextArea;

public interface DataBase {
    public void loadfile(TextArea textArea, String command); //loads file from database
    public void savetodb(TextArea textArea,String command); //saves data to database
}
