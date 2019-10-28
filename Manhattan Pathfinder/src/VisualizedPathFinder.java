import org.jetbrains.annotations.*;
import processing.core.PApplet;
import java.io.*;

public class VisualizedPathFinder extends PApplet {
    private static int[][] objectives = new int[3][2];
    private static int[][] mapNodes = new int[97][2];
    private static int[][] shortestPath;
    private static final int GAP = 10;
    private static final int SIZE = 15;

    public static void main(String[] args) {
        PApplet.main("VisualizedPathFinder", args);
    }

    public void settings() {
        fullScreen();
    }

    public void setup() {
        try {
            objectives = Mapper.mapObjectives();
            mapNodes = Mapper.createNodes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void draw() {

    }
}