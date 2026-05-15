package _02_MultidimensionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] size = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int rows = size[0];
        int cols = size[1];

        int[][] parking = new int[rows][cols];

        String input = scan.nextLine();

        while (!input.equals("stop")) {
            String[] parts = input.split(" ");
            int entryRow = Integer.parseInt(parts[0]);
            int targetRow = Integer.parseInt(parts[1]);
            int targetCol = Integer.parseInt(parts[2]);

            int distance = Math.abs(entryRow - targetRow) + 1; // +1 за влизането в реда

            // Ако мястото е свободно
            if (parking[targetRow][targetCol] == 0) {
                parking[targetRow][targetCol] = 1;
                distance += targetCol;
                System.out.println(distance);
            } else {
                // Търсим най-близко свободно място в реда
                int bestSpot = -1;
                int minDistance = Integer.MAX_VALUE;

                for (int c = 1; c < cols; c++) {
                    if (parking[targetRow][c] == 0) {
                        int diff = Math.abs(c - targetCol);
                        if (diff < minDistance) {
                            minDistance = diff;
                            bestSpot = c;
                        }
                    }
                }

                if (bestSpot == -1) {
                    System.out.printf("Row %d full%n", targetRow);
                } else {
                    parking[targetRow][bestSpot] = 1;
                    distance += bestSpot;
                    System.out.println(distance);
                }
            }

            input = scan.nextLine();
        }
    }
}
