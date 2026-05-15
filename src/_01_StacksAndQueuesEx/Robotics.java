package _01_StacksAndQueuesEx;

import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(";");

        Map<String, Integer> robots = new LinkedHashMap<>();

        for (String s : input) {
            String[] inp = s.split("-");
            robots.put(inp[0], Integer.parseInt(inp[1]));
        }

        String[] time = scan.nextLine().split(":");

        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int sec = Integer.parseInt(time[2]);

        int currentTime = hours * 3600 + minutes * 60 + sec;

        ArrayDeque<String> products = new ArrayDeque<>();

        String product = scan.nextLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = scan.nextLine();
        }

        int[] busyUntil = new int[robots.size()];
        String[] robotNames = robots.keySet().toArray(new String[0]);
        int[] processTimes = robots.values().stream().mapToInt(i -> i).toArray();

        while (!products.isEmpty()) {
            currentTime++; // Увеличаваме текущото време с 1 секунда навсякъде в началото
            boolean assigned = false;

            for (int i = 0; i < robotNames.length; i++) {
                if (busyUntil[i] <= currentTime) {
                    String currentProduct = products.poll();

                    if (currentProduct != null) {
                        int h = (currentTime / 3600) % 24;
                        int m = (currentTime % 3600) / 60;
                        int s = currentTime % 60;
                        System.out.printf("%s - %s [%02d:%02d:%02d]%n", robotNames[i], currentProduct, h, m, s);
                        busyUntil[i] = currentTime + processTimes[i];
                        assigned = true;
                        break;
                    }
                }
            }

            if (!assigned) {
                // в такъв случай просто ще изчакаме 1 секунда отново
            }
        }
    }
}
