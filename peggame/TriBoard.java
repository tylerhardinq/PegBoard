package peggame;

import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * This class represents the board that is the underlying implementation for the game.
 */
public class TriBoard {

    private final int rows;
    // removed cols, we only work with rows in triangles. 
    // removed size, because rows and cols will be the same thing
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
        this.board = new String[rows][];
        for(int i = 0; i < rows; i++) {
            board[i] = new String[i+1];
        }
        moves = 0;
        this.totalPeg = 0;
        this.state = GameState.NOT_STARTED;
    }

    /**
     * Copy constructor. Will be useful for part 3 backtracking.
     * @param template Takes in an existing board. 
     */
    public TriBoard(TriBoard template) {
        this.rows = template.rows;
        this.board = new String[rows][];
        for(int row=0; row<rows; row++) {
            this.board[row] = Arrays.copyOf(template.board[row], template.board[row].length);
        }
        
        this.moves = template.moves;
        this.totalPeg = template.totalPeg;
        this.state = template.state;
    }
   public String[][] getBoard() {
       return board;
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

    public int getRows() {
        return rows;
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
        for (int i = 0; i < rows; i++) {
            for (int space = 0; space < rows - i; space++) {
                builder.append(" ");
            }
            for (int j = 0; j < i+1; j++) {
                if(board[i][j].equals("o")){
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




    public static void main(String[] args) throws FileNotFoundException {
        // Board board = new Board(4, 4);
        // board.makeMove(5, 7);
        // TriBoard template = TriBoardReader.readFromFile("data2/5.txt");
        // String[][] b = new TriBoard(template).getBoard();
        // for (String[] row : b) {System.out.println(Arrays.toString(row));}
        
        // System.out.println(template);

        // System.out.println(copy);
        


    }
    
}
