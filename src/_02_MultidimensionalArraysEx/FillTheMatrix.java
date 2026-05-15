package _02_MultidimensionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");

        int n = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[n][n];
        
        int value = 1;

        switch (pattern){
            case "A" ->{
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[j][i] = value++;
                    }
                }
            }
            
            case "B" ->{
                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0){
                        for (int j = 0; j < n; j++) {
                            matrix[j][i] = value++;
                        }
                    } else {
                        for (int j = n-1; j >= 0; j--) {
                            matrix[j][i] = value++;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
