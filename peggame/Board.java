package peggame;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;

public class Board implements PegGame{

    private final int rows;
    private final int cols;
    protected final String[][] board;
    private int moves;   //total moves
    private int totalPeg; //total number of pigs on the board
    private GameState state; //The current state of the game

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new String[rows][cols];
        // board[0][0] = "-";
        moves = 0;
        this.totalPeg = (rows * cols)-1;
        this.state = GameState.NOT_STARTED;
    }

    public Board(Board template) {
        this.rows = template.rows;
        this.cols = template.cols;

        this.board = new String[rows][];
        for(int row=0; row<rows; row++) {
            this.board[row] = Arrays.copyOf(template.board[row], rows);
        }
        
        this.moves = template.moves;
    }

    public boolean moveValid(Move move){
        return false;
    }
    @Override
    public void makeMove(Move move) {
        //what makes it valid?

        /**
         * 
         * 
         * 
         * 
         * 
         * 
         */






        // if(move.getTo()row < 0 || row >= rows
        //     || col < 0 || col >= cols
        //     || board[row][col] != "-") {
        //     return false;
        // } else {
        //     moves++;
        //     board[row][col] = "o";
        //     totalPeg--;
        //     return true;
        // }
    }
    @Override 
    public Collection<Move> getPossibleMoves(){
        return null;
    }
    
    @Override 
    public GameState getGameState(){
        return state;

    }

    public int getTotalPeg() {
        return totalPeg;
    }

    public int getMoves() {
        return moves;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                builder.append("[");
                if(board[row][col].equals(".")){
                    builder.append("-"); 
                }
                else{
                    builder.append(board[row][col]); 
                }
               
                builder.append("]");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Board board = new Board(4, 4);
        // board.makeMove(5, 7);
        // System.out.println(board);
        

    }
    
}