package DB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DBFile {
    public void save(String fname, String command) throws IOException {
        System.out.println("saved Successfully");
        FileWriter myWriter = new FileWriter("C:\\Users\\ST\\Desktop\\" + fname);
        myWriter.write(command);
        myWriter.close();
    }
    public String load(String fname) throws FileNotFoundException {
        String output = null;
        File file = new File("C:\\Users\\ST\\Desktop\\"+fname);
        Scanner myReader = new Scanner(file);
        String data;
        while (myReader.hasNextLine()) {
             data = myReader.nextLine();
             output = output +  data+ "\n";
        }
        myReader.close();
        return output;
    }
}
