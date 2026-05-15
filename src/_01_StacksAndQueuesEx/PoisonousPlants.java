package _01_StacksAndQueuesEx;

import java.util.*;


public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        Map<Integer, Integer> plants = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int number = scan.nextInt();

            plants.put(i, number);
        }

        int days = 0;

        List<Integer> plantsForRemove = new ArrayList<>();

        for (int i = 0; i < plants.size(); i++) {

            for (int j = 0; j < plantsForRemove.size(); j++) {
                plants.remove(plantsForRemove.get(j));
            }

            Iterator<Map.Entry<Integer, Integer>> it = plants.entrySet().iterator();

            Map.Entry<Integer, Integer> current = it.next();

            plantsForRemove = new ArrayList<>();

            boolean isRemoved = false;

            while (it.hasNext()) {
                Map.Entry<Integer, Integer> next = it.next();

                int plant1 = current.getKey();
                int poison1 = current.getValue();

                int plant2 = next.getKey();
                int poison2 = next.getValue();



                if (poison1 < poison2) {
                    plantsForRemove.add(plant2);
                    isRemoved = true;
                }

                current = next; // преместваме се напред
            }


            if (isRemoved){
                days++;
            }

        }

        System.out.println(days);

    }
}
