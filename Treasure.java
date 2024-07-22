/**
 * Treasure
 */
import java.util.Scanner;
public class Treasure {

    public static void main(String[] args) {
        boolean[][] treasure = new boolean[7][7];
        boolean[][] tree = new boolean[7][7];
        boolean[][] mound = new boolean [7][7];
        boolean[][] board = new boolean [7][7];
        boolean gameOver = false;
        int row = 0;
        int column = 0;
        int userPoints = 0;

        Scanner myObj = new Scanner(System.in);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++){
                treasure[i][j] = false;
            }
        }

        treasure[5][4] = true;
        tree[1][2] = true;
        tree[4][1] = true;
        mound[2][0] = true;
        mound[3][4] = true;
        
        for (int i = 0; i < 7; i++){
            System.out.println();
            for (int j = 0; j< 7; j++){
                System.out.print(" ? ");
            }
        }

        
    }
}