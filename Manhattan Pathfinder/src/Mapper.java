import java.io.*;
import org.jetbrains.annotations.*;
class Mapper {
    private static int i,j, x, y;

    public Mapper(){
        x = 0;
        y = 0;
        j = 0;
    }

    @NotNull
    @Contract("_ -> param1")
    static int[][] mapObjectives() throws IOException {
        final String filename = "input.in";
        int[][] points = new int[3][2];
        FileReader fr = new FileReader("src\\input.in");
        while ((i = fr.read()) != -1){
            if((char) i == 'B'){
                points[0][0] = x;
                points[0][1] = y;
//                System.out.format("B (%d, %d)" ,x, y);
            }
            if((char) i == 'L'){
                points[1][0] = x;
                points[1][1] = y;
//                System.out.format("L (%d, %d)" ,x, y);
            }
            if((char) i == 'R'){
                points[2][0] = x;
                points[2][1] = y;
                System.out.format("R (%d, %d)" ,x, y);
            }
            y++;
            if((char) i == '\n'){
                y=0;
                x++;
            }
        }
        return points;
    }

    @NotNull
    static int[][] createNodes() throws IOException {
        final String filename = "input.in";
        int[][] points = new int[97][2];
        FileReader fr = new FileReader("src\\input.in");
        while ((i = fr.read()) != -1){
            if((char) i == '.'){
                points[j][0] = x;
                points[j][1] = y;
                j++;
//                System.out.format("Dot (%d, %d) %d" ,x, y,j);
            }
            y++;
            if((char) i == '\n'){
                y=0;
                x++;
            }
        }
        System.out.format("%d",j);
        return points;
    }
}
