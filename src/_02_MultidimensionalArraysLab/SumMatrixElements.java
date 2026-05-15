package _02_MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] sizes = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = sizes[0];
        int cols = sizes[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] input = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = input;
        }

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
