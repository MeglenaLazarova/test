package _01_StacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int s = scan.nextInt();
        int x = scan.nextInt();
/*
* Second documentations for the test
*
*
 */

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            numbers.add(scan.nextInt());
        }

        for (int i = 0; i < s; i++) {
            numbers.poll();
        }

        if (numbers.isEmpty()){
            System.out.println(0);
        } else {
            int smallest = Integer.MAX_VALUE;
            boolean isMatch = false;
            for (int number : numbers) {
                if (number == x) {
                    isMatch = true;
                } else {
                    if (number < smallest) {
                        smallest = number;
                    }
                }
            }

            if (isMatch) {
                System.out.println("true");
            } else {
                System.out.println(smallest);
            }
        }
    }
}
