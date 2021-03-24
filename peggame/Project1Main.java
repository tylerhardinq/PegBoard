package peggame;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project1Main{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Give me a file ");
        String fileName = sc.nextLine();
        Board aBoard = BoardFromFile.readFromFile(fileName);
        Game aGame = new Game(aBoard);
        CommandLines.CLI(aGame);
        sc.close();
    }
}