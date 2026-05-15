package _01_StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = scan.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (number == 0) {
            System.out.println(0);
        } else {
            while (number != 0) {
                stack.push(number % 2);
                number /= 2;
            }

            for (int n : stack) {
                System.out.print(n);
            }

        }
    }
}
