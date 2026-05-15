package _01_StacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());



        if (n <= 1){
            System.out.println(1);
        } else {
            System.out.println(getFibonacci(n));

        }

    }

    private static long getFibonacci(long n) {
        if (n == 0) {
            return 0; // базов случай за 0та позиция
        }
        if (n == 1 || n == 2) {
            return 1; // базов случай за 1ва и 2ра позиция
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2); // рекурсивно изчисление
    }
}
