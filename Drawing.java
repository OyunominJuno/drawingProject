import java.io.File;
import java.io.FileNotFoundException;
import java.awt.Color; 
import java.util.Scanner; 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.Polygon;
import java.util.Random;
/**
 * Write a description of class drawin here.
 *
 * @author  Oyunomin Munkhkhurel
 * @version 1/31/2018
 */
public class Drawing {
    // instance variables
    private ShapeLibrary lib;
    private CanvasInstruction canvasInst;
    private Graphics pen;
    private ArrayList<DrawInstruction> drawInsts = new ArrayList<DrawInstruction>(); 
    private int countDrawInst;
    /**
     * Constructor for objects of class drawin
     */
    public Drawing(ShapeLibrary lib, File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        canvasInst = CanvasInstruction.readFromFile(scan);
        countDrawInst = 0;
        while (scan.hasNext()) {
            countDrawInst++;
            drawInsts.add(DrawInstruction.readFromFile(scan));
        }
        this.lib = lib;
        scan.close();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void draw() {
        DrawingPanel panel = new DrawingPanel(canvasInst.getWidth(), canvasInst.getHeight());
        
        pen = panel.getGraphics();
        Random random = new Random();
        if (canvasInst.getIsGradient()) {
            Color top = canvasInst.getColorTop();
            Color bottom = canvasInst.getColorBottom();
            int topBlue = top.getBlue();
            int topGreen = top.getGreen();
            int topRed = top.getRed();
            int bottomBlue = bottom.getBlue();
            int bottomGreen = bottom.getGreen();
            int bottomRed = bottom.getRed();
            int difBlue = topBlue - bottomBlue;
            int difGreen = topGreen - bottomGreen;
            int difRed = topRed - bottomRed;
            if (difBlue != 0 || difGreen != 0 || difRed != 0) {
                difBlue = difBlue / canvasInst.getHeight();
                difGreen = difGreen / canvasInst.getHeight();
                difRed = difRed  / canvasInst.getHeight();
            } else {
                difBlue = 0;
                difGreen = 0;
                difRed = 0;
            }
            
            for (int pix = 0; pix < canvasInst.getWidth(); pix++) {
                // Color tempoColor = new Color(topBlue += difBlue, topGreen += difGreen, topRed += difRed);
                // pen.setColor(tempoColor);
                Color tempoColor = new Color(topRed -= difRed, topGreen -= 0.2675, topBlue -= difBlue);
                pen.setColor(tempoColor);
                pen.drawLine(0, pix, canvasInst.getWidth(), pix);
            }
            //pen.drawLine(0, 0, 0, canvasInst.getWidth());
        } else {
            panel.setBackground(canvasInst.getColorSolid());
        }
        
        for( int idx = 0; idx < countDrawInst; idx++) {
            String shapeName = drawInsts.get(idx).getShapeName();
            Shape shape = lib.getShape(shapeName);
            pen.setColor(drawInsts.get(idx).getColor());
            int[] xOfPoints = shape.getXOfPoints();
            int[] yOfPoints = shape.getYOfPoints();
            int startingX = drawInsts.get(idx).getStartingX();
            int startingY = drawInsts.get(idx).getStartingY();
            int scale = drawInsts.get(idx).getScalePercent();
            int repeats = drawInsts.get(idx).getRepeats();
            
            //scaling
            for (int index = 0; index < shape.getXOfPoints().length; index++) {
                if (scale >= 100) {
                    xOfPoints[index] *= scale / 100;
                    yOfPoints[index] *= scale / 100;
                } else {
                    xOfPoints[index] /= 100 / scale;
                    yOfPoints[index] /= 100 / scale;
                }
                xOfPoints[index] += startingX;
                yOfPoints[index] += startingY;
            }
            if (drawInsts.get(idx).getFilled()) {
                pen.fillPolygon(xOfPoints, yOfPoints,xOfPoints.length);
            } else {
                pen.drawPolygon(xOfPoints, yOfPoints,xOfPoints.length);
            }
            
            if(drawInsts.get(idx).getRepeatOffsetX() != 0 || drawInsts.get(idx).getRepeatOffsetY() != 0) {
                for (int rep = 0; rep < repeats; rep++) {
                    for (int index = 0; index < shape.getXOfPoints().length; index++) {
                        if (scale >= 100) {
                            xOfPoints[index] *= scale / 100;
                            yOfPoints[index] *= scale / 100;
                        } else {
                            xOfPoints[index] /= 100 / scale;
                            yOfPoints[index] /= 100 / scale;
                        }
                        xOfPoints[index] += drawInsts.get(idx).getRepeatOffsetX();
                        yOfPoints[index] += drawInsts.get(idx).getRepeatOffsetY();
                    }
                    if (drawInsts.get(idx).getFilled()) {
                        pen.fillPolygon(xOfPoints, yOfPoints,xOfPoints.length);
                    } else {
                        pen.drawPolygon(xOfPoints, yOfPoints,xOfPoints.length);
                    } 
                }
            }
            
            if(startingX < 0 && startingY < 0) {
                for (int rep = 0; rep < repeats; rep++) {
                    for (int index = 0; index < shape.getXOfPoints().length; index++) {
                        if (scale >= 100) {
                            xOfPoints[index] *= scale / 100;
                            yOfPoints[index] *= scale / 100;
                        } else {
                            xOfPoints[index] /= 100 / scale;
                            yOfPoints[index] /= 100 / scale;
                        }
                        xOfPoints[index] += 100;
                        yOfPoints[index] += 100;
                    }
                    if (drawInsts.get(idx).getFilled()) {
                        pen.fillPolygon(xOfPoints, yOfPoints,xOfPoints.length);
                    } else {
                        pen.drawPolygon(xOfPoints, yOfPoints,xOfPoints.length);
                    } 
                }
            }
            
            
        }
    }
}        
           