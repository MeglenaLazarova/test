package _02_MultidimensionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] n = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = n[0];
        int cols = n[1];

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] input = scan.nextLine().split(" ");
            matrix[i] = input;
        }


        String[] commands = scan.nextLine().split(" ");

        while (!commands[0].equals("END")){
            boolean ifIsOk = true;
            if (commands[0].equals("swap") && commands.length == 5){

                int row1 = Integer.parseInt(commands[1]);
                int col1 = Integer.parseInt(commands[2]);
                int row2 = Integer.parseInt(commands[3]);
                int col2 = Integer.parseInt(commands[4]);

                if (!(row1 <= rows) || !(row2 <= rows)
                        || !(col1 <= cols) || !(col2 <= cols)){
                    System.out.println("Invalid input!");
                    ifIsOk = false;
                } else {
                    String swap1 = matrix[row1][col1];
                    String swap2 = matrix[row2][col2];

                    matrix[row1][col1] = swap2;
                    matrix[row2][col2] = swap1;
                }

            } else {
                System.out.println("Invalid input!");
                ifIsOk = false;
            }

            if (ifIsOk){
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            commands = scan.nextLine().split(" ");
        }

    }
}
