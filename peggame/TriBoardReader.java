package peggame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TriBoardReader {
    /**
     * Reads a file from /data/ and makes a board witWh pegs and holes.
     * Honestly, this is just in it's own class because the instructions specifically wanted it. 
     * I don't see why this isn't in the board class.
     * @param filename file from /data/
     * @return Filled board.
     * @throws FileNotFoundException
     */

    public static TriGame readFromFile(String filename) throws FileNotFoundException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        try {
            int size;
            size = Integer.parseInt(br.readLine());        
            //Create new board
            TriBoard filledBoard = new TriBoard(size);
            String line = "";
            int rowCounter = 0;
            while(line != null) {
                    line = br.readLine();
                    if(line == null) {
                        break;
                    }
                    String[] tokens =line.split("");
                    for (int i = 0; i < tokens.length; i++) {
                        if(tokens[i].equals(".")){
                            filledBoard.board[rowCounter][i] = ("-");
                        }
                        else{
                            filledBoard.board[rowCounter][i] = ("o");
                        }
                    }
                    rowCounter++;
                }
                br.close();
                TriGame triGame = new TriGame(filledBoard);
                return triGame;
            }

        catch (IOException ioe) {
            System.out.println(ioe);
        }
        return null;

    }

    public static void main(String[] args) throws FileNotFoundException {
        TriGame b = TriBoardReader.readFromFile("data2/5.txt");
        System.out.println(b);

    }
}
