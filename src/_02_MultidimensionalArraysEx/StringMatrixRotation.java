package _02_MultidimensionalArraysEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> words = new ArrayList<>();

        String r = scan.nextLine();
        int rotate = Integer.parseInt(r.replaceAll("\\D+", ""));

        String input = scan.nextLine();

        while (!input.equals("END")) {
            words.add(input);
            input = scan.nextLine();
        }

        int rows = words.size();
        int cols = 0;

        for (String word : words) {
            int currentCols = word.length();

            if (currentCols > cols) {
                cols = currentCols;
            }
        }

        Character[][] matrix = new Character[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            String w = words.get(i);
                    for (int j = 0; j < matrix[i].length; j++) {
                        if (j < w.length()) {
                            matrix[i][j] = w.charAt(j);
                        } else {
                            matrix[i][j] = ' ';
                        }
            }
        }

        int degree = (rotate % 360) / 90;

        for (int m = 0; m < degree; m++) {
            int rol = matrix.length;
            int col = matrix[0].length;
            Character[][] newMatrix = new Character[col][rol];
            for (int i = 0; i < rol; i++) {
                for (int j = 0; j < col; j++) {
                    newMatrix[j][rol - 1 - i] = matrix[i][j];
                }
            }
            matrix = newMatrix;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "");
            }
            System.out.println();
        }
        }

    }

