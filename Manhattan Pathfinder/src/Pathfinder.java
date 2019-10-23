import org.jetbrains.annotations.*;
import processing.core.PApplet;
import java.io.*;

public class PathFinder extends PApplet {
    private static int[][] points = new int[3][2];

    public static void main(String[] args) {
        PApplet.main("PathFinder", args);
    }

    public void settings() { }

    public void setup() {
        Mapper map = new Mapper();
        try {
            map.createMap(points);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw() { }
}

    /* THE C CODE
    int main(){
    FILE *input;
    FILE *output;
    input = fopen("..\\input.in","r");
    int points[3][2];
    int path;
    for (int x = 0; x < 11; x++) {
        for (int y = 0; y <= 11; y++) {
            int value = fgetc(input);
            ((value == 'B') ? points[0][0] = x, points[0][1] = y : 0);
            ((value == 'L') ? points[1][0] = x, points[1][1] = y : 0);
            ((value == 'R') ? points[2][0] = x, points[2][1] = y : 0);
        }
    }
    fclose(input);
    (((points[1][0] == points[0][0] && points[1][0] == points[2][0] && points[2][0] == points[0][0]) || (points[1][1] == points[0][1] && points[1][1] == points[2][1] && points[2][1] == points[0][1])) ? (((points[2][0] > points[0][0] && points[2][0] < points[1][0]) || (points[2][0] > points[1][0] && points[2][0] < points[0][0])) || ((points[2][1] > points[0][1] && points[2][1] < points[1][1]) || (points[2][1] > points[1][1] && points[2][1] < points[0][1])) ? (path=(fabs(points[0][0]-points[1][0]))+(fabs(points[0][1]-points[1][1]))+1) : (path=(fabs(points[0][0]-points[1][0]))+(fabs(points[0][1]-points[1][1]))-1)) : (path=(fabs(points[0][0]-points[1][0]))+(fabs(points[0][1]-points[1][1]))-1));
    output = fopen("..\\output.out", "w");
    fprintf(output, "%d", path);
    fclose(output);
    return 0;
}*/