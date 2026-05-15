package _02_MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        String[][] firstMatrix = new String[rows][cols];
        String[][] secondMatrix = new String[rows][cols];

        fillheMatrix(rows, scan, firstMatrix);
        fillheMatrix(rows, scan, secondMatrix);

        String[][] finalMatrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (Objects.equals(firstMatrix[i][j], secondMatrix[i][j])){
                    String letter = secondMatrix[i][j];
                    finalMatrix[i][j] = letter;
                } else {
                    finalMatrix[i][j] = "*";
                }
            }

        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(finalMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fillheMatrix(int rows, Scanner scan, String[][] matrix) {
        for (int i = 0; i < rows; i++) {
            String[] input = scan.nextLine().split(" ");
            matrix[i] = input;
        }
    }
}
