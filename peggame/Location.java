package peggame;

public class Location{
    private final int row;
    private final int col;

    public Location(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof Location)) {
          return false;
        }
    
        Location other = (Location)o;
    
        return(row == other.row && col == other.col);
      
    }
}