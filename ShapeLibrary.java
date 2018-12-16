import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.ObjectStreamClass;
/**
 * ShapeLibrary
 *
 * @author  Oyunomin Munkhkhurel
 * @version 1/31/2018
 */
public class ShapeLibrary {
    // instance variables
    private ArrayList<Shape> shapes;

    /**
     * Constructor for objects of class ShapeLibrary, arrayList of shapes is created, shape objects deserialized
     * and added to the arrayList
     * 
     * @throws FileNotFoundException e if there is no such a file
     * @throws IOException e if there is lost connection etc
     * @throws ClassNotFoundException e if there is no such a class
     */
    public ShapeLibrary() {
    try {
        int x = 3;
        shapes = new ArrayList<Shape>();
        File shapeFolder = new File("shapes");
        File[] files = shapeFolder.listFiles();
        Utility.createShapeLib();
            for (int index = 0; index < files.length; index++) {
            FileInputStream shapeFile = new FileInputStream(files[index]);
            ObjectInputStream input = new ObjectInputStream(shapeFile);
            
            shapes.add((Shape)input.readObject());
            input.close();
            shapeFile.close();
        }
        
    } catch (FileNotFoundException e) {
        System.out.println("File not found");
    } catch (IOException e){
        System.out.println("IO Exception");
    } catch (ClassNotFoundException e){
        System.out.println("Class not found");
    }
}

/*
 * Access to the arrayList of the shapes, designed for testing from the main
 * 
 * @return arrayList containing shape objects
 */
public ArrayList<Shape> getShapes() {
    return shapes;
}

/*
 * Retrieves a shape from the arrayList of shapes by its name
 * 
 * @throws IllegalArgumentException if desired name is null
 * @param String shapeName desired name of the shape
 * @return shape that corresponding to the given name
 */
public Shape getShape (String shapeName) {
    if (shapeName == null) {
            throw new IllegalArgumentException("Shape name cannot be null");
        }
    Shape shape = null;
    for (int i = 0; i < shapes.size(); i++) {
        if (shapes.get(i).getName().equals(shapeName)) {
            shape = shapes.get(i);
        }
    }
    return shape;
}

/*
 * Verbal report of the class
 */
public String toString() {
    String info = "";
    info += this.getClass().getName() + "/n";
    for (int x = 0; x < shapes.size(); x++) {
        info += shapes.get(x) + "/n";
    }
    return info;
}
}
