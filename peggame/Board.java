package peggame;

import java.util.Arrays;

public class Board {

    private final int rows;
    private final int cols;

    private final String[][] board;

    private int moves;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new String[rows][cols];
        moves = 0;
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

    public boolean makeMove(int row, int col) {
        if(row < 0 || row >= rows
            || col < 0 || col >= cols
            || board[row][col] != "-") {
            return false;
        } else {
            moves++;
            board[row][col] = "o";
            return true;
        }
    }

    public int getMoves() {
        return moves;
    }

    public boolean isFull() {
        return moves == (rows * cols);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                builder.append("[");
                if(board[row][col] == null){
                    builder.append("o");
                }
               
                builder.append("]");
            }
            builder.append("\n");
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        Board board = new Board(8, 8);
        board.makeMove(5, 7);
        System.out.println(board);
    }
    
}
