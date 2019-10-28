import java.io.*;
import org.jetbrains.annotations.*;
class Mapper {
    private static int i,j, x, y;
    private static int[][] objectivePoints = new int[3][2];
    private static int[][] mapNodes = new int[97][2];
    private static FileReader fr;

    public Mapper() {
        x = 0;
        y = 0;
        j = 0;
    }

    private static void chooseFile() throws FileNotFoundException {
        fr = new FileReader("src\\input.in");
    }


    @NotNull
    static int[][] mapObjectives() throws IOException {
        chooseFile();
        while ((i = fr.read()) != -1){
            if((char) i == 'B'){
                objectivePoints[0][0] = x;
                objectivePoints[0][1] = y;
                System.out.format("B (%d, %d)" ,x, y);
            }
            if((char) i == 'L'){
                objectivePoints[1][0] = x;
                objectivePoints[1][1] = y;
//                System.out.format("L (%d, %d)" ,x, y);
            }
            if((char) i == 'R'){
                objectivePoints[2][0] = x;
                objectivePoints[2][1] = y;
//                System.out.format("R (%d, %d)" ,x, y);
            }
            y++;
            if((char) i == '\n'){
                y=0;
                x++;
            }
        }
        return objectivePoints;
    }

    @NotNull
    static int[][] createNodes() throws IOException {
        chooseFile();
        while ((i = fr.read()) != -1){
            if((char) i == '.'){
                mapNodes[j][0] = x;
                mapNodes[j][1] = y;
                j++;
//                System.out.format("Dot (%d, %d) %d" ,x, y,j);
            }
            y++;
            if((char) i == '\n'){
                y=0;
                x++;
            }
        }
//        System.out.format("%d",j);
        return mapNodes;
    }
}
