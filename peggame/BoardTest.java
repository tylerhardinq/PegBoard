package peggame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class BoardTest {

    @Test
    public void initTest() {
        //setup

        Board board = new Board(4, 4);
        int numOfPegs = 15;
        int moves = 0;
        GameState gameState = GameState.NOT_STARTED;

        String expected = "[-][o][o][o]" + "\n" + 
                        "[o][o][o][o]" + "\n" + 
                        "[o][o][o][o]" + "\n" + 
                        "[o][o][o][o]" + "\n";

        assertEquals(numOfPegs, board.getTotalPeg());
        assertEquals(moves, board.getMoves());
        // assertEquals(gameState, board.getGameState());
        assertEquals(expected, board.toString());
    }
}
