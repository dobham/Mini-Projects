import java.io.*;
import org.jetbrains.annotations.*;
class Mapper {
    private static int i, x, y;

    public Mapper(){
        x = 0;
        y = 0;
    }

    @Contract("_ -> param1")
    static int[][] createMap(int[][] points) throws IOException {
        final String filename = "input.in";
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
//                System.out.format("R (%d, %d)" ,x, y);
            }
            y++;
            if((char) i == '\n'){
                y=0;
                x++;
            }
        }
        return points;
    }
}
