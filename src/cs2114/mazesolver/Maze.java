package cs2114.mazesolver;

import java.util.Stack;

/**
 * 
 * @author hannahleland
 * @version 2018.11.2
 */
public class Maze implements IMaze {

    private MazeCell[][] m;
    private Location start;
    private Location goal;
    private Stack<Location> s;
    private Stack<Location> fin;
    
    /**
     * @param size the size of the maze 
     */
    public Maze(int size) {
        s = new Stack<Location>();
        fin = new Stack<Location>();
        start = new Location(0, 0);
        goal = new Location(size - 1, size - 1);
        m = new MazeCell[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                m[i][j] = MazeCell.UNEXPLORED;
            }
        }
    }
    
    @Override
    public int size() {
        return m.length;
    }

    @Override
    public ILocation getStartLocation() {
        return start;
    }

    @Override
    public void setStartLocation(ILocation location) {
        if (m[location.x()][location.y()].equals(MazeCell.WALL)) {
            m[location.x()][location.y()] = MazeCell.UNEXPLORED;
        }
        start = (Location) location;
        
    }

    @Override
    public ILocation getGoalLocation() {
        return goal;
    }

    @Override
    public void setGoalLocation(ILocation location) {
        if (m[location.x()][location.y()].equals(MazeCell.WALL)) {
            m[location.x()][location.y()] = MazeCell.UNEXPLORED;
        }
        goal = (Location) location;
        
    }

    @Override
    public MazeCell getCell(ILocation location) {
        if (location.x() < 0 || location.x() > size() - 1 
                || location.y() < 0 || location.y() > size() - 1) {
            return MazeCell.INVALID_CELL;
        }
        
        return m[location.x()][location.y()];
    }

    @Override
    public void setCell(ILocation location, MazeCell cell) {
        if (!(cell.equals(MazeCell.WALL) && 
                (location.equals(start) || location.equals(goal)))) {
            
            m[location.x()][location.y()] = cell;
        }
        
    }

    @Override
    public String solve() {
        
        s.push(start);
        
        while (!s.isEmpty()) {
            Location curr = s.peek();
            this.setCell(start, MazeCell.CURRENT_PATH);
            
            //checks if its at goal
            if (curr.x() == goal.x() && curr.y() == goal.y()) {
                String ans = "";
                int times = s.size();
                for (int i = 0; i < times; i++) {
                    fin.push(s.pop());
                }
                
                for (int i = 0; i < times; i++) {
                    ans += fin.pop().toString() + " ";
                }
                return ans;
                
            }
            
            if (getCell((Location)curr.north()).equals(MazeCell.UNEXPLORED)) {
                s.push((Location)curr.north());
                setCell(curr.north(), MazeCell.CURRENT_PATH);
            }
            else if (getCell((Location)curr.south()
                    ).equals(MazeCell.UNEXPLORED)) {
                s.push((Location)curr.south());
                setCell(curr.south(), MazeCell.CURRENT_PATH);
            }
            else if (getCell((Location)curr.east()
                    ).equals(MazeCell.UNEXPLORED)) {
                s.push((Location)curr.east());
                setCell(curr.east(), MazeCell.CURRENT_PATH);
            }
            else if (getCell((Location)curr.west()
                    ).equals(MazeCell.UNEXPLORED)) {
                s.push((Location)curr.west());
                setCell(curr.west(), MazeCell.CURRENT_PATH);
            }
            else {
                setCell(curr, MazeCell.FAILED_PATH);
                s.pop();
            }
        }
        return null;
        
    }

}






















