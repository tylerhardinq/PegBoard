package peggame;


import java.util.Collection;

public interface PegGame {
    Collection<Move> getPossibleMoves();//unimplemented getPossibleMoves method 
    GameState getGameState();//unimplemented getGameState method 


    default void makeMove(Move move) throws PegGameException {
        throw new PegGameException("the method has not been implemented"); //default method of makeMove
    }

    default PegGame deepCopy() {
        throw new UnsupportedOperationException("not implemented");
    }
    
}
