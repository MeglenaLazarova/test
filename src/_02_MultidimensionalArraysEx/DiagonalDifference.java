package _02_MultidimensionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = input;
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }

        for (int j = 0; j < n; j++) {
                sum -= matrix[n-1-j][j];
        }


        System.out.println(Math.abs(sum));
    }
}
