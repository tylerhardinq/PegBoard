package peggame;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project1Main{
    public static void main(String[] args) throws FileNotFoundException, PegGameException {
        Scanner sc = new Scanner(System.in); //the scanner initiator
        System.out.print("Give me a file: "); // the question
        String fileName = sc.nextLine();
        Board aBoard = BoardFromFile.readFromFile(fileName);//takes the next line that user inputted
        Game aGame = new Game(aBoard);//create a new board from the given file
        CommandLines.CLI(aGame);//using the command line to play the game
        sc.close();
    }
}