package _02_MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[rows][rows];

        for (int i = 0; i < rows; i++) {
            int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = input;
        }

        for (int i = 0; i < rows; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        for (int i = 0; i < rows ; i++) {
            System.out.print(matrix[rows-1-i][i] + " ");
        }
    }
}
