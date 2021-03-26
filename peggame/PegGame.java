package peggame;


import java.util.Collection;

public interface PegGame {
    Collection<Move> getPossibleMoves();//unimplemented method 1
    GameState getGameState();//unimplemented method 2


    default void makeMove(Move move) throws PegGameException {
        throw new PegGameException("the method has not been implemented"); //default method of makeMove
    }
    
}
