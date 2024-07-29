import java.util.ArrayList;
import java.util.Scanner;

public class JaggedArrayWeights {

    public static void addWeight(ArrayList<ArrayList<Integer>> weights, int personIndex, int weight) {
        if (personIndex >= 0 && personIndex < weights.size()) {
            weights.get(personIndex).add(weight);
        } else {
            System.out.println("Invalid person index.");
        }
    }

    public static int getMinimumWeight(ArrayList<ArrayList<Integer>> weights, int personIndex) {
        if (personIndex >= 0 && personIndex < weights.size()) {
            ArrayList<Integer> personWeights = weights.get(personIndex);
            if (personWeights.isEmpty()) {
                System.out.println("No weights recorded for person " + (personIndex + 1));
                return -1;
            }
            int minWeight = Integer.MAX_VALUE;
            for (int weight : personWeights) {
                if (weight < minWeight) {
                    minWeight = weight;
                }
            }
            return minWeight;
        } else {
            System.out.println("Invalid person index.");
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of persons (N): ");
        int N = scanner.nextInt();

        ArrayList<ArrayList<Integer>> weights = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            weights.add(new ArrayList<>());
        }
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add weight");
            System.out.println("2. Get minimum weight of a person");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the person index (0 to " + (N - 1) + "): ");
                    int personIndex = scanner.nextInt();
                    System.out.print("Enter the weight: ");
                    int weight = scanner.nextInt();
                    addWeight(weights, personIndex, weight);
                    break;
                case 2:
                    System.out.print("Enter the person index (0 to " + (N - 1) + "): ");
                    personIndex = scanner.nextInt();
                    int minWeight = getMinimumWeight(weights, personIndex);
                    if (minWeight != -1) {
                        System.out.println("Minimum weight of person " + (personIndex + 1) + " is: " + minWeight);
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
