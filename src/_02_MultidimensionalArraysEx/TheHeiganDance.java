package _02_MultidimensionalArraysEx;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double playerDamage = Double.parseDouble(scan.nextLine());

        int playerRow = 7;
        int playerCol = 7;

        int playerHP = 18500;
        double heiganHP = 3000000;

        boolean hasCloud = false;
        String lastSpell = "";

        while (true) {

            if (playerHP > 0){
                heiganHP -= playerDamage;
                if (hasCloud) {
                    playerHP -= 3500;
                    hasCloud = false;
                }
            }

            if (playerHP <= 0){
                break;
            }

            if (heiganHP <= 0){
                break;
            }

            String[] input = scan.nextLine().split("\\s+");
            String spell = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);

            boolean inDamage =
                    playerRow >= row - 1 && playerRow <= row + 1 &&
                            playerCol >= col - 1 && playerCol <= col + 1;

            if (inDamage) {

                // try to move UP
                if (playerRow - 1 >= 0 &&
                        !(playerRow - 1 >= row - 1 && playerRow - 1 <= row + 1 &&
                                playerCol >= col - 1 && playerCol <= col + 1)) {
                    playerRow--;
                }
                // try to move RIGHT
                else if (playerCol + 1 < 15 &&
                        !(playerRow >= row - 1 && playerRow <= row + 1 &&
                                playerCol + 1 >= col - 1 && playerCol + 1 <= col + 1)) {
                    playerCol++;
                }
                // try to move DOWN
                else if (playerRow + 1 < 15 &&
                        !(playerRow + 1 >= row - 1 && playerRow + 1 <= row + 1 &&
                                playerCol >= col - 1 && playerCol <= col + 1)) {
                    playerRow++;
                }
                // try to move LEFT
                else if (playerCol - 1 >= 0 &&
                        !(playerRow >= row - 1 && playerRow <= row + 1 &&
                                playerCol - 1 >= col - 1 && playerCol - 1 <= col + 1)) {
                    playerCol--;
                }
                else {
                    // cannot escape → take damage
                    if (spell.equals("Cloud")) {
                        playerHP -= 3500;
                        hasCloud = true;
                        lastSpell = "Plague Cloud";
                    } else {
                        playerHP -= 6000;
                        lastSpell = "Eruption";
                    }
                }
            }
        }

        if (heiganHP <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHP);
        }

        if (playerHP <= 0) {
            System.out.println("Player: Killed by " + lastSpell);
        } else {
            System.out.println("Player: " + playerHP);
        }

        System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
    }
}
