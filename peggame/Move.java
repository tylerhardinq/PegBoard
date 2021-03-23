package peggame;

public class Move {
    private Location from;
    private Location to;
    
    public Move(Location from, Location to) {
        this.from = from;
        this.to = to;
    }
    
    public Location getFrom() {
        return from;
    }
    
    public Location getTo() {
        return to;
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof Move)) {
        return false;
        }
    
        Move other = (Move)o;
    
        return(from == other.from && to == other.to);
    
    }

    @Override
    public String toString() {
        return "Move{ from:" + from.toString() + ", to:"+ to.toString() + "}";
    }
}
