import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
public class Main {
    public static void main(String[] args)  throws FileNotFoundException {
        System.out.print('\u000C');
        ShapeLibrary shapeLib  = new ShapeLibrary();
        System.out.println(shapeLib.getShape("square"));
        
        Drawing drawing1 = new Drawing(shapeLib, new File("Instruct-Simple.txt"));
        Drawing drawing2 = new Drawing(shapeLib, new File("Instruct-Rand.txt"));
        Drawing drawing3 = new Drawing(shapeLib, new File("Instruct-RepeatOffset.txt"));
        Drawing drawing4 = new Drawing(shapeLib, new File("Instruct-Gradient.txt"));
        Drawing drawing5 = new Drawing(shapeLib, new File("Instruct-Rotate.txt"));
        Drawing drawing6 = new Drawing(shapeLib, new File("Instruct-Ugly-Bird.txt"));
        Drawing drawing7 = new Drawing(shapeLib, new File("Instruct-Rocket.txt"));
        drawing7.draw();
        drawing6.draw();
        drawing5.draw();
        drawing4.draw();
        drawing3.draw();
        drawing2.draw();
        drawing1.draw();
        // System.out.println(shapeLib.getArrayList().get(0).getName());
        //System.out.println(Arrays.toString(shapeLib.getShapes().get(0).getXOfPoints()));
        // System.out.println(drawing1.getNameShape());
        // System.out.println(drawing1.getShapeStus());
        // System.out.println(shapeLib);
    }
}
