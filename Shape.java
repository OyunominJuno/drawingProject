import java.lang.Math;
import java.io.Serializable;

/**
 * Shape class
 *
 * @author  Oyunomin Munkhkhurel
 * @version 1/22/2018
 */
public class Shape implements Serializable {
    /* name of the shape*/
    private String name;
    /* ArrayList that holds point objects creates shape */
    private ArrayList<Point> points;
    
    /**
     * Constructor for objects of class Shape
     * 
     * @param String name of the shape
     * @throws IllegalArgumentException if name is null
     */
    public Shape(String name) {
        if ( name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        
        this.name = name;
        this.points = new ArrayList<Point>();
    }
    
    //---------------------------------------------------------------------------------------------------
    // ACCESSORS
    //---------------------------------------------------------------------------------------------------
    /*
     * Retrives the ArrayList of points
     * 
     * @return ArrayList of points
     */
    public ArrayList<Point> getPoints() {
        return points;
    }
     
    /*
     * Creates an array that contains every x coordinate of the points
     * 
     * @return Integer Array of x of points
     */
    public int[] getXOfPoints() {
        int[] xOfPoints = new int[points.size()];
        for (int idx = 0; idx < points.size(); idx++) {
            xOfPoints[idx] = (int)Math.round(points.get(idx).getX());
        }
        return xOfPoints;
    }
    
    /*
     * Creates an array that contains every y coordinate of the points
     * 
     * @return Integer Array of y of points
     */
    public int[] getYOfPoints() {
        int[] yOfPoints = new int[points.size()];
        for (int idx = 0; idx < points.size(); idx++) {
            yOfPoints[idx] = (int)Math.round(points.get(idx).getY());
        }
        return yOfPoints;
    }
    
    /*
     * Retrieves the name of the shape
     * 
     * @return name of the shape
     */
    public String getName() {
        return name;
    }
    
    /*
     * Retrieves the verbal states of the shape including name and the points
     * 
     * @return information of the shape
     */
    public String toString() {
        String info = "";
        info += " Shape name:     " + name + "\n";
        info += " Points:   \n" + points.toString() + "\n";
        return info;
    }
    
    //---------------------------------------------------------------------------------------------------
    // MUTATORS
    //---------------------------------------------------------------------------------------------------
    /*
     * Adds point to the array and changes the shape
     * 
     * @param Point desired point that is being added
     */
    public void addPoint(Point point) {
        points.add(point);
    }
}
