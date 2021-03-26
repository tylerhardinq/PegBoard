package peggame;
/**
 * Location class represents the col and row of one a single peg
 */
public class Location{
    private final int row;
    private final int col;
    //constructor
    public Location(int row, int col){
        this.row = row;
        this.col = col;
    }
    //getters
    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
    //equal method
    public boolean equals(Object o) {
        if (!(o instanceof Location)) {
          return false;
        }
    
        Location other = (Location)o;
    
        return(row == other.row && col == other.col);
      
    }
    /**
     * toString to make it more neat
     */
    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}