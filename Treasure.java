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

        Scanner myObj = new Scanner(System.in);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++){
                treasure[i][j] = false;
            }
        }

        treasure[6][4] = true;
        tree[1][0] = true;
        tree[2][4] = true;
        tree [3][1] = true;
        mound[1][5] = true;
        mound[4][3] = true;
        mound[5][5] = true;
        
        for (int i = 0; i < 7; i++){
            System.out.println();
            for (int j = 0; j< 7; j++){
                System.out.print(" ? ");
            }
        }

        while(gameOver == false){
            System.out.println();
            System.out.printf("You are now at location (%d,%d)\n", row, column);
            System.out.println("Which way would you like to go - type up, down, left, or right");
            String direction = myObj.next();
            
            // row and column statements
            if (direction.equals("up")){
                if (row == 0){
                    System.out.println("You cannot go there because of the ocean");
                }
                else {
                    row = row - 1;
                }
            } else if (direction.equals("down")){
                if (row == 6){
                    System.out.println("You cannot go there because of the ocean");
                }
                else {
                    row = row + 1;
                }
            } else if ((direction.equals("left"))){
                if (column == 0){
                    System.out.println("You cannot go there because of the ocean");
                }
                else {
                    column = column - 1;
                }
            } else if (direction.equals("right")){
                if (column == 6){
                    System.out.println("You cannot go there because of the ocean");
                }
                else {
                    column = column + 1;
                }
            } else if (direction.equals("quit")){
                gameOver = true;
                System.out.println("Play again next time!");
            }

            board[row][column] = true;
            updateBoard(board, treasure, tree, mound);
            
            // Display message explaining what is in that location
            if(tree[row][column]){
                System.out.println("There is a tree");
            } 
            else if (mound[row][column]){
                System.out.println("There is a mound");
            }
            else if(treasure[row][column]){
                System.out.println("Congratulations, you got the treasure!");
                gameOver = true;
            }
            else {
                System.out.println("Empty, move again!");
            }
        }
    }


    public static void updateBoard(boolean[][] upBoard, boolean[][] treasure, boolean[][] tree, boolean mound[][]) {
        System.out.print('\u000C');
        for (int i = 0; i < 7; i++){
            System.out.println();
            for (int j = 0; j < 7; j++){
                if(upBoard[i][j] == true && treasure[i][j] == true){
                    System.out.print(" 🏆 ");
                }
                else if (upBoard[i][j] == true && tree[i][j] == true){
                    System.out.print(" 🌲 ");
                }
                else if (upBoard[i][j] == true && mound[i][j] == true){
                    System.out.print(" 🏜️ ");
                }
                else if (upBoard[i][j] == true && treasure [i][j] == false && tree [i][j] == false && mound [i][j] == false){
                    System.out.print(" O ");
                }
                else {
                    System.out.print(" ? ");
                }
            }
        }
    }
}