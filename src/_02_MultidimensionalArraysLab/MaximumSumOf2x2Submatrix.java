package _02_MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
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

        int[][] newMatrix = new int[2][2];
        int sum = 0;
        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = 0; j < matrix[i].length-1; j++) {
                int currentSum = matrix[i][j] + matrix[i][j+1] + matrix[i+1][j] + matrix[i+1][j+1];

                if (currentSum > sum){
                    sum = currentSum;
                    newMatrix = new int[][]{
                            {matrix[i][j], matrix[i][j+1]},
                            {matrix[i+1][j], matrix[i+1][j+1]}
                    };
                }
            }
        }

        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(sum);
    }
}
