package peggame;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project3Main{
    public static void main(String[] args) throws FileNotFoundException, PegGameException {
        Scanner sc = new Scanner(System.in); //the scanner initiator
        System.out.print("Give me a file: "); // the question
        String fileName = sc.nextLine();

        TriBoard aGame =  TriBoardReader.readFromFile(fileName);;//create a new board from the given file
        CommandLines.CLI(aGame);//using the command line to play the game
        sc.close();
    }
}