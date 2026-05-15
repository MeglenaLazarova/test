package _02_MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] firstMatrix = scan.nextLine().split(" ");

        int[][] matrix1 = new int[Integer.parseInt(firstMatrix[0])][Integer.parseInt(firstMatrix[1])];
        for (int i = 0; i < Integer.parseInt(firstMatrix[0]); i++) {
            int[] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix1[i] = arr;
        }

        int[] secondMatrix = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix2 = new int[secondMatrix[0]][secondMatrix[1]];
        for (int i = 0; i < secondMatrix[0]; i++) {
            int[] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix2[i] = arr;

        }

        if(isEqual(firstMatrix, secondMatrix, matrix1, matrix2)){
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    private static boolean isEqual(String[] firstMatrix, int[] secondMatrix, int[][] matrix1, int[][] matrix2) {
        if (Integer.parseInt(firstMatrix[0]) != secondMatrix[0]) {
            return false;
        } else if (Integer.parseInt(firstMatrix[1]) != secondMatrix[1]) {
            return false;
        } else {
            for (int row = 0; row < matrix1.length; row++) {
                for (int col = 0; col < matrix1[row].length; col++) {
                    if (matrix1[row][col] != matrix2[row][col]){
                        return false;
                    }
                }
            }
        return true;
        }
    }
}
