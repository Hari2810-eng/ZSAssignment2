import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DungeonGame3 {
    private int[][] grid;
    private int m;
    private int n;
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // Up, Right, Down, Left

    DungeonGame3(int m, int n) {
        grid = new int[m][n];
        this.m = m;
        this.n = n;
    }

    public int findMinSteps(int adventureX, int adventureY, int goldX, int goldY, int[][][] previous) {
        if (adventureX == goldX && adventureY == goldY) {
            return 0;
        }
        
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{goldX, goldY});
        dp[goldX][goldY] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int currentSteps = dp[currentX][currentY];

            for (int[] direction : DIRECTIONS) {
                int newX = currentX + direction[0];
                int newY = currentY + direction[1];

                if (newX >= 0 && newY >= 0 && newX < m && newY < n && dp[newX][newY] == Integer.MAX_VALUE) {
                    dp[newX][newY] = currentSteps + 1;
                    queue.add(new int[]{newX, newY});
                    previous[newX][newY] = new int[]{currentX, currentY};  // Track the previous cell
                }
            }
        }

        return dp[adventureX][adventureY] == Integer.MAX_VALUE ? -1 : dp[adventureX][adventureY];
    }

    public void printPath(int adventureX, int adventureY, int goldX, int goldY, int[][][] previous) {
        LinkedList<int[]> path = new LinkedList<>();
        int currentX = adventureX;
        int currentY = adventureY;
        while (currentX != goldX || currentY != goldY) {
            path.add(new int[]{currentX, currentY});
            int[] prev = previous[currentX][currentY];
            currentX = prev[0];
            currentY = prev[1];
        }
        path.add(new int[]{goldX, goldY});

        System.out.println("Path:");
        for (int[] p : path) {
            System.out.println("(" + (p[0] + 1) + "," + (p[1] + 1) + ") ->");
        }
    }

    public static void game(int adventureX, int adventureY, int goldX, int goldY, int monsterX, int monsterY, int m, int n) {
        DungeonGame3 dungeon = new DungeonGame3(m, n);
        adventureX -= 1;
        adventureY -= 1;
        goldX -= 1;
        goldY -= 1;
        monsterX -= 1;
        monsterY -= 1;

        int[][][] previous = new int[m][n][2];

        int adventureStep = dungeon.findMinSteps(adventureX, adventureY, goldX, goldY, previous);
        int monsterStep = dungeon.findMinSteps(monsterX, monsterY, goldX, goldY, new int[m][n][2]); 

        System.out.println("Adventurer steps: " + adventureStep + ", Monster steps: " + monsterStep);

        if (adventureStep == -1) {
            System.out.println("No possible solution");
        } else if (adventureStep > monsterStep) {
            System.out.println("No possible solution");
        } else {
            System.out.println("Minimum number of steps: " + adventureStep);
            dungeon.printPath(adventureX, adventureY, goldX, goldY, previous);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dimensions of Dungeon (mx n): ");
        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println("\nPosition of adventurer: ");
        int adventureX = sc.nextInt();
        int adventureY = sc.nextInt();

        System.out.println("\nPosition of gold: ");
        int goldX = sc.nextInt();
        int goldY = sc.nextInt();

        System.out.println("Position of monster: ");
        int monsterX = sc.nextInt();
        int monsterY = sc.nextInt();

        game(adventureX, adventureY, goldX, goldY, monsterX, monsterY, m, n);
    }
}
