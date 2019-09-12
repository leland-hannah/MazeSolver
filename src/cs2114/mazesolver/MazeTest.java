package cs2114.mazesolver;
/**
 * 
 * @author hannahleland
 * @version 2018.11.2
 */
public class MazeTest extends student.TestCase {
    
    private Maze m;
    private Maze m2;
    
    /**
     * creates the maze
     */
    public void setUp() {
        m = new Maze(5);
        m2 = new Maze(2);
        
    }
    
    /**
     * tests enum
     */
    public void testMazeCellEnum() {
        MazeCell n = MazeCell.valueOf("UNEXPLORED");
        assertEquals(n, m.getCell(new Location(0, 0)));

    }
    
    /**
     * tests size
     */
    public void testSize() {
        assertEquals(5, m.size());
    }
    
    /**
     * tests setStartLocation
     */
    public void testSetStartLocation() {
        m.setCell(new Location(2, 3), MazeCell.WALL);
        m.setStartLocation(new Location(2, 3));
        assertEquals("\"(2, 3)\"", m.getStartLocation().toString());
        
    }
    
    /**
     * tests get startLocation
     */
    public void testStartLocation() {
        assertEquals("\"(0, 0)\"", m.getStartLocation().toString());
    }
    
    /**
     * tests setGoalLocation
     */
    public void testSetGoalLocation() {
        m.setCell(new Location(4, 4), MazeCell.WALL);
        m.setGoalLocation(new Location(4, 4));
        assertEquals("\"(4, 4)\"", m.getGoalLocation().toString());
    }
    
    /**
     * tests getCell
     */
    public void testGetCell() {
        assertEquals(MazeCell.UNEXPLORED, m.getCell(new Location(1, 2)));
    }
    
    /**
     * tests setCell
     */
    public void testSetCell() {
        m.setCell(new Location(0, 0), MazeCell.WALL);
        assertEquals(MazeCell.UNEXPLORED, m.getCell(new Location(0, 0)));
        
        m.setCell(new Location(4, 4), MazeCell.WALL);
        assertEquals(MazeCell.UNEXPLORED, m.getCell(new Location(4, 4)));
        
        m.setCell(new Location(1, 2), MazeCell.WALL);
        assertEquals(MazeCell.WALL, m.getCell(new Location(1, 2)));
    }
    
    /**
     * tests solver 
     */
    public void testSolve() {
        m2.setCell(new Location(0, 1), MazeCell.WALL);
        assertEquals("\"(0, 0)\" \"(1, 0)\" \"(1, 1)\" ", m2.solve());
        
        m2 = new Maze(2);
        m2.setCell(new Location(1, 0), MazeCell.WALL);
        assertEquals("\"(0, 0)\" \"(0, 1)\" \"(1, 1)\" ", m2.solve());
        
        
        m2.setCell(new Location(0, 1), MazeCell.WALL);
        assertNull(m2.solve());
        
        m = new Maze(3);
        m.setStartLocation(new Location(1, 1));
        m.setCell(new Location(2, 1), MazeCell.WALL);
        m.setCell(new Location(1, 1), MazeCell.WALL);
        //System.out.println(m.solve());
        assertEquals("\"(1, 1)\" \"(1, 0)\" \"(0, 0)\" \"(0, 1)\" "
                + "\"(0, 2)\" \"(1, 2)\" \"(2, 2)\" ", m.solve());
        
        Maze bm = new Maze(3);
        Location start = new Location(2, 0);
        Location wall1 = new Location(2, 1);
        bm.setStartLocation(start);
        bm.setCell(wall1, MazeCell.WALL);

        assertEquals("\"(2, 0)\" \"(1, 0)\" \"(1, 1)\" \"(1, 2)\" "
                + "\"(2, 2)\" ", bm.solve());
    }
}
















