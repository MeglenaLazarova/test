package _02_MultidimensionalArraysEx;

import com.sun.source.tree.BinaryTree;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] n = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = n[0];
        int cols = n[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = input;
        }

        int sum = 0;
        int[][] newMatrix = new int[3][3];

        for (int i = 0; i < matrix.length-2; i++) {
            for (int j = 0; j < matrix[i].length-2; j++) {
                int current = 0;
                int[][] currentMatrix = new int[3][3];

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        current+=matrix[i+k][j+l];
                        currentMatrix[k][l] = matrix[i+k][j+l];
                    }
                }
                if (current > sum){
                    sum = current;
                    newMatrix = currentMatrix;
                }
            }
        }
        System.out.println("Sum = " + sum);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
