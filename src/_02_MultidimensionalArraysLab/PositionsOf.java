package _02_MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        int[][] arr = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int [] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[i] = numbers;
        }

        int numbToFind = Integer.parseInt(scan.nextLine());

        boolean isFound = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == numbToFind){
                    System.out.printf("%d %d%n",i, j);
                    isFound = true;
                }
            }
        }

        if (!isFound){
            System.out.println("not found");
        }
    }
}
