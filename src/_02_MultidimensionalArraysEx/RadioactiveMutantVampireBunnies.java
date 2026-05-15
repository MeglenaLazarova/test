package _02_MultidimensionalArraysEx;

import java.util.*;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] size = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int rows = size[0];
        int cols = size[1];

        String[][] matrix = new String[rows][cols];

        int playerRow = -1;
        int playerCol = -1;

        // Read matrix
        for (int r = 0; r < rows; r++) {
            matrix[r] = scan.nextLine().split("");
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c].equals("P")) {
                    playerRow = r;
                    playerCol = c;
                }
            }
        }

        String[] moves = scan.nextLine().split("");

        boolean isDead = false;
        boolean isOut = false;

        int finalRow = playerRow;
        int finalCol = playerCol;

        for (String move : moves) {

            // Move player
            int nextRow = playerRow;
            int nextCol = playerCol;

            switch (move) {
                case "U" -> nextRow--;
                case "D" -> nextRow++;
                case "L" -> nextCol--;
                case "R" -> nextCol++;
            }

            // Check if player escapes
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                isOut = true;
                matrix[playerRow][playerCol] = ".";
            } else {
                // Player moves inside matrix
                if (matrix[nextRow][nextCol].equals("B")) {
                    isDead = true;
                } else {
                    matrix[playerRow][playerCol] = ".";
                    matrix[nextRow][nextCol] = "P";
                }
                playerRow = nextRow;
                playerCol = nextCol;
            }

            // Spread bunnies
            List<int[]> newBunnies = new ArrayList<>();

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (matrix[r][c].equals("B")) {
                        if (r - 1 >= 0) newBunnies.add(new int[]{r - 1, c});
                        if (r + 1 < rows) newBunnies.add(new int[]{r + 1, c});
                        if (c - 1 >= 0) newBunnies.add(new int[]{r, c - 1});
                        if (c + 1 < cols) newBunnies.add(new int[]{r, c + 1});
                    }
                }
            }

            for (int[] pos : newBunnies) {
                int r = pos[0];
                int c = pos[1];

                if (matrix[r][c].equals("P")) {
                    isDead = true;
                }
                matrix[r][c] = "B";
            }

            if (isDead || isOut) {
                finalRow = playerRow;
                finalCol = playerCol;
                break;
            }
        }

        // Print final matrix
        for (String[] row : matrix) {
            System.out.println(String.join("", row));
        }

        if (isOut) {
            System.out.println("won: " + finalRow + " " + finalCol);
        } else {
            System.out.println("dead: " + finalRow + " " + finalCol);
        }
    }
}
