package peggame;


import java.util.Collection;

public interface PegGame {
    Collection<Move> getPossibleMoves();
    GameState getGameState();


    default void makeMove(Move move) {
        throw new PegGameException();
    }
}
