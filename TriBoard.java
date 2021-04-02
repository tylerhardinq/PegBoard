package peggame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * This class represents the board that is the underlying implementation for the game.
 */
public class TriBoard {

    private final int rows;
    private final int cols;
    private final int size;
    protected String[][] board;
    private int moves;   //total moves
    private int totalPeg; //total number of pigs on the board
    private GameState state; //The current state of the game

    /**
     * Constructor for the board
     * @param rows Amount of rows.
     * @param cols Amount of cols
     */
    public TriBoard(int size) {
        this.rows = size;
        this.cols = size;
        this.size = size;
        this.board = new String[rows][cols];
        moves = 0;
        this.totalPeg = 0;
        this.state = GameState.NOT_STARTED;
    }

    /**
     * Copy constructor. Will be useful for part 3 backtracking.
     * @param template Takes in an existing board. 
     */
    public TriBoard(TriBoard template) {
        this.size = template.size;
        this.rows = template.size;
        this.cols = template.size;
        this.board = new String[rows][];
        for(int row=0; row<rows; row++) {
            this.board[row] = Arrays.copyOf(template.board[row], cols);
        }
        
        this.moves = template.moves;
        this.totalPeg = template.totalPeg;
        this.state = template.state;
    }
   
    /**
     * 
     * @return State of game from GameState enum
     */
    public GameState getState() {
        return state;
    }

    /**
     * Adds a peg. Used when making the board from a file.
     */
    public void addPeg() {
        this.totalPeg += 1;
    }

    /**
     * Removes a peg, called when making a move. 
     */
    public void removePeg() {
        totalPeg--;
    }

    /**
     * 
     * @return Total pegs
     */
    public int getTotalPeg() {
        return totalPeg;
    }

    // public int getCols() {
    //     return cols;
    // }
    // public int getRows() {
    //     return rows;
    // }

    public int getMoves() {
        return moves;
    }

    public void addMove() {
        moves++;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    /**
     * This was mostly used from the chessboard implementation from knight moves.
     * Important to note that the array actually stores a '.' for the empty spots and is representated as '-'
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int space = 0; space < size - i; space++) {
                builder.append(" ");
            }
            for (int j = 0; j < i+1; j++) {
                if(board[i][j].equals("o ")){
                    builder.append("o ");
                }
                else{
                    builder.append("- ");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
    

    public static String Triangle(int N) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int space = 0; space < N - i; space++) {
                result.append(" ");
            }
            for (int j = 0; j < i+1; j++) {
                result.append("o ");
            }
            result.append("\n");
        }
        return result.toString();
    }



    /**
     * Reads the provided data and creates a board. 
     * @param filename 
     * @return 
     * @throws FileNotFoundException
     */
    public static Board readFromFile(String filename) throws FileNotFoundException {
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


    public static void main(String[] args) throws FileNotFoundException {
        // Board board = new Board(4, 4);
        // board.makeMove(5, 7);
        // System.out.println(board);
        System.out.println(readFromFile("data/3_3.txt"));
        System.out.println(readFromFile("data/4_5.txt"));

    }
    
}
