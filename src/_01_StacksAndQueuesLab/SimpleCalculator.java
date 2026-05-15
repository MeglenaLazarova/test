package _01_StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int number = Integer.parseInt(input[0]);

        numbers.add(number);

        for (int i = 1; i < input.length; i+=2) {
            String sign = input[i];
            int nextNumber = Integer.parseInt(input[i+1]);

            if (sign.equals("+")){
                numbers.add(nextNumber);
            } else {
                numbers.add(-nextNumber);
            }
        }

        int result = 0;

        for (int n : numbers){
            result += n;
        }

        System.out.println(result);

    }
}
