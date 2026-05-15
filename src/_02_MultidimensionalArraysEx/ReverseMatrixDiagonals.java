package _02_MultidimensionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int rows = input[0];
        int cols = input[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        // 1) Диагонали, започващи от последния ред
        for (int startCol = cols - 1; startCol >= 0; startCol--) {
            int r = rows - 1;
            int c = startCol;

            while (r >= 0 && c < cols) {
                System.out.print(matrix[r][c] + " ");
                r--;
                c++;
            }
            System.out.println();
        }

        // 2) Диагонали, започващи от първата колона (без последния ред)
        for (int startRow = rows - 2; startRow >= 0; startRow--) {
            int r = startRow;
            int c = 0;

            while (r >= 0 && c < cols) {
                System.out.print(matrix[r][c] + " ");
                r--;
                c++;
            }
            System.out.println();
        }
    }
}
