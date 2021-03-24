package peggame;

import java.io.FileNotFoundException;
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
        
        Collection<Move> possibleMoves = new LinkedList<>();
        List<Location> To = new LinkedList<>();
        int[] innerRow = {0, 1, 1,  1,  0, -1, -1, -1};
        int[] innerCol = {1, 1, 0, -1, -1, -1,  0,  1};
        int[] outerRow = {0, 2, 2, 2,   0, -2, -2, -2};
        int[] outerCol = {2, 2, 0, -2, -2, -2,  0,  2};
        
        if(board.getTotalPeg() != 1){
            for(int r = 0; r < board.getRows(); r++) {
                for(int c = 0; c < board.getCols(); c++) {
                   if(board.board[r][c].equals(".")){
                        To.add(new Location(r, c));
                   }
                }
            }
        }
        for(Location i : To){
            for(int j = 0; j < innerCol.length; j++) {
                
                int nextOuterR = i.getRow() + outerRow[j];
                int nextOuterC = i.getCol() + outerCol[j];
                int nextInnerR = i.getRow() + innerRow[j];
                int nextInnerC = i.getCol() + innerCol[j];

                Location nextOuterLocation = new Location(nextOuterR, nextOuterC);
                Location nextInnerLocation = new Location(nextInnerR, nextInnerC);
                
                
                if(isValid(nextOuterLocation) && hasPeg(nextOuterLocation)) {
                    if(isValid(nextInnerLocation) && hasPeg(nextInnerLocation)) {
                        Move move = new Move(nextOuterLocation, i);
                        possibleMoves.add(move);
                    }
                }
            }
        }
        return possibleMoves;
    }



    public boolean hasPeg(Location location) {
        if(board.board[location.getRow()][location.getCol()].equals("o")) {
            return true;
        }
        return false;
    }

    public boolean isValid(Location loc) {
        if(loc.getRow() < 0 || loc.getRow() >= board.getRows()) {
            return false;
        }
        if(loc.getCol() < 0 || loc.getCol() >= board.getCols()) {
            return false;
        }
        return true;
    }

    @Override
    public GameState getGameState() {
        return board.getState();
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        new BoardFromFile();
        Game game = new Game(BoardFromFile.readFromFile("data/4_4.txt"));
        System.out.println(game.board);
        System.out.println(game.getPossibleMoves());
    }
}
