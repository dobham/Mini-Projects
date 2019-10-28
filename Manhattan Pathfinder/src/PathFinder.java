import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;

public class PathFinder {
    private static int[][] objectives = new int[3][2];

    public PathFinder() throws IOException {
        objectives = Mapper.mapObjectives();
    }

    private static int setShortestPath(){
        int shortestPath;
        if (((objectives[1][0] == objectives[0][0] && objectives[1][0] == objectives[2][0] && objectives[2][0] == objectives[0][0]) || (objectives[1][1] == objectives[0][1] && objectives[1][1] == objectives[2][1] && objectives[2][1] == objectives[0][1]))) {
            if (((objectives[2][0] > objectives[0][0] && objectives[2][0] < objectives[1][0]) || (objectives[2][0] > objectives[1][0] && objectives[2][0] < objectives[0][0])) || ((objectives[2][1] > objectives[0][1] && objectives[2][1] < objectives[1][1]) || (objectives[2][1] > objectives[1][1] && objectives[2][1] < objectives[0][1]))) {
                shortestPath = ((objectives[0][0] - objectives[1][0])) + (Math.abs(objectives[0][1] - objectives[1][1])) + 1;
            } else {
                shortestPath = (Math.abs(objectives[0][0] - objectives[1][0])) + (Math.abs(objectives[0][1] - objectives[1][1])) - 1;
            }
        } else {
            shortestPath = (Math.abs(objectives[0][0] - objectives[1][0])) + (Math.abs(objectives[0][1] - objectives[1][1])) - 1;
        }
        return shortestPath;
    }

    static int[][] shortestPathArray(){
        int[][] shortestPathArray = new int[setShortestPath()][2];
        int[] xArr = new int[setShortestPath()], yArr = new int[setShortestPath()];
        if (((objectives[1][0] == objectives[0][0] && objectives[1][0] == objectives[2][0] && objectives[2][0] == objectives[0][0]) || (objectives[1][1] == objectives[0][1] && objectives[1][1] == objectives[2][1] && objectives[2][1] == objectives[0][1]))) {
            if (((objectives[2][0] > objectives[0][0] && objectives[2][0] < objectives[1][0]) || (objectives[2][0] > objectives[1][0] && objectives[2][0] < objectives[0][0])) || ((objectives[2][1] > objectives[0][1] && objectives[2][1] < objectives[1][1]) || (objectives[2][1] > objectives[1][1] && objectives[2][1] < objectives[0][1]))) {
                //Rock is inbetween

            } else {
                //Rock is not inbetween
                if ((Math.abs(objectives[0][0] - objectives[1][0]) == 0)){
                    int x = objectives[0][0];
                    for (int y = objectives[0][1], i = 0; y < Math.abs(objectives[0][1] - objectives[1][1])-1; y++, i++) {
                        xArr[i] = x;
                        yArr[i] = y;
                    }
                }
                if ((Math.abs(objectives[0][1] - objectives[1][1]) == 0)){
                    int y = objectives[0][1];
                    for (int x = objectives[0][0], i = 0; y < Math.abs(objectives[0][0] - objectives[1][0])-1; y++, i++) {
                        xArr[i] = x;
                        yArr[i] = y;
                    }
                }
            }
        } else {
            //Rock is not inbetween
            if ((Math.abs(objectives[0][0] - objectives[1][0]) == 0)){
                int x = objectives[0][0];
                for (int y = objectives[0][1], i = 0; y < Math.abs(objectives[0][1] - objectives[1][1])-1; y++, i++) {
                    xArr[i] = x;
                    yArr[i] = y;
                }
            }
            if ((Math.abs(objectives[0][1] - objectives[1][1]) == 0)){
                int y = objectives[0][1];
                for (int x = objectives[0][0], i = 0; y < Math.abs(objectives[0][0] - objectives[1][0])-1; y++, i++) {
                    xArr[i] = x;
                    yArr[i] = y;
                }
            }
        }
        return shortestPathArray;
    }
}


/* THE C CODE
    int main(){
    FILE *input;
    FILE *output;
    input = fopen("..\\input.in","r");
    int objectives[3][2];
    int path;
    for (int x = 0; x < 11; x++) {
        for (int y = 0; y <= 11; y++) {
            int value = fgetc(input);
            ((value == 'B') ? objectives[0][0] = x, objectives[0][1] = y : 0);
            ((value == 'L') ? objectives[1][0] = x, objectives[1][1] = y : 0);
            ((value == 'R') ? objectives[2][0] = x, objectives[2][1] = y : 0);
        }
    }
    fclose(input);
    (((objectives[1][0] == objectives[0][0] && objectives[1][0] == objectives[2][0] && objectives[2][0] == objectives[0][0]) || (objectives[1][1] == objectives[0][1] && objectives[1][1] == objectives[2][1] && objectives[2][1] == objectives[0][1])) ? (((objectives[2][0] > objectives[0][0] && objectives[2][0] < objectives[1][0]) || (objectives[2][0] > objectives[1][0] && objectives[2][0] < objectives[0][0])) || ((objectives[2][1] > objectives[0][1] && objectives[2][1] < objectives[1][1]) || (objectives[2][1] > objectives[1][1] && objectives[2][1] < objectives[0][1])) ? (path=(fabs(objectives[0][0]-objectives[1][0]))+(fabs(objectives[0][1]-objectives[1][1]))+1) : (path=(fabs(objectives[0][0]-objectives[1][0]))+(fabs(objectives[0][1]-objectives[1][1]))-1)) : (path=(fabs(objectives[0][0]-objectives[1][0]))+(fabs(objectives[0][1]-objectives[1][1]))-1));
    output = fopen("..\\output.out", "w");
    fprintf(output, "%d", path);
    fclose(output);
    return 0;
}*/