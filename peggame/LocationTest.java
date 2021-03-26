package peggame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;
/**
 * testing if locations equal to each other
 */
@Testable
public class LocationTest {
    
    @Test
    public void testLocation() {
        Location l1 = new Location(0, 0);
        Location l2 = new Location(2, 2);
        Location l3 = new Location(2, 2);

        assertEquals(0, l1.getRow());
        assertEquals(0, l1.getCol());
        assertEquals(2, l2.getRow());
        assertEquals(2, l2.getCol());
        assertEquals(l2, l3);


    }
}
