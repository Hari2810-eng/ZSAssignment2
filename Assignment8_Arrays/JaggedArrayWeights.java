import java.util.Scanner;

public class JaggedArrayWeights {

    public static void addWeight(int[][] weights, int[] sizes, int personIndex, int weight) {
        if (personIndex >= 0 && personIndex < weights.length) {
            if (sizes[personIndex] == weights[personIndex].length) {
                int newSize = sizes[personIndex] == 0 ? 1 : weights[personIndex].length * 2;
                int[] newWeights = new int[newSize];
                System.arraycopy(weights[personIndex], 0, newWeights, 0, sizes[personIndex]);
                weights[personIndex] = newWeights;
            }
            weights[personIndex][sizes[personIndex]++] = weight;
        } else {
            System.out.println("Invalid person index.");
        }
    }

    public static int getMinimumWeight(int[][] weights, int[] sizes, int personIndex) {
        if (personIndex >= 0 && personIndex < weights.length) {
            if (sizes[personIndex] == 0) {
                System.out.println("No weights recorded for person " + (personIndex + 1));
                return -1;
            }
            int minWeight = Integer.MAX_VALUE;
            for (int i = 0; i < sizes[personIndex]; i++) {
                if (weights[personIndex][i] < minWeight) {
                    minWeight = weights[personIndex][i];
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

        int[][] weights = new int[N][];
        int[] sizes = new int[N];

        for (int i = 0; i < N; i++) {
            weights[i] = new int[0]; 
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
                    addWeight(weights, sizes, personIndex, weight);
                    break;
                case 2:
                    System.out.print("Enter the person index (0 to " + (N - 1) + "): ");
                    personIndex = scanner.nextInt();
                    int minWeight = getMinimumWeight(weights, sizes, personIndex);
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
