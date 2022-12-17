package BL;
import ConsoleUI.Mains;
import java.util.Scanner;

import DB.DBFile;
import DB.DataBase;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Light;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;

import javafx.scene.robot.Robot;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ui.project.Controller;
import ui.project.Insert;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Normal implements NormalCommandMode {
    Controller control = Controller.ControllerObj();
    @FXML
    public TextArea textArea;
    @FXML
    public TextField normalTextField;
    @FXML
    public BorderPane pane;
    @FXML
    public Label label;
    @FXML
    public Label linenum;
    public String command;
    public KeyCode prev = KeyCode.C;
    @FXML
    Label l1;

    @FXML
    public void InsertLoader(TextArea textArea) throws IOException {
        control.InsertLoader(textArea);
    }
    @FXML
    public void move(KeyEvent event) throws IOException {


        textArea.setEditable(false);
        if (event.getCode() == KeyCode.H) // moves cursor to one position left
        {
            textArea.setEditable(false);
            String t = textArea.getText(); // gets text from textarea
            int pos = textArea.getCaretPosition();
            String y = String.valueOf(t.charAt(pos));
            String z = String.valueOf(pos);
            if (textArea.getCaretPosition() == 0) {

            } else {
                textArea.positionCaret(textArea.getCaretPosition() - 1); // moves 1 pos to left
            }

            control.setLabel(linenum,z,t,pos);
        }
        if (event.getCode() == KeyCode.L) // moves cursor to one position right
        {
            textArea.setEditable(false);

            String t = textArea.getText();
            int pos = textArea.getCaretPosition();
            String y = String.valueOf(t.charAt(pos));
            String z = String.valueOf(pos);
            if (textArea.getCaretPosition() >= t.length() - 1) {

            } else {
                textArea.positionCaret(textArea.getCaretPosition() + 1);
            }
            control.setLabel(linenum,z,t,pos);
        }
        if (event.getCode() == KeyCode.J) // moves cursor to one line down
        {
            textArea.setEditable(false);
            String t = textArea.getText();

            int caretPosition = textArea.getCaretPosition();
            String text = textArea.getText();
            int lineBreak2 = text.indexOf('\n', caretPosition);
            if (lineBreak2 < 0) {
                // if no more line breaks are found, select to end of text
                lineBreak2 = text.length();
            }

            int cur = 0;
            textArea.positionCaret(lineBreak2);
            String temp = t.substring(lineBreak2 + 1);

            while (cur <= temp.length() && cur <= caretPosition) {
                cur++;
            }
            //cur--;
            if (cur <= temp.length() && cur <= caretPosition) {
                textArea.positionCaret(textArea.getCaretPosition() + cur);
            }


            int pos = textArea.getCaretPosition();
            String y = String.valueOf(t.charAt(pos));
            String z = String.valueOf(pos);
            control.setLabel(linenum,z,t,pos);
        } else if (event.getCode() == KeyCode.K) // moves cursor to one line up
        {
            textArea.setEditable(false);
            String t = textArea.getText();
            int caretPosition = textArea.getCaretPosition();
            String text = textArea.getText();
            int lineBreak1 = text.lastIndexOf('\n', caretPosition - 1);
            int lineBreak2 = text.indexOf('\n', caretPosition);
            if (lineBreak2 < 0) {
                // if no more line breaks are found, select to end of text
                lineBreak2 = text.length();
            }

            String temp = t.substring(lineBreak1, caretPosition);
            int len = temp.length();
            len++;


            int l1 = abs(len - caretPosition);

            if (t.charAt(l1) >= ' ' && t.charAt(l1) <= '~') {
                textArea.positionCaret(l1);
            } else {
                while (t.charAt(l1) < ' ' && t.charAt(l1) > '~') {
                    l1++;
                }
                textArea.positionCaret(l1);
            }
            int pos = textArea.getCaretPosition();
            String y = String.valueOf(t.charAt(pos));
            String z = String.valueOf(pos);
            control.setLabel(linenum,z,t,pos);

            //System.out.println(textArea.getCaretPosition());
        } else if (event.getCode() == KeyCode.SEMICOLON) { // moves cursor to textfield
            if (prev == KeyCode.SHIFT) {

                textArea.setEditable(false);
                normalTextField.requestFocus();
                // normalTextField.insertText(0,":");
            }
        } else if (event.getCode() == KeyCode.I) // moves to insert mode
        {
            textArea.setEditable(false);
            control.close(pane);
            InsertLoader(textArea);
        } else if (event.getCode() == KeyCode.Y) { // copies the current line
            if (prev == KeyCode.Y) {
                textArea.setEditable(false);
                int caretPosition = textArea.getCaretPosition();
                String text = textArea.getText();
                int lineBreak1 = text.lastIndexOf('\n', caretPosition - 1);
                int lineBreak2 = text.indexOf('\n', caretPosition);
                if (lineBreak2 < 0) {
                    // if no more line breaks are found, select to end of text
                    lineBreak2 = text.length();
                }

                textArea.selectRange(lineBreak1, lineBreak2);
                String texts = textArea.getSelectedText().toString();
                final Clipboard clipboard = Clipboard.getSystemClipboard();
                final ClipboardContent content = new ClipboardContent();

                content.putString(texts);
                clipboard.setContent(content);
            }
        } else if (event.getCode() == KeyCode.P) // pastes text in buffer
        {
            textArea.setEditable(false);
            textArea.appendText("\n");
            textArea.paste();
        } else if (event.getCode() == KeyCode.D) {
            if (prev == KeyCode.D) {
                textArea.setEditable(true);
                int caretPosition = textArea.getCaretPosition();
                String text = textArea.getText();
                int lineBreak1 = text.lastIndexOf('\n', caretPosition - 1);
                int lineBreak2 = text.indexOf('\n', caretPosition);
                if (lineBreak2 < 0) {
                    // if no more line breaks are found, select to end of text
                    lineBreak2 = text.length();
                }

                textArea.selectRange(lineBreak1, lineBreak2);
            }
        } else if (event.getCode() == KeyCode.O) {
            textArea.setEditable(false);
            String newline = "\n";
            textArea.appendText(newline);
            control.close(pane);
            InsertLoader(textArea);
        } else if (event.getCode() != KeyCode.H && event.getCode() != KeyCode.J && event.getCode() != KeyCode.K && event.getCode() != KeyCode.L && event.getCode() != KeyCode.I && event.getCode() != KeyCode.P && (event.getCode() != KeyCode.COLON && event.getCode() != KeyCode.SHIFT) && event.getCode() != KeyCode.Y && event.getCode() != KeyCode.O && event.getCode() != KeyCode.D) {
            textArea.setEditable(false);
            //control.close(pane);
            //InsertLoader(textArea);
        }
        prev = event.getCode();

    }

    @FXML
    public void SetTextField(String name) {
        textArea.setText(name);
    }
    @FXML
    public void textfieldinputs() throws IOException {
        //notvisible();
        String input = normalTextField.getText();
        if (input.contains(":e ") == true) {
            label.setVisible(false);
            command = input.substring(3);
            String options[] = {"File", "DataBase"};

            ChoiceDialog<String> d = new ChoiceDialog(options[1], options);
            d.setTitle("OPTIONS");
            d.setContentText("Where to Load From");
            d.showAndWait();
            String res  = d.getResult();
            if(res.equals("DataBase"))
            {
                DB.DataBase db = new DB.DataBase();
                db.loadfile(textArea, command);
                control.setTitle(pane,command);
            }
            if(res.equals("File"))
            {
                DBFile dbFile = new DBFile();
                String name = command;
                String data = dbFile.load(command);
                if(command.contains("null"))
                {
                    String temp = command.substring(4);
                    command = temp;
                }
                if(data.contains("null"))
                {
                    String temp = data.substring(4);
                    command = temp;
                }
                control.setTitle(pane,name);
                textArea.setText(command);
            }

        }
        if (input.contains(":sav ") == true) {
            label.setVisible(false);
            command = input.substring(5);
            String options[] = {"File", "DataBase"};

            ChoiceDialog<String> d = new ChoiceDialog(options[1], options);
            d.setTitle("OPTIONS");
            d.setContentText("Where to Save");
            d.showAndWait();
            String res  = d.getResult();
            if(res.equals("DataBase"))
            {
                DataBase db = new DataBase();
                db.savetodb(textArea, command);
                control.setTitle(pane,command);
            }
            if(res.equals("File"))
            {
                FileWriter myWriter = new FileWriter("C:\\Users\\ST\\Desktop\\" + command);
                myWriter.write(textArea.getText());
                myWriter.close();
                control.setTitle(pane,command);
            }
        }
        if (input.equals(":w") == true) {
            label.setVisible(false);
            String fname;
            String x = filename();
            if (x.equals("0")) {
                fname = "new document.txt";
            } else {
                fname = "new document(" + x + ").txt";
            }
            command = textArea.getText();
            String options[] = {"File", "DataBase"};

            ChoiceDialog<String> d = new ChoiceDialog(options[1], options);
            d.setTitle("OPTIONS");
            d.setContentText("Where to Save");
            d.showAndWait();
            String res  = d.getResult();
            if(res.equals("DataBase"))
            {
                DataBase db = new DataBase();
                db.savetodb(textArea, fname);
                control.setTitle(pane,fname);
            }
            if(res.equals("File"))
            {
                FileWriter myWriter = new FileWriter("C:\\Users\\ST\\Desktop\\" + fname);
                myWriter.write(command);
                myWriter.close();
                control.setTitle(pane,fname);
            }

        }
        if (input.equals(":q") == true) {
            label.setVisible(false);
            control.close(pane);
        }
        if (input.equals(":q") == false && input.equals(":w") == false && input.contains(":sav ") == false && input.contains(":e ") == false) {
                normalTextField.clear();
                label.setText("E492: Not an editor command" + input);
                label.setVisible(true);
                textArea.requestFocus();
            }
    }
    public static String filename() {
        int name = 0;

        try {
            File file = new File("C:\\Users\\ST\\Desktop\\file.txt");
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                name = Integer.parseInt(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            int x = name;
            x = x + 1;
            FileWriter myWriter = new FileWriter("C:\\Users\\ST\\Desktop\\file.txt");
            myWriter.write(String.valueOf(x));
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return String.valueOf(name);
    }

    public void cursor() {
        Scanner sc = new Scanner(System.in);
        // Character input
        char c = 'w';
        while (!(c == ';')) {

            c = sc.next().charAt(0);

            if (c == 'l') {

            }
        }
    }

    public String checks(String input,String name) throws IOException {
        int choice;
        System.out.println("in fun");
        System.out.println(input);
        if (input.contains(":e ") == true) {
            System.out.print("Do you want to Load file from DB or File\n1. DB\n2. File\nEnter : ");
            int opt;
            Scanner scanner  = new Scanner(System.in);
            opt = scanner.nextInt();
            while(opt<1 || opt>2)
            {
                System.out.println("choose Correctly");
                System.out.print("Enter Again : ");
                opt = scanner.nextInt();
            }
            command = name;
            if(opt == 1) {
                DataBase db = new DataBase();
                String data;
                data = db.load(name);
                return data;

            }
            if(opt == 2)
            {
                DBFile data  = new DBFile();
               return data.load(command);
            }


        }
        if (input.contains(":sav ") == true) {
            System.out.print("Do you want to Save file in DB or File\n1. DB\n2. File\nEnter : ");
            int opt;
            Scanner scanner  = new Scanner(System.in);
            opt = scanner.nextInt();
            while(opt<1 || opt>2)
            {
                System.out.println("choose Correctly");
                System.out.print("Enter Again : ");
                opt = scanner.nextInt();
            }
            command = name;
            DataBase db = new DataBase();
            int indexs = input.lastIndexOf(":sav ");
            input = input.substring(0,indexs-1);
            if(opt == 1) {

                db.savetoDB(input, command);
                return input;

            }
            if(opt == 2)
            {
                System.out.println("Saving in File..");
                DBFile data  = new DBFile();
                data.save(command, input);
                return input;
            }
        }
        if (input.contains(":w") == true) {
            System.out.print("Do you want to Save file in DB or File\n1. DB\n2. File\nEnter : ");
            int opt;
            Scanner scanner  = new Scanner(System.in);
            opt = scanner.nextInt();
            while(opt<1 && opt>2)
            {
                System.out.println("choose Correctly");
                System.out.print("Enter Again : ");
                opt = scanner.nextInt();
            }

            String fname;
            String x = filename();
            if (x.equals("0")) {
                fname = "new document";
            } else {
                fname = "new document(" + x + ")";
            }
            int indexs = input.lastIndexOf(":w");
            input = input.substring(0,indexs-1);
            command = fname;
            if(opt == 1) {
                DataBase db = new DataBase();
                db.savetoDB(input, command);
                System.out.println("Saved to DataBase Successfully!");
                return input;

            }
            if(opt == 2)
            {
                System.out.println("Saving in File..");
                DBFile data  = new DBFile();
                data.save(command, input);
                return input;
            }

        }
        if (input.contains(":q") == true) {

            return null;
        }

        return null;
    }
public String copypaste(String s,String text, String copy)
{

    if (s.equals("yy"))
    {
        copy = text.substring(0,text.indexOf("\n",0));
        return copy;
    }
    if(s.equals("p"))
    {
        text = text + copy;
        return text;
    }
    if (s.equals("dd"))
    {
        int x = text.indexOf("\n");
        int y = text.lastIndexOf("\n");
        y = y-3;
        x = x+1;
        int count = 0;
        int index = text.length()-1;
        int prev = 0;
        while(count<text.length()-1)
        {
            if(text.charAt(count) == '\n')
            {
                prev++;
                index = count;
            }
            count++;
        }
        if(prev == 0)
        {
            text = " ";
        }
        else {
            String s1 = text.substring(0, index);
            text = s1;
        }
        return text;
    }
    return text;
}

}



