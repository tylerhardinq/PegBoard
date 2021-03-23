package peggame;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Game implements PegGame{
    private Board board;

    public Game(Board boar){
        this.board = boar;
    }
    
    @Override
    public void makeMove(Move move) {
        //what makes it valid?



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
    
    public Board getBoard() {
        return board;
    }

    @Override
    public Collection<Move> getPossibleMoves() {
        List<Location> To = new LinkedList<>();
        int[] rowB = {0, 0, 1, 2, 1, 2, 1, 2, 0, 0, -1, -2, -1, -2, -1, -2};
        int[] colB = {1, 2, 1, 2, 0, 0, -1, -2, -1, -2, -1, -2, 0, 0, 1, 2};
        if(board.getTotalPeg() != 1){
            for(int r = 0; r < board.getRows(); r++) {
                for(int c = 0; c < board.getCols(); c++) {
                   if(board.board[r][c].equals("-")){
                        To.add(new Location(r, c));
                   }
                }
            }
        }
        for(Location i : To){
            System.out.println(i);;
        }
    }

    @Override
    public GameState getGameState() {
        return board.getState();
    }
    
}
