package peggame;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import backtracker.Backtracker;
import backtracker.Configuration;

/**
 * This class contains methods to play the PegGame and 
 * checking the state of the board.
 * We seperated what we were told to do in CLI(Part6) into this class
 */
public class GameSolver implements Configuration{
    private Game game;
    private List<Move> moves = new ArrayList<>();

  
    public GameSolver(Game game, List<Move> moves){
        this.game = game;
        this.moves = moves;
    }

    public GameSolver(Game game) {
        this.game = game;
        this.moves = new ArrayList<>();
    }

    @Override
    public boolean isValid() {
        return (game.getGameState() != GameState.STALEMATE);
    }

    @Override
    public boolean isGoal() {
        return (game.getGameState() == GameState.WON);
    }

    @Override
    public Collection<Configuration> getSuccessors() {
        Collection<Configuration> successors = new ArrayList<>();
        for(Move move : game.getPossibleMoves()) {
            try {
                Game gameCopy = game.deepCopy();
                System.out.println(gameCopy);
                List<Move> movesCopy = new ArrayList<>(moves);
                movesCopy.add(move);
                gameCopy.makeMove(move);
                successors.add(new GameSolver(gameCopy, movesCopy));
            } catch (PegGameException e) {
                System.out.println(e);
            }
        }
        return successors;
    }



    public static GameSolver solve(Game game) {
        GameSolver solver = new GameSolver(game);
        Backtracker backtracker = new Backtracker(false);
        Configuration solution = backtracker.solve(solver);
        return (GameSolver)solution;
    }

    public List<Move> getMoves() {
        return moves;
    }

    @Override
    public String toString() {
        return moves.toString();
    }
    
    public static void main(String[] args) throws FileNotFoundException, PegGameException {       
        Game pGame= new Game(BoardFromFile.readFromFile("data/1_4.txt"));
        GameSolver gamesolver = solve(pGame);
        for(Move move : gamesolver.getMoves()) {
            System.out.println(move);
        }

    }
}
