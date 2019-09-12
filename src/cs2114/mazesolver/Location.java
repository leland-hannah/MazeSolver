package cs2114.mazesolver;
/**
 * 
 * @author hannahleland
 * @version 2018.11.2
 */
public class Location implements ILocation {

    private int x;
    private int y;
    /**
     * @param x the points x value 
     * @param y the ponts y value 
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        
    }
    
    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }

    @Override
    public ILocation north() {
        ILocation l = new Location(x, y - 1);
        return l;
    }

    @Override
    public ILocation south() {
        ILocation l = new Location(x, y + 1);
        return l;
    }

    @Override
    public ILocation west() {
        ILocation l = new Location(x - 1, y);
        return l;
    }

    @Override
    public ILocation east() {
        ILocation l = new Location(x + 1, y);
        return l;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o != null) {
            return this.toString().equals(o.toString());
        }
        return false;
   
    }
    
    @Override
    public String toString() {
        return ("\"(" + x + ", " + y + ")\"");
    }

}
