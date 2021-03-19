package peggame;


import java.util.Collection;

public interface PegGame {
    Collection<Move> getPossibleMoves();
    GameState getGameState();


    default void makeMove(Move move) throws PegGameException {
        throw new PegGameException("the method has not been implemented");
    }
}
