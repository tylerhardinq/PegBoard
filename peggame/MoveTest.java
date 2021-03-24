package peggame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class MoveTest {
    

    @Test
    public void testMove() {
        Move m1 = new Move(new Location(2, 2), new Location(2, 4));
        Move m2 = new Move(new Location(0, 0), new Location(2, 2));
        Move m3 = new Move(new Location(0, 0), new Location(2, 2));

        assertEquals(new Location(2, 2), m1.getFrom());
        assertEquals(new Location(2, 4), m1.getTo());
        assertEquals(m2, m3);


        
    }
}
