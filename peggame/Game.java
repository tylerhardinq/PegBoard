package peggame;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * This class contains methods to play the PegGame and 
 * checking the state of the board.
 * We seperated what we were told to do in CLI(Part6) into this class
 */
public class Game implements PegGame {
    private Board board;

    /**
     * @param board Board that is going to be played on.
     */
    public Game(Board board){
        this.board = board;
    }

    @Override
    public Game deepCopy() {
        Game newGame = new Game(new Board(board));
        // System.out.println(newGame);
        return newGame;
    }
    
    /**
     * moves a peg on the board from and to a specified location.
     * peg is removed from the from location and moved to the to location.
     * 
     * @param move Contains Location from and to
     */

    @Override
    public void makeMove(Move move) throws PegGameException {
        if(getPossibleMoves().contains(move)){  //If the move is a valid move
            board.board[move.getTo().getRow()][move.getTo().getCol()] = "o";     //The To gets a peg
            board.board[move.getFrom().getRow()][move.getFrom().getCol()] = ".";  //The peg in the from is removed

            //Finding location in the middle
            int x1 = move.getFrom().getRow();
            int x2 = move.getTo().getRow();
            int y1 = move.getFrom().getCol();
            int y2 = move.getTo().getCol();
            int x = (x1+x2)/2;
            int y = (y1+y2)/2;
            board.board[x][y] = ".";
            board.addMove();  //Increments the number of move made
            board.removePeg();  //removes one peg from the totalPegs on the board

            //Changes the state of the board based on the total number of pegs and moves
            if(getPossibleMoves().size() == 0 && board.getTotalPeg() == 1) {
                board.setState(GameState.WON);
            } else if(board.getTotalPeg() >= 2 && getPossibleMoves().size() == 0) {
                board.setState(GameState.STALEMATE);
            } else {
                board.setState(GameState.IN_PROGRESS);
            }
            
        }
        else{
            //Invalid move is made
            throw new PegGameException("invalid move :(");
        }
    }
    /**
     * @return returns the current board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Checks where the empty hole is on the board and makes
     * a collection of possible moves that could be made horizontally,
     * vertically and diagnally.
     */
    @Override
    public Collection<Move> getPossibleMoves() {
        
        Collection<Move> possibleMoves = new LinkedList<>();  //new empty collection
        List<Location> To = new LinkedList<>();  //list of empty holes which will be the to location
        //inner is the possible location between the from and to
        //outer is the possible from location
        int[] innerRow = {0, 1, 1,  1,  0, -1, -1, -1};
        int[] innerCol = {1, 1, 0, -1, -1, -1,  0,  1};
        int[] outerRow = {0, 2, 2, 2,   0, -2, -2, -2};
        int[] outerCol = {2, 2, 0, -2, -2, -2,  0,  2};
        

        //adding the location of empty holes
        // System.out.println(board.getRows() + " " + board.getCols());
        // System.out.println(board);
        if(board.getTotalPeg() != 1){
            for(int r = 0; r < board.getRows(); r++) {
                for(int c = 0; c < board.getCols(); c++) {
                   if(board.board[r][c].equals(".")){
                        To.add(new Location(r, c));
                   }
                }
            }
        }

        //checking each empty location 
        for(Location i : To){
            for(int j = 0; j < innerCol.length; j++) {
                
                //possible location of the from and location betweeen from and to 
                int nextOuterR = i.getRow() + outerRow[j];
                int nextOuterC = i.getCol() + outerCol[j];
                int nextInnerR = i.getRow() + innerRow[j];
                int nextInnerC = i.getCol() + innerCol[j];

                Location nextOuterLocation = new Location(nextOuterR, nextOuterC);
                Location nextInnerLocation = new Location(nextInnerR, nextInnerC);
                
                //Checks if the locations are valid and adds it to the possible moves
                if(locationIsValid(nextOuterLocation) && hasPeg(nextOuterLocation)) {  
                    if(locationIsValid(nextInnerLocation) && hasPeg(nextInnerLocation)) {
                        Move move = new Move(nextOuterLocation, i);
                        possibleMoves.add(move);
                    }
                }
            }
        }
        
        return possibleMoves;
    }


    /**
     * checks if location contains a peg and if not returns false
     * 
     * @param location location that is going to be checked
     * @return
     */
    private boolean hasPeg(Location location) {
        if(board.board[location.getRow()][location.getCol()].equals("o")) {
            return true;
        }
        return false;
    }

    /**
     * checks if a location is inside the board
     * 
     * @param loc location that is going ot be checked
     * @return
     */
    private boolean locationIsValid(Location loc) {
        if(loc.getRow() < 0 || loc.getRow() >= board.getRows()) {
            return false;
        }
        if(loc.getCol() < 0 || loc.getCol() >= board.getCols()) {
            return false;
        }


        return true;
    }

    /**
     * returns the current gamestate of the board
     */
    @Override
    public GameState getGameState() {
        return board.getState();
    }

    @Override
    public String toString() {
        return board.toString();
    }
    
}