package peggame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BoardFromFile {
    public Board readFromFile(String filename) throws FileNotFoundException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        try {
            String[] rowCol = br.readLine().split(" ");
            int row;
            int col;
            //If row and col is different
            if(rowCol.length > 1) {
                row = Integer.parseInt(rowCol[0]);
                col = Integer.parseInt(rowCol[1]);
            }
            //If row and col is same
            else{
                row = Integer.parseInt(rowCol[0]);
                col = Integer.parseInt(rowCol[0]);
            }
            //Create new board
            Board filledBoard = new Board(row , col);
            String line = "";
            while(line != null) {
                for(int r = 0; r < row; r++) {
                    line = br.readLine();
                    String[] tokens =line.split("");
                    for(int c = 0; c < col; c++) {
                        //add each element
                        if(tokens[c].equals("o")) {
                            filledBoard.addPeg();
                        }
                        filledBoard.board[r][c] = tokens[c] ;
                    }
                }
                br.close();
                return filledBoard;
            }

        }

        catch (IOException ioe) {
            System.out.println(ioe);
        }
        return null;

    }
}
