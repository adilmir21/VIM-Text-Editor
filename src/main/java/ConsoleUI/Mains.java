package ConsoleUI;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.robot.Robot;
import ui.project.Main;
import BL.Normal;
import java.io.Console;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Mains {
    public static int count = 0;
    public static String words = null;
    public static String mode = "Normal";
    public static String text;
    Scanner scanner = new Scanner(System.in);

    public int getcount() {
        return count;
    }

    public static String inputs() {
        System.out.println("-----------INSERT MODE-------------");
        count = 1;
        if(words != null)
        {
            System.out.println(words);
        }
        Scanner scanner = new Scanner(System.in);
        text = scanner.nextLine();
        while (text.charAt(text.length()-1)!='-')
        {
            if(words == null)
            {
                words = text;
            }
            else
            {
                words = words + text;
            }
            String temp = String.valueOf(text.charAt((text.length()) - 1));
            if (temp.equals("-"))
            {
                return temp;

            }
            if (scanner.hasNextLine())
            {
                words = words+"\n";
                text = scanner.nextLine();
            }
        }
        return words;
    }
    public static void clrscr(){
        //Clears Screen in java
        for(int clear = 0; clear < 10; clear++)
        {
            System.out.println("\b") ;
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
   public static void positionCursor(int row, int column) {
        char escCode = 0x1B;
        System.out.print(String.format("%c[%d;%df",escCode,row,column));
    }
    public static void main(String[] args) throws IOException {
        count = 1;
        String copy = "heheboi";
        inputs();
        text = words.substring(0,words.length()-1);
        words = text;

        Normal normal = new Normal();
        //System.out.println(words);
        clrscr();
        System.out.println("------------Normal Mode-------------");
        System.out.println(words);
        Scanner scanner = new Scanner(System.in);
        text = scanner.nextLine();
        String name = null;
        while(true)
        {
            if (!text.equals(":q") && !text.equals(":w") && !text.contains(":sav ") && !text.contains(":e "))
            {
                if (text.equals("l") || text.equals("h") || text.equals("j") || text.equals("k"))
                {
                    //normal.cursor();
                }
                if(text.equals("yy") || text.equals("dd") || text.equals("p"))
                {
                    if(text.equals("yy"))
                    {
                        copy = normal.copypaste(text,words,copy);
                    }
                    else
                    {
                        words = normal.copypaste(text, words, copy);
                    }
                    System.out.println(words);
                    //System.out.println("------------Normal Mode-------------");
                }
                else
                {
                    inputs();
                    //System.out.println("------------Normal Mode-------------");
                    System.out.println(words);
                }
            }
            else
            {
                name = scanner.nextLine();
                words = words+text;
                System.out.println(words);
                String s = normal.checks(words,name);
                words = s;
                if(words.contains("null"))
                {
                    words = words.substring(4);
                }

                if(words == null)
                {
                    return;
                }
                System.out.println("------------Normal Mode-------------");
            }
            if (scanner.hasNextLine()) {
                text = text+"\n";
                words = words+"\n";
                text = scanner.nextLine();
            }
        }

    }
}
