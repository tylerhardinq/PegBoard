package peggame;
/**
 * Move class that takes two locations
 */
public class Move {
    private Location from;
    private Location to;
    //constructor
    public Move(Location from, Location to) {
        this.from = from;
        this.to = to;
    }
    //getters
    public Location getFrom() {
        return from;
    }
    
    public Location getTo() {
        return to;
    }
    //equal method, comparing the two objects
    public boolean equals(Object o) {
        if (!(o instanceof Move)) {
            return false;
        }
    
        Move other = (Move)o;
    
        return(from.equals(other.from) && to.equals(other.to));
    }
    
    //toString method
    @Override
    public String toString() {
        return "Move from " + from.toString() + " to "+ to.toString();
    }
}
