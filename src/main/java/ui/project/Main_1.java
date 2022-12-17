package ui.project;

import ConsoleUI.Mains;

import java.io.IOException;
import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.print("Which Type Do You want To Run\n1. UI Based\n2. Console\nEnter : ");
        option = scanner.nextInt();
        while(option<1 || option>2)
        {
            System.out.print("Enter Again : ");
            option = scanner.nextInt();

        }
        if(option==1)
        {
            Main.main(args);
        }
        if(option == 2)
        {
            Mains.main(args);
        }

    }
}
