import org.jetbrains.annotations.NotNull;
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

    @NotNull
    static int[][] shortestPathArray(){
        int[][] shortestPathArray = new int[setShortestPath()][2];
        int[] xArr = new int[setShortestPath()], xArrBuff = new int[setShortestPath()], yArr = new int[setShortestPath()], yArrBuff = new int[setShortestPath()];
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
                else if ((Math.abs(objectives[0][1] - objectives[1][1]) == 0)){
                    int y = objectives[0][1];
                    for (int x = objectives[0][0], i = 0; y < Math.abs(objectives[0][0] - objectives[1][0])-1; y++, i++) {
                        xArr[i] = x;
                        yArr[i] = y;
                    }
                }
                else{
                    if ((Math.abs(objectives[0][0] - objectives[2][0]) == 0 && objectives[2][1] > objectives[0][1])){
                        int x = objectives[0][0];
                        for (int y = 0, i=0; y <= Math.abs(objectives[0][1] - objectives[2][1])-1; y++, i++) {
                            xArrBuff[i] = x;
                            yArrBuff[i] = y;
                        }
                        x++;
                        for (int i = 0; x <= Math.abs(objectives[0][0] - objectives[1][0]); x++, i++) {
                            xArr[i] = x;
                        }
                        for (int y = objectives[0][1]+1 , i = 0; y <= Math.abs(objectives[0][1] - objectives[1][1])-1; y++, i++) {
                            yArr[i] = y;
                        }
                    }
                    else if ((Math.abs(objectives[0][0] - objectives[2][0]) == 0 && objectives[2][1] < objectives[0][1])){
                        int y = objectives[0][0];
                        for (int x = 0, i=0; x <= Math.abs(objectives[0][1] - objectives[2][1])-1; x++, i++) {
                            xArrBuff[i] = x;
                            yArrBuff[i] = y;
                        }
                    }
                    else if ((Math.abs(objectives[0][1] - objectives[2][0]) == 0 && objectives[2][1] > objectives[1][1])){

                    }
                    else if ((Math.abs(objectives[0][1] - objectives[2][0]) == 0 && objectives[2][1] < objectives[1][1])){

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